package com.sparrow.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间util
 * @author       Jay
 * @time         2015年5月21日
 */
public class DateUtil {

	/**
	 * 获取系统时间 获取系统时间 时分秒yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String systemTime1() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date());
	}

	/**
	 * 获取系统时间 年月日yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String systemTime2() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date());
	}

	/**
	 * 获取系统时间 时分秒HH:mm:ss
	 * 
	 * @return
	 */
	public static String systemTime3() {
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(new Date());
	}

}
