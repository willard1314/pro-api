package com.willard.java2e.jmx.bean;

public interface HelloMBean {
	
	public String getName ();
	public void setName(String name);
	public void printName();
	public void printName(String whoName);
}
