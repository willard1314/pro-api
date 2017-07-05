package com.willard.javase.string;

import org.junit.Test;

/** 
* @ClassName: StringProcess 
* @Description: 字符串处理的相关方式
* @author willard
* @date 2017年6月27日 下午3:37:58 
*  
*/
public class StringProcess {

	
	/** 
	* @Title: reversalString 
	* @Description: 利用递归的方法截取字符串
	* 当字符串为空或者只有一个时不需要反转
	*   思路：
	* 
	* @param @param originStr
	* @param @return     
	* @return String   
	* @throws 
	*/
	public static String reversalString(String originStr){
		//System.out.println("---1:"+originStr);
		if(originStr==null || originStr.length()<=1)
			return originStr ;
		System.out.println(reversalString(originStr.substring(1)));
		return reversalString(originStr.substring(1))+originStr.charAt(0) ;
	}
	
	/** 
	* @Title: interceptStr 
	* @Description: 字符串接确
	* @param      
	* @return void   
	* @throws 
	*/
	@Test
	public void interceptStr(){
		String str = "Section 7.4	Record 12222 – Base Sale Record基本销售记录";
		int begin = str.indexOf("Record");
		str = str.substring(begin);
		String[] sArr = str.split(" – ");
		System.out.println(sArr[0].substring(str.indexOf("d")+1).trim());
		System.out.println(sArr[1]);
	}
	
	
	
	public static void main(String[] args) {
		String st = "create table Base_Sale_Record (TDNR,CDGT,CREL,CTOT,CPTK,CPUI,PNRR,PXNM,DAIS,TIOT,AGTN/ALON,VLNC,BOON,BISO,POIS,TISO)";
		st = st.replaceAll("/", "_");
		System.out.println(st);
		
		// TODO Auto-generated method stub
		String str = "abcde";
		str = reversalString(str);
		System.out.println(str);
		
		//使用string自带方法
		StringBuilder sb = new StringBuilder(str);
		//System.out.println("stringBuilder方式反转:"+sb.reverse());
		
	}

}
