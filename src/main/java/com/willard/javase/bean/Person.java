package com.willard.javase.bean;

public class Person  implements Comparable<Person> {
	private String name;
	private int age;
	public Person() {
		super();
		
	}
	public Person(String name, int age) {
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
	
	//比较对象元素是否重复，需要复写equals和hashcode方法
	@Override
	public boolean equals(Object obj) { //比较两个对象指定字段元素内容是否一致
		Person p = (Person)obj;
		return this.name.equals(p.name)&& this.age==p.age ;
	}
	@Override
	public int hashCode() {
		final int num = 38 ;
		return name.hashCode()*num +age;
	}
	
//	private void compareTo() {
//		System.out.println("我是compareTo方法");
//
//	}
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int compareTo(Person p) {
		// TODO Auto-generated method stub
		return 0;
	}

}
