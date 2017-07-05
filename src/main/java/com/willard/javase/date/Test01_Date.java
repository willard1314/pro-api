package com.willard.javase.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** 
* @ClassName: Demo01_Date 
* @Description: 日期类相关操作，测试类
* @author willard
* @date 2017年6月27日 上午9:01:00 
*  
*/
public class Test01_Date {

	public static void main(String[] args) throws ParseException {
		// 毫秒转成具体日期
		long time = 1490025652746L;
		Date date = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss a");
		String times = sdf.format(date);
		System.out.println(times);
		
		
		
		// 日期转成毫秒
		Calendar cal = Calendar.getInstance();
		cal.setTime(new SimpleDateFormat("yyyy-MM-dd hh:MM:ss").parse(times));
		System.out.println(cal.getTimeInMillis());
		
		
		
	
		
		

	}

}
