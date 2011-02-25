package org.doneta.util.encode;

import java.io.UnsupportedEncodingException;

import org.doneta.constant.EncodeConstant;

/**
 * EncodeUtils 编码工具类
 * @author Hypnusds
 */
public class EncodeUtils {
	
	public static final String ISO8859 = EncodeConstant.ISO8859;
	public static final String GBK = EncodeConstant.GBK;
	public static final String UTF8 = EncodeConstant.UTF8;

	public static String GBKToISO8859(String str) {
		if (str == null)
			return null;
		try {
			if (isGBK(str)) {
				byte b[] = str.getBytes(GBK);
				String s2 = new String(b, ISO8859);
				return s2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	public static String ISO8859ToGBK(String str) {
		if (str == null)
			return null;
		try {
			if (!isGBK(str)) {
				byte b[] = str.getBytes(ISO8859);
				String s2 = new String(b, GBK);
				return s2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	public static String GBKToLatin(String str) {
		if (str == null)
			return null;
		try {
			if (isGBK(str)) {
				byte b[] = str.getBytes(GBK);
				String s2 = new String(b, ISO8859);
				return s2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	public static String LatinToGBK(String str) {
		if (str == null)
			return null;
		try {
			if (!isGBK(str)) {
				byte b[] = str.getBytes(ISO8859);
				String s2 = new String(b, GBK);
				return s2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	public static final boolean isGBK(String source) throws UnsupportedEncodingException {
		boolean hasDoubleByteChar = false;
		byte sChar[] = source.getBytes(ISO8859);
		for (int i = 0; i < sChar.length; i++) {
			byte c = sChar[i];
			int j = c & 0xff;
			if (j > 127)
				hasDoubleByteChar = true;
		}

		return !hasDoubleByteChar;
	}

	public static String GBKToUTF8(String s) {
		if (s == null)
			return null;
		try {
			if (isGBK(s)) {
				byte b[] = s.getBytes(GBK);
				String s2 = new String(b, UTF8);
				return s2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
}
