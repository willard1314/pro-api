package com.willard.javase.static1;

/** 
* @ClassName: Test01_Static 
* @Description: TODO
* 1 静态方法只能访问静态成员，不能访问非静态成员(方法，属性)
* @author willard
* @date 2017年6月27日 下午3:24:40 
*  
*/
public class Test01_Static {
	private String param = "成员";
	
	public static void staticMethod(){
		System.out.println("静态方法");
//		commonMethod();
//		System.out.println(param);
	}
	
	public void commonMethod(){
		staticMethod();
	}
	public static void main(String[] args) {
		
	}

}
