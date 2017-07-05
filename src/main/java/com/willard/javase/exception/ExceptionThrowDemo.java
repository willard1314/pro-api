package com.willard.javase.exception;

public class ExceptionThrowDemo {
	public static void main  (String[] args) throws Exception{
		int[] a = new int []{1,2};
		for(int i=0;i<=4;i++){
			//System.out.println("i="+i+":"+a[i]);
			try {
				System.out.println("i="+i+":"+a[i]);
			} catch (Exception e) {
				System.out.println("i="+i+":"+e);
			}
			System.out.println("发生异常后：");

		}
	}
	
	String method(int a){
		try{
			if(a==0)
				return "i am a string";
		}
		catch(Exception e){
			System.out.println(e);
		}
		return null ;
	}
	

}
