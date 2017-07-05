package com.willard.javase.string;

import com.willard.javase.modifier.AuthorityModifierDemo;

/** 
* @ClassName: StrBufBuilderDemo 
* @Description: String StringBuffer StringBuilder性能对比。
* @author willard
* @date 2017年6月1日 下午4:12:35 
*  
*/
public class StrBufBuilderDemo extends AuthorityModifierDemo{
	public static void main(String[] args) {
		//System.out.println(aModi);
		String str1 = null ;
		System.out.println(str1==null || str1.isEmpty());
		int len = 100;
		long t1 = System.currentTimeMillis();
		String str = "";
		for (int s = 0; s <len ; s++) {
			str = str + s; 
		}
		long t2 = System.currentTimeMillis();
		System.out.println("String数组装载"+len+"条数据，耗时"+(t2-t1)+"ms");
		
		long t3 = System.currentTimeMillis();
		StringBuffer sbuf = new StringBuffer();
		for (int s = 0; s < len; s++) {
			sbuf.append(s+"");
		}
		long t4 = System.currentTimeMillis();
		System.out.println("StringBuffer装载"+100000+"条数据，耗时"+(t4-t3)+"ms");
	}
}

