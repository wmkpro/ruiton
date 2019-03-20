/**
 * 
 */
package com.ruiton.utils;

import java.util.Date;

/**
 * 时间测试类
 */
public class DateUtilTest {
	public static void main(String[] args) {
		Date date=DateUtil.getDateByformatYMDHMSS("2019-03-14");
		System.out.println(date);
	}
}
