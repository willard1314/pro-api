package com.willard.javase.clone;

public class CloneDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Demo d1 = new Demo();
		d1.setName("测试使用实现Cloneable接口进行对象拷贝");
		Demo d2 = (Demo) d1.clone();
		System.out.println(d2.getName());
	}
}

class Demo implements Cloneable {
	private String name;
	private int age;

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
	protected Object clone() throws CloneNotSupportedException {
		Demo d1 = null;
		d1 = (Demo) super.clone();
		// TODO Auto-generated method stub
		return d1;
	}

}
