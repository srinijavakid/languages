package com.secure.mail.util;

import com.secure.mail.common.EmailConstants;

/**
 * This class is used as an facade for the rule implementation
 * 
 * @author Srinivas
 */
public class RulesUtil {

	public static String addDisclaimer(String emailBody) {
		emailBody = emailBody + EmailConstants.DISCLAIMER_TEXT;
		return emailBody;
	}

	public static String encryptLevelOne(String emailBody) {
		return EncryptionUtil.desEncryptMessage(emailBody);
	}

	public static String encryptLevelTwo(String emailBody) {
		return EncryptionUtil.aesEncryptMessage(emailBody);
	}
}
