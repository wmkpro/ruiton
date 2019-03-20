package com.ruiton.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;

/**
 * 时间工具类 
 */
public final class DateUtil {
	private DateUtil() {
	}
	
	/**
	 * 获取指定时间的对应月份的第一天日期，格式yyyy-MM-dd
	 * @param date  指定时间
	 * @return yyyy-MM-dd这样的时间格式
	 *
	 * @author jack
	 * @see 类、类#方法、类#成员
	 */
	public static String getlocalMouthFirstYMDDateTime(Date date){
		  	Calendar c = Calendar.getInstance();   
		  	c.setTime(date);
	        c.add(Calendar.MONTH, 0);
	        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        String first = dateFormat.format(c.getTime());
	        return first;
	}
	
	/**
	 * 获取当前时间的本月最后一天时间,如当前是2015-01-02 11:11:20，返回最后一天的时间格式是：
	 * 2015-01-31 11:11:20
	 * @return 2015-01-31 11:11:20 时间格式
	 *
	 * @author jack
	 * @see 类、类#方法、类#成员
	 */
	public static String getNowTimelocatMouthLastDateTime(){
		// 获取Calendar  
		Calendar calendar = Calendar.getInstance();  
		// 设置时间,当前时间不用设置  
		// calendar.setTime(new Date());  
		// 设置日期为本月最大日期  
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));  
		// 打印  
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		return format.format(calendar.getTime());
	}
	
	/**
	 * 获取当前时间的本月最后一天时间,如当前是2015-01-02 11:11:20，返回最后一天的时间格式是：
	 * 2015-01-31 23:59:59
	 * @param 执行时间对象
	 * @return 2015-01-31 23:59:59 时间格式
	 *
	 * @author jack
	 * @see 类、类#方法、类#成员
	 */
	public static String getNowTimelocatMouthLastDateTime(Date date){
		// 获取Calendar  
		Calendar calendar = Calendar.getInstance();  
		// 设置时间,当前时间不用设置  
		 calendar.setTime(date);  
		// 设置日期为本月最大日期  
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));  
		// 打印  
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd 23:59:59");  
		return format.format(calendar.getTime());
	}
	
	/**
     * 获取 现在时间日期  格式 yyyy-MM-dd HH:mm:ss:SSS
     * <功能详细描述>
     *
     * @return String  现在时间日期 格式 yyyy-MM-dd HH:mm:ss:SSS
     */
    public static String getNowDateByYMDHMSSS(Date date)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        return dateFormat.format(date); 
    }
    
    /**
     * 获取 现在时间日期  格式 yyyy-MM-dd HH:mm:ss:SSS
     * @return String  现在时间日期 格式 yyyy-MM-dd HH:mm:ss:SSS
     */
    public static String getFormatYMDDate(Date date)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date); 
    }
	 
    /**
     * 获取 现在时间日期  格式 yyyy-MM-dd HH:mm:ss
     *
     * @return String  现在时间日期 格式yyyy-MM-dd HH:mm:ss
     */
    public static String getDateByYMDHMS(Date date)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
    
    /**
     * 获取 现在时间日期  格式 yyyyMMddHHmmss
     *
     * @return String  现在时间日期 格式yyyyMMddHHmmss
     */
    public static String getYyyyMMddHHmmssByDate(Date date)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(date);
    }
    
    /**
     * 获取 指定时间日期  格式 yyyy-MM-dd
     * @return String  现在时间日期 格式yyyy-MM-dd
     */
    public static String getDateByYMD(Date date)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
	
	/**
	 * 获取当前时间的最晚时间
	 * @return 参数说
	 * @author Decheng Zhang
	 * @see 类、类#方法、类#成员
	 */
	public static Date getCurrentDayLatestTime(){
		Calendar currentDate = Calendar.getInstance();
		currentDate.set(Calendar.HOUR_OF_DAY, 23);
		currentDate.set(Calendar.MINUTE, 59);
		currentDate.set(Calendar.SECOND, 59);
		return currentDate.getTime();
	}
	public static Date getCurrentDayEarliestTime(){
		Calendar currentDate = Calendar.getInstance();
		currentDate.set(Calendar.HOUR_OF_DAY, 00);
		currentDate.set(Calendar.MINUTE, 00);
		currentDate.set(Calendar.SECOND, 00);
		return currentDate.getTime();
	}
	public static String getUTCDateStr(String dateFormat) {
		Date date = getDateByformatYMD(dateFormat);
		SimpleDateFormat sdf = new SimpleDateFormat("");
		return sdf.format(date);
	}

	/**
	 * 获取今天的开始时间
	 * 
	 * @return date
	 * 
	 * @author jack
	 * @see 类、类#方法、类#成员
	 */
	public static Date getStartTimeByNowDate() {
		return getStartTime(null, null);
	}

	/**
	 * 获取指定日期时间的开始时间,或者根据索引天数来获取开始时间，索引天数可以是前进多少天，倒退多少天<br>
	 * 如：输入当前时间对象，indexDate等于-1，就表明根据当前时间倒退一天，然后获取倒退一天的开始时间，，如果是+1，就说明前进一天
	 * 
	 * @param date
	 *            时间对象
	 * @param indexDate
	 *            索引天数,可以为null
	 * @return date
	 * 
	 * @author jack
	 * @see 类、类#方法、类#成员
	 */
	public static Date getStartTime(Date date, Integer indexDate) {
		Calendar currentDate = Calendar.getInstance();
		if (date != null) {
			currentDate.setTime(date);
		}
		if (indexDate != null) {
			currentDate.add(Calendar.DATE, indexDate);
		}
		currentDate.set(Calendar.HOUR_OF_DAY, 0);
		currentDate.set(Calendar.MINUTE, 0);
		currentDate.set(Calendar.SECOND, 0);
		return currentDate.getTime();
	}

	/**
	 * 获取指定日期时间的结束时间,或者根据索引天数来获取结束时间，索引天数可以是前进多少天，倒退多少天<br>
	 * 如：输入当前时间对象，indexDate等于-1，就表明根据当前时间倒退一天，然后获取倒退一天的开始时间，，如果是+1，就说明前进一天
	 * 
	 * @param date
	 *            时间对象
	 * @param indexDate
	 *            索引天数，可以为null
	 * @return date
	 * 
	 * @author jack
	 * @see 类、类#方法、类#成员
	 */
	public static Date getEndTime(Date date, Integer indexDate) {
		Calendar currentDate = Calendar.getInstance();
		if (date != null) {
			currentDate.setTime(date);
		}
		if (indexDate != null) {
			currentDate.add(Calendar.DATE, indexDate);
		}
		currentDate.set(Calendar.HOUR_OF_DAY, 23);
		currentDate.set(Calendar.MINUTE, 59);
		currentDate.set(Calendar.SECOND, 59);
		return currentDate.getTime();
	}

	/**
	 * 获取今天的结束时间
	 * 
	 * @return date
	 * 
	 * @author jack
	 * @see 类、类#方法、类#成员
	 */
	public static Date getEndTimeByNowDate() {
		return getEndTime(null, null);
	}

	/**
	 * 按照年份相减
	 * @param birthDayformart
	 *            格式yyyy-MM-dd
	 * @return 获取年龄
	 */
	public static int getAgeBybirthDay(String birthDayformart) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// 得到当前的年份
			String cYear = sdf.format(new Date()).substring(0, 4);
			// 得到生日年份
			String birthYear = birthDayformart.substring(0, 4);
			int age = Integer.parseInt(cYear) - Integer.parseInt(birthYear);
			return age;
		} catch (Exception e) {
			throw new RuntimeException("Get Age By " + birthDayformart+ " Error", e);
		}
	}

	/**
	 * 	按照年份相减
	 * @param date
	 *            Date
	 * @return 获取年龄
	 */
	public static int getAgeBybirthDay(Date date) {
		try {
			// 得到当前的年份
			int sYear = new Date().getYear();
			// 得到生日年份
			int btYear = date.getYear();
			int age = sYear - btYear;
			return age;
		} catch (Exception e) {
			throw new RuntimeException("Get Age By " + date + " Error", e);
		}
	}
	
	/**
	 * 根据时间年月日时分秒计算与当前时间的年龄差别
	 * @param date
	 * @return 参数说明
	 *
	 * @author jack
	 * @see 类、类#方法、类#成员
	 */
	public static long getAgeByTime(Date date) {
		try {
			Date date2=new Date();
			long day = (date2.getTime() - date.getTime()) / 1000;
			day=day / (60 * 60 * 24 * 365);
			return day;
		} catch (Exception e) {
			throw new RuntimeException("Get Age By " + date + " Error", e);
		}
	}

	/**
	 * 把时间格式 转换 日期对象（Date）. 如：2001-10-10
	 * 
	 * @param strDate
	 *            时间格式
	 * @return Date
	 */
	public static Date strToDate(String strDate) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date result = null;
		try {
			result = format.parse(strDate);
		} catch (ParseException e) {
			throw new IllegalArgumentException("把时间格式[" + strDate
					+ "] 转换成 Date 日期对象错误!", e);
		}
		return result;
	}

	/**
	 * 获取 现在时间日期 格式 <功能详细描述>
	 * 
	 * @param formart
	 *            时间格式
	 * 
	 * @return String 现在时间日期 格式
	 */
	public static String getNowDate(String formart) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(formart);
		return dateFormat.format(System.currentTimeMillis());
	}

	/**
	 * 获取 时间日期 格式 <功能详细描述>
	 * 
	 * @param formart
	 *            时间格式
	 * 
	 * @return String 现在日期 格式
	 */
	public static String getDate(Date date, String formart) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(formart);
		return dateFormat.format(date);
	}

	/**
	 * 获取 现在时间日期 格式 yyyy-MM-dd <功能详细描述>
	 * 
	 * @return String 现在时间日期 格式yyyy-MM-dd
	 */
	public static String getNowDateByYMD() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(new Date());
	}

	/**
	 * 获取 现在时间日期 格式 yyyy-MM-dd HH:mm:ss <功能详细描述>
	 * 
	 * @return String 现在时间日期 格式yyyy-MM-dd HH:mm:ss
	 */
	public static String getNowDateByYMDHMS() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(new Date());
	}

	/**
	 * 获取 现在时间日期 格式 yyyy-MM-dd HH:mm:ss:SSS <功能详细描述>
	 * 
	 * @return String 现在时间日期 格式 yyyy-MM-dd HH:mm:ss:SSS
	 */
	public static String getNowDateByYMDHMSSS() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss:SSS");
		return dateFormat.format(System.currentTimeMillis());
	}

	/**
	 * 将短时间格式字符串转换为时间 ，格式如：yyyy-MM-dd HH:mm:ss:SSS <br>
	 * 注意，时间格式必须正确，否则就将返回null
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date getDateByformatYMDHMSSS(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss:SSS");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	/**
	 * 将短时间格式字符串转换为时间 ，格式如：yyyy-MM-dd HH:mm:ss <br>
	 * 注意，时间格式必须正确，否则就将返回null
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date getDateByformatYMDHMSS(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	/**
	 * 将短时间格式字符串转换为时间 ，格式如：yyyy-MM-dd <br>
	 * 注意，时间格式必须正确，否则就将返回null
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date getDateByformatYMD(String strDate) {
		if(strDate==null){
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	/**
	 * 将短时间格式字符串转换为时间 ，格式如：yyyy-MM-ddTHH:mm:ssSSSZ <br>
	 * 注意，时间格式必须正确，否则就将返回null
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date getDateByformatYMDTSSSZ(String strDate) {
		 final String year = strDate.substring(0, 4);
         final String month = strDate.substring(5, 7);
         final String day = strDate.substring(8, 10);
         final String hour = strDate.substring(11, 13);
         final String minute = strDate.substring(14, 16);
         final String second = strDate.substring(17, 19);
         final int millisecond = Integer.valueOf(strDate.substring(20, 23));
         Calendar result =
             new GregorianCalendar(Integer.valueOf(year),
                 Integer.valueOf(month) - 1, Integer.valueOf(day),
                 Integer.valueOf(hour), Integer.valueOf(minute),
                 Integer.valueOf(second));
        result.set(Calendar.MILLISECOND, millisecond);
        result.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        Date date2 = new Date(result.getTimeInMillis()); 
		return date2;
	}

	
	/**
	 * 获取 现在时间日期 格式 yyyy-MM-dd-HHmmssSSS <功能详细描述>
	 * 
	 * @return String 现在时间日期 格式 yyyy-MM-dd-HHmmssSSS
	 */
	public static String getNowDateByYMDHMSSS2() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd-HHmmssSSS");
		return dateFormat.format(System.currentTimeMillis());
	}

	/**
	 * 获取 现在时间日期 格式 yyyy-MM-dd HH:mm:ss:SSS <功能详细描述>
	 * 
	 * @return String 现在时间日期 格式 yyyy-MM-dd HH:mm:ss:SSS
	 */
	public static String getNowDateByYMDHMSSS(long lngDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss:SSS");
		return dateFormat.format(new Date(lngDate));
	}

	/**
	 * 获取本周的 星期一 时间日期 格式 <功能详细描述>
	 * 
	 * @param formart
	 *            时间格式
	 * 
	 * @return String 星期一时间日期
	 */
	public static String getMondayDate(String formart) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(formart);
		Calendar calendar = Calendar.getInstance();

		int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);// 获取当前星期几，默认星期一 为2
		if (1 == dayWeek) {
			calendar.add(Calendar.DAY_OF_MONTH, -1);
		}
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		int day = calendar.get(Calendar.DAY_OF_WEEK);

		calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek() - day);
		Date date = calendar.getTime();

		return dateFormat.format(date);
	}

	/**
	 * 获取 本周星期天 时间日期 格式 <功能详细描述>
	 * 
	 * @param formart
	 *            时间格式
	 * 
	 * @return String 星期天 时间格式
	 */
	public static String getSundayDate(String formart) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(formart);
		Calendar calendar = Calendar.getInstance();

		int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);
		if (1 == dayWeek) {
			calendar.add(Calendar.DAY_OF_MONTH, -1);
		}
		calendar.setFirstDayOfWeek(Calendar.MONDAY);// 设置一周的星期一
		int day = calendar.get(Calendar.DAY_OF_WEEK);

		calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek() - day);
		calendar.add(Calendar.DATE, 6);

		Date date = calendar.getTime();
		return dateFormat.format(date);
	}

	/**
	 * 获取一周内指定 星期几 时间日期 格式 
	 * 
	 * @param formart
	 *            时间格式 如yyyy-MM-dd 等格式，不是具体时间格式
	 * @param indexWeek
	 *            1到7（星期一到星级天）
	 * 
	 * @return String 时间日期格式
	 */
	public static String getToWeekDate(String formart, int indexWeek) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(formart);
		Calendar calendar = Calendar.getInstance();

		int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);
		if (1 == dayWeek) {
			calendar.add(Calendar.DAY_OF_MONTH, -1);
		}
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		int day = calendar.get(Calendar.DAY_OF_WEEK);

		calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek() - day);
		if (indexWeek >= 0 && indexWeek <= 6) {
			calendar.add(Calendar.DATE, indexWeek);
		}
		Date date = calendar.getTime();
		return dateFormat.format(date);
	}

	/**
	 * 获取一年内 指定 月份 对应现在时间日期 格式 
	 * 
	 * @param formart
	 *            格式格式  如yyyy-MM-dd 等格式，不是具体时间格式
	 * @param indexMonth
	 *            1到12（一月份到十二月份）
	 * 
	 * @return String 现在时间格式
	 */
	public static String getMonthDate(String formart, int indexMonth) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(formart);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, indexMonth);
		Date date = calendar.getTime();
		return dateFormat.format(date);
	}

	/**
	 * 获取一个月 指定 日期 时间格式 
	 * 
	 * @param formart
	 *            时间格式 如yyyy-MM-dd 等格式，不是具体时间格式
	 * @param indexDate
	 *            1到31号
	 * 
	 * @return String 对应时间日期格式
	 */
	public static String getToDate(String formart, int indexDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(formart);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, indexDate);
		Date date = calendar.getTime();
		return dateFormat.format(date);
	}

	/**
	 * 获取 指定 年 时间日期格式
	 * 
	 * @param formart
	 *            时间格式 如yyyy-MM-dd 等格式，不是具体时间格式
	 * @param indexYear
	 *            年份，如：2010
	 * 
	 * @return String 时间日期格式
	 */
	public static String getToYearDate(String formart, int indexYear) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(formart);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, indexYear);
		Date date = calendar.getTime();
		return dateFormat.format(date);
	}

	/**
	 * 获取 现在星期几 <功能详细描述>
	 * 
	 * @return int 1到7
	 */
	public static int getNowWeek() {
		return Calendar.WEDNESDAY;
	}

	/**
	 * 获取现在 多少 号 <功能详细描述>
	 * 
	 * @return int [返回类型说明]
	 */
	@SuppressWarnings("deprecation")
	public static int getNowDate() {
		return new Date().getDate();
	}

	/**
	 * 获取现在 月份 <功能详细描述>
	 * 
	 * @return int 对应月份1
	 */
	public static int getNowMonth() {
		return Calendar.MONTH - 1;
	}

	/**
	 * 获取现在 年份 <功能详细描述>
	 * 
	 * @return int 年份
	 */
	@SuppressWarnings("deprecation")
	public static int getNowYear() {
		return new Date().getYear() + 1900;
	}

	/**
	 * 获取指定 天数 的时间格式 <功能详细描述>
	 * 
	 * @param formart
	 *            时间格式，如：yyyy-MM-dd
	 * @param indexDay
	 *            在现在的时间基础上，倒退多少天、或者前进多少天 。如：-30,30
	 * @return [参数说明]
	 */
	public static String getToDateByDay(String formart, int indexDay) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat(formart);
		String dateStr = format.format(new Date());
		calendar.add(Calendar.DATE, indexDay);
		dateStr = format.format(calendar.getTime());
		return dateStr;
	}

	/**
	 * 获取前进或后退的日期 <功能详细描述>
	 * 
	 * @param formart
	 *            时间格式，如：yyyy-MM-dd
	 * @param indexDay
	 *            在给定的时间基础上，倒退多少天、或者前进多少天 。如：-30,30
	 * @return [参数说明]
	 */
	public static String getToDateByDate(String formart, Date date,int indexDay) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		SimpleDateFormat format = new SimpleDateFormat(formart);
		String dateStr = format.format(new Date());
		calendar.add(Calendar.DATE, indexDay);
		dateStr = format.format(calendar.getTime());
		return dateStr;
	}
	
	/**
	 * 把字符串的时间 转换成 Date 日期类型 <功能详细描述>
	 * 
	 * @param strDateFormat
	 *            时间格式 ,格式为 yyyy-MM-dd,如2010-08-08
	 * 
	 * @return Date 时间 Date
	 */
	public static Date valueOfYMD(String strDateFormat) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // HH一定要大写，小写的话，变成12小时日期制
			format.setLenient(false);
			return format.parse(strDateFormat);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 把字符串的时间 转换成 Date 日期类型 <功能详细描述>
	 * 
	 * @param strDateFormat
	 *            时间格式 ,格式为 yyyy-MM-dd HH:mm:ss,如2010-08-08 8:58:58
	 * 
	 * @return Date 时间 Date
	 * @throws ParseException
	 */
	public static Date valueOfYMDHMS(String strDateFormat){
		try {
			if(strDateFormat==null||strDateFormat.trim().equals("")){
                return null;
            }
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss"); // HH一定要大写，小写的话，变成12小时日期制
			format.setLenient(false);
			return format.parse(strDateFormat);
		} catch (ParseException e) {
			throw new RuntimeException("字符时间格式："+strDateFormat+",转换成Date对象错误", e);
		}
	}

	/**
	 * 把字符串的时间 转换成 Date 日期类型 <功能详细描述>
	 * 
	 * @param strDateFormat
	 *            时间格式 ,格式为 yyyy-MM-dd HH:mm:ss,如2010-08-08 8:58
	 * 
	 * @return Date 时间 Date
	 * @throws ParseException
	 */
	public static Date valueOfYMDHM(String strDateFormat) throws ParseException {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // HH一定要大写，小写的话，变成12小时日期制
			format.setLenient(false);
			return format.parse(strDateFormat);
		} catch (ParseException e) {
			throw e;
		}
	}

	/**
	 * 获取前几分时间
	 * 
	 * @param agoMinutes
	 * @return 参数说明
	 * 
	 * @author jack
	 * @see 类、类#方法、类#成员
	 */
	public static Date getDateByAgoMinutes(int agoMinutes) {
		Date date = new Date();
		date.setMinutes(date.getMinutes() - agoMinutes);
		return date;
	}

	/**
	 * 获取 几天后的时间
	 * 
	 * @param day
	 *            天数
	 * @return 时间
	 * 
	 * @author jack
	 * @see 类、类#方法、类#成员
	 */
	public static Date getDateAfter(int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(new Date());
		now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
		return now.getTime();
	}
	
	/**
	 * 获取 几天后的时间
	 * @param strDate
	 *            时间格式，真实时间，如：2014-05-08 00:02:22
	 * @param day
	 *            天数
	 * @return 时间
	 * 
	 * @author jack
	 * @see 类、类#方法、类#成员
	 */
	public static Date getDateAfter(String strDate,int day) {
		Date date=getDateByformatYMDHMSS(strDate);
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
		return now.getTime();
	}
	
	

	/**
	 * 获取几年后的时间
	 * @param year
	 * @return 参数说明
	 * @author laixiang
	 * @see 类、类#方法、类#成员
	 */
	public static Date getDateAfterYear(int year){
		Calendar now=Calendar.getInstance();
		now.setTime(new Date());
		now.set(Calendar.YEAR,now.get(Calendar.YEAR)+year);
		return now.getTime();
	}
	/**
	 * 获取 几天后的时间
	 * 
	 * @param d
	 *            Date对象
	 * @param day
	 *            几天后
	 * @return 时间对象
	 */
	public static Date getDateAfter(Date d, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
		return now.getTime();
	}

	/**
	 * 获取 几个月后的时间
	 * 
	 * @param month
	 *            月数
	 * @return 时间
	 * 
	 * @author jack
	 * @see 类、类#方法、类#成员
	 */
	public static Date getDateAfterByMonth(int month) {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MONTH, month);
		return now.getTime();
	}
	/**
	 * 获取 几个月后的时间
	 * 
	 * @param month
	 *            月数
	 * @return 时间
	 * 
	 * @author jack
	 * @see 类、类#方法、类#成员
	 */
	public static Date getDateAfterByMonth(Date d,int month) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.add(Calendar.MONTH, month);
		return now.getTime();
	}

	/**
	 * 根据当前时间，索引到指定多少个月来获取对应当前时间点的日期完整时间，索引月份可以是前进多少个月或者倒退多少个月<br>
	 * 如 :当前时间 :2014-07-18 12:23:25 ，indexMonth为-1,就会倒退一个月，返回的时间是：2014-06-18
	 * 12:23:25
	 * 
	 * @param month
	 *            月数
	 * @return 时间
	 * 
	 * @author jack
	 * @see 类、类#方法、类#成员
	 */
	public static Date getDaterByIndexMonth(int indexMonth) {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MONTH, indexMonth);
		return now.getTime();
	}

	/**
	 * 获取当前时间的最早时间字符串格式
	 * 
	 * @param formDate
	 * 格式为：yyyy-MM-dd
	 * @return 参数说明
	 * @author laixiang
	 * @throws ParseException
	 * @see 类、类#方法、类#成员
	 */
	public static String getEarliestTime(String strDateFormat) {
		StringBuffer sb = new StringBuffer();
		if (StringUtils.isNotEmpty(strDateFormat)) {
			sb.append(strDateFormat);
			sb.append(" 00:00:00");
		}
		return sb.toString();
	}

	/**
	 * 获取当前时间的最晚时间字符串格式
	 * @param formDate
	 * 格式为：yyyy-MM-dd
	 * @return 参数说明
	 * @author laixiang
	 * @throws ParseException
	 * @see 类、类#方法、类#成员
	 */
	public static String getlatestTime(String strDateFormat) {
		StringBuffer sb = new StringBuffer();
		if (StringUtils.isNotEmpty(strDateFormat)) {
			sb.append(strDateFormat);
			sb.append(" 23:59:59");
		}
		return sb.toString();
	}
	/**
	 * 获取本月的最早时间
	 * @return 参数说明
	 * @author laixiang
	 * @see 类、类#方法、类#成员
	 */
	public static Date getCurrentMonthEarliestTime(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date date = calendar.getTime();
		return date;
	}
	/**
	 * 获取本月的最晚时间
	 * @return 参数说明
	 * @author laixiang
	 * @see 类、类#方法、类#成员
	 */
	public static Date getCurrentMonthLatestTime(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		Date date = calendar.getTime();
		return date;
	}
	/**
	 * 获取本周的最早时间
	 * @return 参数说明
	 * @author laixiang
	 * @see 类、类#方法、类#成员
	 */
	public static Date getCurrentWeekEarliestTime(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, 2);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date date = calendar.getTime();
		return date;
	}
	
	 /** 
     * 获取某年第一天开始时间 
     * @param year 年份 
     * @return Date 
     */  
    public static Date getYearFirst(int year){  
        Calendar calendar = Calendar.getInstance();  
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);
    	calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
        Date currYearFirst = calendar.getTime();  
        return currYearFirst;  
    }  
      
    /** 
     * 获取某年最后一天开始时间 
     * @param year 年份 
     * @return Date 
     */  
    public static Date getYearLast(int year){  
        Calendar calendar = Calendar.getInstance();  
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        calendar.roll(Calendar.DAY_OF_YEAR, -1); 
        calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
        Date currYearLast = calendar.getTime();      
        return currYearLast;  
    }  
    
    /** 
     * 获取本年某月第一天开始时间
     * @param year 年份 
     * @return Date 
     */  
    public static Date getMonthFirstDayEarliestTime(int month){  
        Calendar calendar = Calendar.getInstance(); 
        calendar.set(Calendar.MONTH, month-1); 
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
        Date currYearFirst = calendar.getTime();  
        return currYearFirst;  
    }  
    /** 
     * 获取本年某月最后一天结束时间
     * @param year 年份 
     * @return Date 
     */  
    public static Date getMonthLastDayLatestTime(int month){  
        Calendar calendar = Calendar.getInstance(); 
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
        Date currYearFirst = calendar.getTime();  
        return currYearFirst;  
    }  
}
