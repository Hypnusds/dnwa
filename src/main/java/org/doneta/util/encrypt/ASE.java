package org.doneta.util.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;
import org.doneta.util.encode.ParseByteUtils;

/**
 * ASE 加密解密
 * @author Hypnusds
 */
public class ASE {
	
	private static final Logger log = Logger.getLogger(ASE.class);
	private static final String DEFAULT_PUBLIC_KEY = "donETA";
	public static final Cipher DEFAULT_ENCRYPT_CIPHER = createCipher(DEFAULT_PUBLIC_KEY, Cipher.ENCRYPT_MODE);
	public static final Cipher DEFAULT_DECRYPT_CIPHER = createCipher(DEFAULT_PUBLIC_KEY, Cipher.DECRYPT_MODE);
	
	/**
	 * ASE 加密
	 * @param content
	 * @return String
	 */
	public static String encrypt(String content) {
		return ParseByteUtils.parseByte2HexStr(encrypt(content, null, DEFAULT_ENCRYPT_CIPHER));
	}

	/**
	 * ASE 加密
	 * @param content
	 * @param sKey
	 * @return String
	 */
	public static String encrypt(String content, String sKey) {
		return ParseByteUtils.parseByte2HexStr(encrypt(content, sKey, null));
	}
	
	/**
	 * ASE 解密
	 * @param content
	 * @return String
	 */
	public static String decrypt(String content) {
		return new String(decrypt(ParseByteUtils.parseHexStr2Byte(content), null, DEFAULT_DECRYPT_CIPHER));
	}
	
	/**
	 * ASE 解密
	 * @param content
	 * @param sKey
	 * @return String
	 */
	public static String decrypt(String content, String sKey) {
		return new String(decrypt(ParseByteUtils.parseHexStr2Byte(content), sKey, null));
	}
	
	/**
	 * ASE 加密
	 * @param content
	 * @param sKey 密钥
	 * @param cipher 当cipher为null时, 通过sKey生成一个新的Cipher
	 * @return byte[]
	 */
	public static byte[] encrypt(String content, String sKey, Cipher cipher) {
		if(cipher == null)
			cipher = createCipher(sKey, Cipher.ENCRYPT_MODE);
		try {
			return cipher.doFinal(content.getBytes("utf-8"));
		} catch (IllegalBlockSizeException e) {
			log.error(e);
		} catch (BadPaddingException e) {
			log.error(e);
		} catch (UnsupportedEncodingException e) {
			log.error(e);
		}
		return null;
	}
	
	/**
	 * ASE 解密
	 * @param content
	 * @param sKey 密钥
	 * @param cipher 当cipher为null时, 通过sKey生成一个新的Cipher
	 * @return byte[]
	 */
	public static byte[] decrypt(byte[] content, String sKey, Cipher cipher){
		if(cipher == null)
			cipher = createCipher(sKey, Cipher.DECRYPT_MODE);
		try {
			return cipher.doFinal(content);
		} catch (IllegalBlockSizeException e) {
			log.error(e);
		} catch (BadPaddingException e) {
			log.error(e);
		} 
		return null;
	}
	
	/**
	 * 创建一个密码器
	 * @param sKey
	 * @return 密码器
	 */
	public static Cipher createCipher(String sKey, int cipherMode) {
		Cipher cipher = null;
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128, new SecureRandom(sKey.getBytes()));
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			cipher = Cipher.getInstance("AES");// 创建密码器
			cipher.init(cipherMode, key);// 初始化
		} catch (NoSuchAlgorithmException e) {
			log.error(e);
		} catch (NoSuchPaddingException e) {
			log.error(e);
		} catch (InvalidKeyException e) {
			log.error(e);
		}
		return cipher;
	}

}
