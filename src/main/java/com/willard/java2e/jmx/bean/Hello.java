package com.willard.java2e.jmx.bean;

public class Hello implements HelloMBean{

	private String name ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void printName() {
		// TODO Auto-generated method stub
		System.out.println("hello word "+name);
	}

	public void printName(String whoName) {
		// TODO Auto-generated method stub
		System.out.println("hello " + name);
	}

	public void printHello(String message) {
		System.out.println("Hello World, " + message);
		
	}
}
