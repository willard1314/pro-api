package com.willard.pattern.factory;

public class ShapeFactoryTest {

	public static void main(String[] args) {
		//工厂实例
		ShapeFactory sf = new ShapeFactory();
		
		//从工厂中取出自己想要的实例，进行相应的操作。
		Shape shape = sf.getShape("circle");
		shape.drow();
		
		Shape s1 = sf.getShape("rectangle");
		s1.drow();
		
		Shape s2 = sf.getShape("square");
		s2.drow();
	}

}
