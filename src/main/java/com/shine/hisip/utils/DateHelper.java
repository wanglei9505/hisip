package com.shine.hisip.utils;

import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @corporation
 * @author
 * @path
 * @description
 */
public class DateHelper {

//	private  Calendar calendar = Calendar.getInstance();


	// 每天的毫秒数: 86400000
	private final static int dayMilliseconds = 86400000;

	// 获得本周一与当前日期相差的天数
	public static  int getMondayPlus() {
		Calendar cd = Calendar.getInstance();
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == 1) {
			return -6;
		} else {
			return 2 - dayOfWeek;
		}
	}

	// 获得当前周- 周一的日期
	public static Date getCurrentMonday() {
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus);
		Date monday = currentDate.getTime();
		/*DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);*/
		return monday;
	}


	// 获得当前周- 周日  的日期
	public static Date getPreviousSunday() {
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus +6);
		Date sunday = currentDate.getTime();
		/*DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);*/
		return sunday;
	}
	//得到本月的第一天
	public String getMonthFirstDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		SimpleDateFormat firstDay= new SimpleDateFormat("yyyy-MM-dd");
		return  firstDay.format(calendar.getTime());
	}

	//得到本月的最后一天
	public String getMonthLastDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		SimpleDateFormat lastDay= new SimpleDateFormat("yyyy-MM-dd");
		return  lastDay.format(calendar.getTime());
	}


	/**
	 * 得到日期的年
	 *
	 * @param date
	 * @return Long
	 */
	 public static Long getYearFromDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		return Long.valueOf(year);
	 }

	/**
	 * 得到日期的月
	 *
	 * @param date
	 * @return Long
	 */
	public static Long getMonthFromDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int month = calendar.get(Calendar.MONTH) + 1;
		return Long.valueOf(month);
	}

	/**
	 * 得到日期的日
	 *
	 * @param date
	 * @return Long
	 */
	public static Long getDayFromDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int day = calendar.get(Calendar.DATE);
		return Long.valueOf(day);
	}

	/**
	 * 从年和月得到日期
	 *
	 * @param year
	 * @param month
	 * @return Date
	 * @throws ParseException 
	 */
	static public Date getDateFromYearMonth(Long year, Long month) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = month.toString();
		if (month.longValue() < 10)
			dateStr = "0" + dateStr;
		dateStr = year.toString() + "-" + dateStr + "-01";
		Date date = dateFormat.parse(dateStr);
		return date;
	}

	/**
	 * 从年月日得到日期
	 *
	 * @param year
	 * @param month
	 * @return Date
	 * @throws ParseException 
	 */
	static public Date getDateFromYearMonthDay(Long year, Long month, Long day) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = month.toString();
		String dayStr = day.toString();
		if (month.longValue() < 10)
			dateStr = "0" + dateStr;
		if (day.longValue() < 10)
			dayStr = "0" + dayStr;
		dateStr = year.toString() + "-" + dateStr + "-" + dayStr;
		Date date = dateFormat.parse(dateStr);
		return date;
	}

	/**
	 * 得到两个日期间的天数
	 *
	 * @param firstDate
	 * @param lastDate
	 * @return int
	 */
	static public int getDaysOfDates(Date firstDate, Date lastDate) {
		return (int) ((lastDate.getTime() - firstDate.getTime()) / dayMilliseconds);
	}

	/**
	 * 日期加指定月数
	 *
	 * @param date
	 * @param months
	 * @return Date
	 */
	static public Date addMonths(Date date, int months) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}

	/**
	 * 日期加指定天数
	 *
	 * @param date
	 * @param hour
	 * @return Date
	 */
	static public Date addHour(Date date, int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR, hour);
		return calendar.getTime();
	}

	/**
	 * 日期加指定天数
	 *
	 * @param date
	 * @param days
	 * @return Date
	 */
	static public Date addDays(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();
	}
	/**
	 * 得到时间间的花费时间
	 *
	 * @param startDate
	 * @param endDate
	 * @return String
	 */
	static public String calculateTimesStringOfDatesBetween(Date startDate,
			Date endDate) {

		long costTime = (endDate.getTime() - startDate.getTime()) / 1000;
		String costTimeStr = null;

		if (costTime < 60)
			costTimeStr = costTime + "秒";
		else if (costTime < 3600)
			costTimeStr = (costTime / 60) + "分" + costTime % 60 + "秒";
		else
			costTimeStr = (costTime / 3600)
					+ "小时"
					+ ((costTime - (costTime / 3600) * 3600) / 60)
					+ "分" + costTime % 60 + "秒";
		return costTimeStr;
	}
	/**
	 * 得到时间间的花费时间
	 *
	 * @param startDate
	 * @param endDate
	 * @return String
	 */
	static public String getTimesLongOfDatesBetween(Date startDate,
			Date endDate) {

		long costTime = (endDate.getTime() - startDate.getTime()) / 1000;
		String costTimeStr = null;

		if (costTime < 60)
			costTimeStr = costTime + "秒";
		else if (costTime < 3600)
			costTimeStr = (costTime / 60) + "分" + costTime % 60 + "秒";
		else
			costTimeStr = (costTime / 3600)
					+ "小时"
					+ ((costTime - (costTime / 3600) * 3600) / 60)
					+ "分" + costTime % 60 + "秒";
		return costTimeStr;
	}



	/**
	 * 格式化日期：yyyy-MM-dd
	 *
	 * @param date
	 * @return String
	 */
	static public String formatDate(Date date) {
		if(null!=date)
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			return dateFormat.format(date);
		}else{
			return "";
		}
	}

	/**
	 * 格式化日期：yyyy-MM-dd hh:mm:ss
	 *
	 * @param date
	 * @return String
	 */
	static public String formatDateTime(Date date) {
		if(null!=date)
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
			return dateFormat.format(date);
		}else{
			return "";
		}
	}

	/**	 字符串转换到时间格式	 
	  * @param dateStr 需要转换的字符串	 
	  * @param formatStr 需要格式的目标字符串  举例 yyyy-MM-dd	 
	  * @return Date 返回转换后的时间	 
	  * @throws ParseException 转换异常	 
	  */	
	public static Date StringToDate(String dateStr,String formatStr) throws ParseException{		
		DateFormat sdf=new SimpleDateFormat(formatStr);		
		Date date=null;		
		date = sdf.parse(dateStr);		
		return date;	
	}
	/**
	 * 字符串转换到时间格式	
	 * @param dateStr
	 * @return
	 * @throws ParseException 
	 */
	public static Date String2Date(String dateStr) throws ParseException{		
		DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");		
		Date date=null;		
		if(StringUtils.isNotBlank(dateStr)){
			date = sdf.parse(dateStr);
		}			
		return date;	
	}
	/**
	 * 按日期格式定义格式化日期
	 *
	 * @param date
	 * @param format
	 * @return String
	 */
	static public String formatDateTime(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	/**
	 * 从日期格式串返回日期
	 *
	 * @param dateStr
	 *            日期格式串
	 * @param format
	 *            日期格式定义
	 * @return
	 * @throws ParseException 
	 */
	static public Date getDateFromString(String dateStr, String format) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		if(dateStr.trim().equals("")){
		    return null;
		}else{
		    return dateFormat.parse(dateStr);
		}
	}

	/**
	 * 生成用于文件名称的日期字符串
	 *
	 * @param date
	 * @return
	 */
	static public String formatDateTimeForFileName(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd-HH-mm-ss");
		return dateFormat.format(date);
	}

	/**
	 * 返回时间段,暂定为20--20
	 *
	 * @param date
	 * @return Date[] size=2,begin and end date
	 * @throws ParseException 
	 */
	static public Date[] getScopeDate(Date date) throws ParseException {
		Date[] row = new Date[2];
		Long y = getYearFromDate(date);
		Long m = getMonthFromDate(date);
		Date date1 = getDateFromYearMonthDay(y, Long.valueOf(m.longValue() - 1), Long.valueOf(20));
		Date date2 = getDateFromYearMonthDay(y, m, Long.valueOf(20));
		row[0] = date1;
		row[1] = date2;
		return row;
	}

	static public String getTime(String formet){

		 SimpleDateFormat   formatter   =   new   SimpleDateFormat   (formet);
    	 Date   curDate   =   new   Date(System.currentTimeMillis());//获取当前时间
    	String   str   =   formatter.format(curDate);

    	//System.out.println(str);
    	return str;
	};


	static public String getYesterdayTime(String formet){
		SimpleDateFormat   formatter   =   new   SimpleDateFormat   (formet);
	   	Date   curDate   =   new   Date(System.currentTimeMillis());//获取当前时间
		Calendar cal = Calendar.getInstance();
		cal.setTime(curDate);

		cal.add(Calendar.DATE, -1);
		Date yesterday =cal.getTime();//昨天
		String   str   =   formatter.format(yesterday);
	   	return str;
	};

	//日期格式验证
	 public static boolean isDate(String str)
    {
        //严格验证时间格式的(匹配[2002-01-31], [1997-04-30], [2004-01-01])不匹配([2002-01-32], [2003-02-29], [04-01-01])
	 	//String regex = "^((((19|20)(([02468][048])|([13579][26]))-02-29))|((20[0-9][0-9])|(19[0-9][0-9]))-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((01,3-9])|(1[0-2]))-(29|30)))))$";
        //没加时间验证的YYYY-MM-DD
	 	String regex = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$";
        //加了时间验证的YYYY-MM-DD 00:00:00
	 	//  String regex = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";

	 	Pattern pattern = Pattern.compile(regex);

	 	Matcher matcher = pattern.matcher(str);

	 	return matcher.matches();
    }

	 //计算两个日期之间相差几天
	 public static int dayCount(String startTime, String endTime) throws ParseException{
		 //按照传入的格式生成一个simpledateformate对象
		 SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		 long nd = 1000*24*60*60;//一天的毫秒数
		 long diff;
		 long day = 0;
			 //获得两个时间的毫秒时间差异
		 diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
		 day = diff/nd;//计算差多少天
		 return (int)day;
	 }

	//判断时间date1是否在时间date2之前 
	//时间格式 2005-4-21 16:16
	public static boolean isDateBefore(String date1,String date2) throws ParseException{ 
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Boolean bn=false;
		Date d1=df.parse(date1);
		Date d2=df.parse(date2);
		if(d1.getTime()<d2.getTime()){
			bn= true; 
		}
		else if(d1.getTime()>d2.getTime()){
			bn= false;
		}
		return bn; 
	} 

	public static void main(String[] args) throws ParseException {
		Date monday=getCurrentMonday();
		Date sunday=getPreviousSunday();
		System.out.println(monday);
		System.out.println(sunday);
	}

}
