package com.secure.mail.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import com.secure.mail.common.EmailConstants;

/**
 * 
 * Utility class for encryption logics.
 * 
 * @author Srinivas
 *
 */
public class EncryptionUtil {

	private static SecretKey myDesKey;

	static {
		KeyGenerator keygenerator = null;
		try {
			keygenerator = KeyGenerator.getInstance(EmailConstants.DES_ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		myDesKey = keygenerator.generateKey();
	}

	/**
	 * DES algorithm encryption of the input string
	 * 
	 * @param emailBody
	 * @return
	 */
	public static String desEncryptMessage(String emailBody) {

		byte[] encryptedContent = EmailConstants.RANDOM_BYTES;
		Cipher desCipher;

		try {
			desCipher = Cipher.getInstance(EmailConstants.DES_PADDING);
			desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
			encryptedContent = desCipher.doFinal(emailBody.getBytes());

		} catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException
				| NoSuchPaddingException e) {
			e.printStackTrace();
		}

		return Base64.getEncoder().encodeToString(encryptedContent);
	}

	/**
	 * DES algorithm decryption of the input string
	 * 
	 * @param emailBody
	 * @return
	 */
	public static String desDecryptMessage(String emailBody) {

		byte[] decryptedContent = EmailConstants.RANDOM_BYTES;
		Cipher desCipher;

		try {
			desCipher = Cipher.getInstance(EmailConstants.DES_PADDING);
			desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
			decryptedContent = desCipher.doFinal(Base64.getDecoder().decode(emailBody));

		} catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException
				| NoSuchPaddingException e) {
			e.printStackTrace();
		}

		return new String(decryptedContent);
	}

	/**
	 * AES encryption of input text
	 * 
	 * @param strToEncrypt
	 * @param secret
	 * @return
	 */
	public static String aesEncryptMessage(String strToEncrypt) {
		try {

			IvParameterSpec ivspec = new IvParameterSpec(EmailConstants.RANDOM_BYTES);
			SecretKeyFactory factory = SecretKeyFactory.getInstance(EmailConstants.AES_SHA_VALUE);
			KeySpec spec = new PBEKeySpec(EmailConstants.SECERET_KEY.toCharArray(),
					EmailConstants.SALT_VALUE.getBytes(), 65536, 256);
			SecretKey tmp = factory.generateSecret(spec);
			SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), EmailConstants.AES_ALGORITHM);

			Cipher cipher = Cipher.getInstance(EmailConstants.AES_PADDING);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
		} catch (Exception e) {
			System.out.println("Error while encrypting: " + e.toString());
		}
		return null;
	}

	/**
	 * AES decryption of inout text
	 * 
	 * @param strToDecrypt
	 * @param secret
	 * @return
	 */
	public static String aesDecryptMessage(String strToDecrypt) {
		try {
			IvParameterSpec ivspec = new IvParameterSpec(EmailConstants.RANDOM_BYTES);

			SecretKeyFactory factory = SecretKeyFactory.getInstance(EmailConstants.AES_SHA_VALUE);
			KeySpec spec = new PBEKeySpec(EmailConstants.SECERET_KEY.toCharArray(),
					EmailConstants.SALT_VALUE.getBytes(), 65536, 256);
			SecretKey tmp = factory.generateSecret(spec);
			SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), EmailConstants.AES_ALGORITHM);

			Cipher cipher = Cipher.getInstance(EmailConstants.AES_PADDING);
			cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			System.out.println("Error while encrypting: " + e.toString());
		}
		return null;
	}

	/**
	 * 
	 * Added for testing both the algorithms
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String plainText = "hello world";
		System.out.println("Original String \t" + plainText);

		String desEncrypted = desEncryptMessage(plainText);
		System.out.println(EmailConstants.TWO_LINE_SEPARATOR + "DES Encrypted String \t" + desEncrypted);

		String encryptedString = aesEncryptMessage(desEncrypted);
		System.out.println(EmailConstants.TWO_LINE_SEPARATOR + "DES + AES encrypted String \t" + encryptedString);
		String aesDecrypted = aesDecryptMessage(encryptedString);
		System.out.println(EmailConstants.TWO_LINE_SEPARATOR + "AES Decrypted String \t" + aesDecrypted);
		System.out.println(
				EmailConstants.TWO_LINE_SEPARATOR + "Final Original String \t" + desDecryptMessage(aesDecrypted));
	}

}
