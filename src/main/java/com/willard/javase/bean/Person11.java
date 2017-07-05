package com.willard.javase.bean;

import java.io.Serializable;

public class Person11 implements Serializable {
	private String name;
	private int age;
	public Person11() {
		super();
		
	}
	public Person11(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("ִ������");
		Person11 p = (Person11)obj;
		return this.name.equals(p.name) && this.age == p.age;
	}
	
}
