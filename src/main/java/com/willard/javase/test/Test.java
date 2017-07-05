package com.willard.javase.test;

public class Test {
	static int  i = 10 ;
	{
		int i = 11 ;
	}
	
	public static void main(String[] args) {
		System.out.println(i);
		
	}

}
