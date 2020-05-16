package com.secure.mail.util;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.secure.mail.common.EmailConstants;
import com.secure.mail.model.MailResponse;

/**
 * Utility class for common methods.
 * 
 * @author Srinivas
 *
 */
public class CommonUtil {

	private static ConfigUtility configUtil = new ConfigUtility();

	/**
	 * Facade mail method to switch between mock and real mail transport
	 * 
	 * @param emailMessage
	 * @return
	 * @throws MessagingException
	 * @throws IOException
	 */
	public static MailResponse send(MimeMessage emailMessage, String format, boolean retryLogicFlag, int retryCounter)
			throws MessagingException, IOException {

		/**
		 * For testing called mock method if required we can switch to real transport
		 * client as well.
		 */
		MailResponse output = sendMock(emailMessage,format);

		/**
		 * Three conditions validated for retry || mock retry code || retry logic for
		 * the case || retry count is less than three times.
		 * 
		 * Mock retry logic getting the random response code and dividing it with four,
		 * in which we might get few failures and we can test the retry logic
		 **/
		if (output.getResponseCode() % 4 == 0 && retryLogicFlag && retryCounter <= 3) {
			send(emailMessage, format, retryLogicFlag, retryCounter + 1);
		}

		return output;

	}

	/**
	 * Mock method just to display the email message.
	 * 
	 * @param emailMessage
	 * @throws MessagingException
	 * @throws IOException
	 */
	public static MailResponse sendMock(MimeMessage emailMessage,String format) throws MessagingException, IOException {

		StringBuilder outputMessage = new StringBuilder();
		outputMessage.append(
				EmailConstants.EMAIL_DATE_LABEL + emailMessage.getSentDate() + EmailConstants.TWO_LINE_SEPARATOR);
		outputMessage.append(
				EmailConstants.EMAIL_FORMAT_LABEL + format + EmailConstants.TWO_LINE_SEPARATOR);
		outputMessage
				.append(EmailConstants.EMAIL_FROM_LABEL + emailMessage.getSender() + EmailConstants.TWO_LINE_SEPARATOR);
		outputMessage.append(
				EmailConstants.EMAIL_SENT_LABEL + InternetAddress.toString(emailMessage.getRecipients(RecipientType.TO))
						+ EmailConstants.TWO_LINE_SEPARATOR);
		outputMessage.append(EmailConstants.EMAIL_CONTENT_LABEL + EmailConstants.TWO_LINE_SEPARATOR
				+ emailMessage.getContent() + EmailConstants.TWO_LINE_SEPARATOR);

		System.out.println(outputMessage.toString());

		MailResponse response = new MailResponse();
		response.setOutput(outputMessage.toString());
		response.setResponseCode(new Random().nextInt(9));

		return response;

	}

	/**
	 * Real email transport implementation method
	 * 
	 * Currently not used
	 * 
	 * @param emailMessage
	 * @throws MessagingException
	 * @throws IOException
	 */
	public static String sendEmail(MimeMessage emailMessage) throws MessagingException, IOException {

		Transport.send(emailMessage);

		return new String(EmailConstants.SUCCESS_MESSAGE);

	}

	/**
	 * Creating session for the email used for real implementation
	 * 
	 * @return
	 * @throws IOException
	 */
	public static Session createSession() throws IOException {

		Properties smtpProperties = configUtil.defaultProperties();

		Session session = Session.getInstance(smtpProperties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				try {
					return new PasswordAuthentication(
							configUtil.defaultProperties().getProperty(EmailConstants.EMAIL_USERNAME),
							configUtil.defaultProperties().getProperty(EmailConstants.EMAIL_PASSWORD));
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			}
		});
		return session;
	}
}
