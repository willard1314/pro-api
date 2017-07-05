package com.willard.javaee.spring.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * <p>Title: QualifierAnnotation </p>
 * <p>Description: 测试类</p>
 * Date: 2017年6月30日下午1:01:14
 * @author zl
 * @version 1.0 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年6月30日           zl        创建文件,实现基本功能
 * 
 * ==========================================================
 * Qualifier的用法：
 * 当一个接口有多个实现类时，并且这多个实现类被注解指定 如： @service
 * 用Qualifier("XXX")  用于指定具体哪个接口的实现类，被使用。和Autowired 注解联合使用
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:annotation.xml"})
public class QualifierAnnotationTest {
	
	
	@Autowired
	@Qualifier("service_a")
	private Company company ;
	
	@Test
	public void testAnnotation(){
		company.employPay();
	}
	

}
