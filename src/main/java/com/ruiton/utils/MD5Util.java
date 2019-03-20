package com.ruiton.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Util {

	public static final String getMD5(String str) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("MD5加密失败", e);
		}
		byte[] byteArray = messageDigest.digest();
		return new BigInteger(1,byteArray).toString(16); 
	}

}
