package com.willard.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>Description:时间处理工具类</p>
 * <p>Copyright: 版权所有 (c) 2016</p>
 * @author zlb
 * 2016年5月24日上午11:11:22
 */
public class DateUtil {
	
	

	/**
	 * 解析时间字符串成日期对象。
	 * eg: System.out.println(DataUtil.parseDate("2011-3-1 12:09:00")); 
	 * 		System.out.println(DataUtil.parseDate("2000-1-1"));
	 * 
	 * @param dateStr 支持日期和日期加时间两种格式的解析。如：“2000-1-1”和 "2011-3-1 12:09:00"
	 * @return Date 日期对象
	 * @throws Exception
	 */
	public static Date parseDate(String dateStr) throws Exception{
		java.text.SimpleDateFormat sim = null;
		if(dateStr.indexOf(":")>0) {
			sim=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		} else  {
			sim=new java.text.SimpleDateFormat("yyyy-MM-dd");
		}
		Date d=sim.parse(dateStr);
		return d;
	}
	
	
    /**
     * 得到当前时间的字符串表示。
     * eg: System.out.println(DataUtil.getNowTimeString());
     * 
     * @return 字符串，如：2015-02-26 08:23:06
     */
    public static String getNowTimeString(){
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
    	return df.format(new Date());
    }
    
    
    /**
     * 计算给出时间计算并格式化后的字符串。第二个参数表示给出时间的时间差。正数表示XX秒以后，负数表示XX秒钟以前。
     * eg: String sessionTimeoutLimitStr = DateUtil.calDatetimeString(new Date(),  -1* 30*60);
     * 
     * @param date 时间格式
     * @param adjustSeconds 时间调整数，单位：秒
     * @return 返回调整时间后的格式化时间字符串
     */
    public static String calDatetimeString(Date date, int adjustSeconds){
    	if(adjustSeconds!=0) date.setTime(date.getTime() + adjustSeconds*1000);
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	return df.format(date);
    }
	
	/**
	 * <p>Description: 判断两个时间的时间差是否在一个限定的范围之内</p>
	 * eg:12小时之内limit=12*3600000.00;
	 * @param firstTime
	 * @param secondTime
	 * @param limit
	 * @return
	 */
	public static boolean timeScope(Timestamp firstTime,Timestamp secondTime ,double limit){
		double timeAbs = Math.abs((double)(firstTime.getTime()-secondTime.getTime()));
		if(timeAbs-limit <= 0){
		return true ;
		}else
		return false ;
		
	}
	
	/**
	 * <p>Description: 获取指定需求的时间，以当前：年-月-日 00时00分00秒为基准获取</p>
	 * eg filed:Calendar.year amount:-2 以基准时间为标准获取两年前的时间。
	 * @param filed
	 * @param amount
	 * @return
	 */
	public static Date getRequiredTime(int field , int amount){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(field, amount);
		return calendar.getTime();
		
	}

	
	
	/** 
	* @Title: main 
	* @Description: 对当前工具类中的方法进行测试
	* @param @param args      
	* @return void   
	* @throws 
	*/
	/*public static void main(String[] args) {
		LocalDate local = LocalDate.now();
		System.out.println();
	}*/
}


