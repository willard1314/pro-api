package com.willard.javase.string;

public class Factorial {
    //this is a recursive function
    static int fact(int n){
        if (n==1) return 1;
        return fact(n-1)*n;
    }
     public static void main(String[] args) {
    	 System.out.println("factorial(5)="+fact(5));
	}
}
