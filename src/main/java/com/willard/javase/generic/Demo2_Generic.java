package com.willard.javase.generic;

import java.util.ArrayList;
import java.util.Iterator;

import com.willard.javase.bean.Person11;

public class Demo2_Generic {

	/**
	 * * A:案例演示
	 * ArrayList存储字符串并遍历泛型版
	 */
	public static void main(String[] args) {
		//demo1();
		ArrayList<Person11> list = new ArrayList<>();
		list.add(new Person11("张三", 23));
		list.add(new Person11("李四", 24));
		list.add(new Person11("王五", 25));
		list.add(new Person11("赵六", 26));
		
		Iterator<Person11> it = list.iterator();
		while(it.hasNext()) {
			Person11 p = it.next();							//将集合中的每一个元素用Person记录
			System.out.println(p.getName() + "..." + p.getAge());
		}
	}

	public static void demo1() {
		ArrayList<String> list = new ArrayList<>();			//创建集合对象
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
