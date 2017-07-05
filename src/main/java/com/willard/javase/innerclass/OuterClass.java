package com.willard.javase.innerclass;

/** 
* @ClassName: OuterClass 
* @Description: 内部类的使用
* @author willard
* @date 2017年6月6日 下午3:54:40 
*  
*/
public abstract class OuterClass {
	static class InnerClass{int a =10 ;}
	public static  void foo() { new InnerClass(); }
	public void bar() { new InnerClass(); }
	public static void main(String[] args) {
		/*new InnerClass();
		System.out.println();*/
		
	    }
	abstract void method();
	

}
