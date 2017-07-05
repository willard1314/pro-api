package com.willard.javase.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** 
* @ClassName: Date_Process 
* @Description: 日期处理方法汇总
* @author willard
* @date 2017年6月27日 上午9:06:23 
*  
*/
public class Date_Process {
	
	/** 
	* @Title: msecToDate 
	* @Description: 毫秒转换成具体的日期
	* @param      
	* @return void   
	* @throws 
	*/
	public String msecToDate(long time){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
		return sdf.format(new Date(time));
	}
	
	/** 
	* @Title: dateToMsec 
	* @Description: 将字符串类型的时间转成毫秒值
	* @param @param time
	* @param @return
	* @param @throws ParseException     
	* @return long   
	* @throws 
	*/
	public long dateToMsec(String time) throws ParseException{
		Calendar cld = Calendar.getInstance();
		cld.setTime(new SimpleDateFormat("yyyy-MM-dd hh:MM:ss").parse(time));
		return cld.getTimeInMillis();
	}
	
	

}
