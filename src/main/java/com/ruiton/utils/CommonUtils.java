package com.ruiton.utils;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

/**
 * 公共工具类
 */
public class CommonUtils {
	
	public static Integer parseInt(String str){
		if(StringUtils.isBlank(str)){
			return null;
		}
		return Integer.parseInt(str.trim());
	}
	
	public static BigDecimal parseBigDecimal(String str){
		if(StringUtils.isBlank(str)){
			return null;
		}
		return new BigDecimal(str);
	}

}
