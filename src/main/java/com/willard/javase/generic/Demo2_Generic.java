package com.willard.javase.generic;

import java.util.ArrayList;
import java.util.Iterator;

import com.willard.javase.bean.Person11;

public class Demo2_Generic {

	/**
	 * * A:������ʾ
	 * ArrayList�洢�ַ������������Ͱ�
	 */
	public static void main(String[] args) {
		//demo1();
		ArrayList<Person11> list = new ArrayList<>();
		list.add(new Person11("����", 23));
		list.add(new Person11("����", 24));
		list.add(new Person11("����", 25));
		list.add(new Person11("����", 26));
		
		Iterator<Person11> it = list.iterator();
		while(it.hasNext()) {
			Person11 p = it.next();							//�������е�ÿһ��Ԫ����Person��¼
			System.out.println(p.getName() + "..." + p.getAge());
		}
	}

	public static void demo1() {
		ArrayList<String> list = new ArrayList<>();			//�������϶���
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
