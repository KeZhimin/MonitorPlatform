package com.ffcs.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

	// ��д
	public static String UPPERCASE = "UPPERCASE";
	// Сд
	public static String LOWERCASE = "LOWERCASE";

	// Ĭ�Ϸ��ش�д�ַ�
	public static String Encryption(String str) {
		return Encryption(str, UPPERCASE);
	}

	/**
	 * @param str
	 *            ������ַ�
	 * @param type
	 *            ��ѡ����ܺ��Сд
	 * @return ���ܺ��ַ�
	 */
	public static String Encryption(String str, String type) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		String enstr = null;

		try {
			byte[] btstr = str.getBytes();
			MessageDigest mdinst = MessageDigest.getInstance("MD5");
			mdinst.update(btstr);
			byte[] mdstr = mdinst.digest();

			int j = mdstr.length;
			char strs[] = new char[j * 2];

			int k = 0;

			for (int i = 0; i < j; i++) {
				byte temp = mdstr[i];
				strs[k++] = hexDigits[temp >>> 4 & 0xf];
				strs[k++] = hexDigits[temp & 0xf];
			}

			enstr = new String(strs);

			if (LOWERCASE.equals(type)) {
				return enstr.toLowerCase();
			} else if (UPPERCASE.equals(type)) {
				return enstr.toUpperCase();
			} else {
				return null;
			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

}
