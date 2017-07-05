package com.willard.javase.exception;

public class ExceptionDemo01 {

	public static void main(String[] args) {
		try {
		    throw new ExampleB("b");
		} catch(ExampleA e){
		    System.out.println("ExampleA");
		} catch(Exception e){
		    System.out.println("Exception");
		}
		
	}
}

class ExampleA extends Exception{
	public ExampleA(){
		System.out.println("ExampleA- 构造函数");
	}
}

class ExampleB extends ExampleA{
	public ExampleB(String string) {
		System.out.println("str" + string);
	}}
