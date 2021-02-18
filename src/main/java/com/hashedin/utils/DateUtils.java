
package com.hashedin.utils;


import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

	
	public static Date istDate() {
		
		Calendar calendar =Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"));
		Date now = new Date();
		calendar.setTime(now);
		return calendar.getTime();
	}
}
