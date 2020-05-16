package com.secure.mail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.secure.mail.common.EmailConstants;
import com.secure.mail.model.MailResponse;
import com.secure.mail.util.CommonUtil;
import com.secure.mail.util.RulesUtil;

/**
 * This is an Client class used to send Secure email's.
 * 
 * @author Srinivasan Elangovan
 * @author-email Srinijavakid@gmail.com
 *
 */
public class EmailClient {

	private static File configFile = new File(EmailConstants.RULE_PROPERTY_FILE_NAME);
	private static Properties configProps = new Properties();

	static {

		/** loads email rules properties from file */
		if (configFile.exists()) {
			try {
				InputStream inputStream = new FileInputStream(configFile);
				configProps.load(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Main method for local testing
	 * 
	 * @param args
	 * @throws MessagingException
	 */
	public static void main(String[] args) throws MessagingException {
		EmailClient.sendEmail("Emailtest123@gmail.com", "Test email", "Hello World", "text/plain");
	}

	/**
	 * This is the gateway method for the client to send email.
	 * 
	 * @param receiptAddress
	 * @param subject
	 * @param emailContent
	 * @return
	 */
	public static MailResponse sendEmail(String receiptAddress, String subject, String emailContent, String format) {

		MailResponse output = new MailResponse();

		try {

			/** Get the email rule for this particular case */
			String rule = configProps.get(getRuleName(format, receiptAddress)).toString();
			MimeMessage message = prepareEmailMessage(receiptAddress, subject, emailContent, format, rule);

			/**
			 * Sending email.
			 * 
			 * Parameters: Message, retry flag and retry counter (as it is first time hence
			 * it is set to zero)
			 **/
			output = CommonUtil.send(message, format, getConditionFlag(rule.charAt(3)), 0);

		} catch (IOException | MessagingException e) {
			output.setOutput(e.getMessage());
		}

		return output;
	}

	/**
	 * Method to create the email message object.
	 * 
	 * @param receiptAddress
	 * @param subject
	 * @param emailContent
	 * @return
	 * @throws MessagingException
	 * @throws IOException
	 */
	private static MimeMessage prepareEmailMessage(String receiptAddress, String subject, String emailContent,
			String format, String rule) throws MessagingException, IOException {

		MimeMessage message = new MimeMessage(CommonUtil.createSession());
		message.setSentDate(new Date());
		message.setSubject(subject);
		message.setContent(protectContent(emailContent, rule, format, receiptAddress), format);
		message.setSender(new InternetAddress(EmailConstants.SENDER_EMAIL));
		message.setFrom(new InternetAddress(EmailConstants.SENDER_EMAIL));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiptAddress));

		return message;
	}

	/**
	 * Add encrypting logic for the email.
	 * 
	 * Rule char 1 for encrypting email content with DES. || Rule char 2 for
	 * encrypting email content with AES. || Rule char 0 to add disclaimer notice to
	 * the message content.
	 * 
	 * @param emailContent
	 * @param format
	 * @param receiptAddress
	 * @return
	 */
	private static String protectContent(String emailContent, String rule, String format, String receiptAddress) {

		String emailBody = new String();

		emailBody = emailContent;

		if (getConditionFlag(rule.charAt(1))) {
			emailBody = RulesUtil.encryptLevelOne(emailBody);
		}

		if (getConditionFlag(rule.charAt(2))) {
			emailBody = RulesUtil.encryptLevelTwo(emailBody);
		}

		if (getConditionFlag(rule.charAt(0))) {
			emailBody = RulesUtil.addDisclaimer(emailBody);
		}

		return emailBody;
	}

	/**
	 * To fetch the rule flag
	 * 
	 * @param ruleFlag
	 * @return
	 */
	private static Boolean getConditionFlag(char ruleFlag) {
		if (ruleFlag == 'X') {
			return true;
		} else if (ruleFlag == 'O') {
			return false;
		}
		return false;
	}

	/**
	 * Create rule name string from the mail input.
	 * 
	 * @param format
	 * @param receiptAddress
	 * @return
	 */
	private static String getRuleName(String format, String receiptAddress) {

		StringBuilder ruleName = new StringBuilder();
		String formatPrefix = new String();
		String resourcePrefix = new String();

		if (format.trim().contains("text/plain")) {
			formatPrefix = EmailConstants.FORMAT_PLAIN_TEXT;
		} else if (format.trim().equalsIgnoreCase("text/html")) {
			formatPrefix = EmailConstants.FORMAT_HTML;
		}

		if (getRecepientDomainFlag(receiptAddress)) {
			resourcePrefix = EmailConstants.DOMAIN_INTERNAL;
		} else {
			resourcePrefix = EmailConstants.DOMAIN_EXTERNAL;
		}

		return ruleName.append(formatPrefix).append("_").append(resourcePrefix).toString();
	}

	/**
	 * To identify recipient domain based on the email extension
	 * 
	 * @param receiptAddress
	 * @return
	 */
	private static boolean getRecepientDomainFlag(String receiptAddress) {
		return receiptAddress.trim().endsWith(EmailConstants.DOMAI_EXTENSION);
	}

}
