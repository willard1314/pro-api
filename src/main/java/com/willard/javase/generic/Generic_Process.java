package com.willard.javase.generic;

import org.junit.Test;

/**
 * 
 * <p>Title: Generic_Process </p>
 * <p>Description: 泛型中常用场景进行总结</p>
 * Date: 2017年6月30日下午3:46:22
 * @author zl
 * @version 1.0 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年6月30日           zl        创建文件,实现基本功能
 * 
 * ==========================================================
 */
public class Generic_Process {
	
	/** 
	* @Title: genericMethod 
	* @Description: 泛型方法的使用
	* <T> ： 表示为方法声明一个类型为T的类
	* @param @return     
	* @return boolean   
	* @throws 
	*/
	public <T> void genericMethod(T t){
		System.out.println(t.getClass());
	}
	
	@Test
	public void testGenericMethod(){
		genericMethod("test");
		genericMethod(1000);
	}

}
