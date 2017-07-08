package com.willard.pattern.singleton;

public class SingletonEnumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingletonEnum s1 = SingletonEnum.instance;
		SingletonEnum s2 = SingletonEnum.instance;
		System.out.println(s1==s2);

	}

}
