package com.secure.mail.common;

/**
 * 
 * This is an constant class which holds constant across project
 * 
 * @author Srinivas
 *
 */
public class EmailConstants {

	public static final String RULE_PROPERTY_FILE_NAME = "bootstrap.properties";
	public static final String DOMAI_EXTENSION = "google.com";
	public static final String DOMAIN_EXTERNAL = "OUT";
	public static final String DOMAIN_INTERNAL = "IN";
	public static final String FORMAT_HTML = "HTML";
	public static final String FORMAT_PLAIN_TEXT = "PT";

	public static final String EMAIL_USERNAME = "mail.user";
	public static final String EMAIL_PASSWORD = "mail.password";
	public static final String SUCCESS_MESSAGE = "Message sent successfully!";
	public static final String EMAIL_SENT_LABEL = "Sent To: \t";
	public static final String EMAIL_FROM_LABEL = "From: \t";
	public static final String EMAIL_FORMAT_LABEL = "Format:\t";
	public static final String EMAIL_DATE_LABEL = "Date:\t";
	public static final String TWO_LINE_SEPARATOR = "\n\n";
	public static final String EMAIL_CONTENT_LABEL = "Content: ";
	
	public static final String AES_PADDING = "AES/CBC/PKCS5Padding";
	public static final String AES_ALGORITHM = "AES";
	public static final String AES_SHA_VALUE = "PBKDF2WithHmacSHA256";
	public static final String DES_PADDING = "DES/ECB/PKCS5Padding";
	public static final String DES_ALGORITHM = "DES";

	public static final String SENDER_EMAIL = "SrinivasanTest@google.com";

	public static final String DISCLAIMER_TEXT = "\n-------------------------DISCLAIMER NOTICE------------------------------------"
			+ "\nThe content of this email is confidential and intended for the recipient specified in message only. "
			+ "\n It is strictly forbidden to share any part of this message with any third party, without a written consent of the sender. "
			+ "\n If you received this message by mistake, please reply to this message and follow with its deletion, "
			+ "\n so that we can ensure such a mistake does not occur in the future.";
	
	
	public static String SECERET_KEY = "SRINIVASAN";
	public static String SALT_VALUE = "ELANGOVAN";
	public static byte[] RANDOM_BYTES = { 99, 1, 56, 34, 0, 73, 2, 98, 0, 22, 58, 4, 0, 0, 43, 66 };

}
