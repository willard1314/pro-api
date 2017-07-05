package com.willard.javase.generic;

import org.junit.Test;

/**
 * 
 * <p>Title: Generic_Process </p>
 * <p>Description: �����г��ó��������ܽ�</p>
 * Date: 2017��6��30������3:46:22
 * @author zl
 * @version 1.0 
 * Significant Modify��
 * Date               Author           Content
 * ==========================================================
 * 2017��6��30��           zl        �����ļ�,ʵ�ֻ�������
 * 
 * ==========================================================
 */
public class Generic_Process {
	
	/** 
	* @Title: genericMethod 
	* @Description: ���ͷ�����ʹ��
	* <T> �� ��ʾΪ��������һ������ΪT����
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
