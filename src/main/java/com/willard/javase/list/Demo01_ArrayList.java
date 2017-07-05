package com.willard.javase.list;

import java.util.ArrayList;
import java.util.Iterator;

import com.willard.javase.bean.Person11;

/**
 * * A:案例演示
		* 需求：ArrayList去除集合中自定义对象元素的重复值(对象的成员变量值相同)
	* B:注意事项
		* 重写equals()方法的
	contains方法判断是否包含,底层依赖的是equals方法
	remove方法判断是否删除,底层依赖的是equals方法
 */
public class Demo01_ArrayList {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Object> list = new ArrayList<Object> ();
		ArrayList<Object> newList = new ArrayList<Object> ();
		list.add(new Person11("name1",11));
		list.add(new Person11("name2",21));
		list.add(new Person11("name2",21));
		list.add(new Person11("name4",41));
		list.add(new Person11("name1",11));
		Iterator<Object> it = list.iterator();
		while(it.hasNext()){
			Object obj = it.next();
			if(!newList.contains(obj)){
				//System.out.println(obj);
				newList.add(obj);
			}
		}
		System.out.println(newList);
		

	}

}
