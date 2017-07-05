package com.willard.javase.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
* 案例演示
* 需求：请用LinkedList模拟栈数据结构的集合，并测试
* 创建一个类将Linked中的方法封装
* 思路：追加新元素到集合尾部，元素取出时从集合尾部开始取。
* @author zl
*/
public class Demo01_LinkedList {
	
	private static void in(LinkedList<String> list,String o){
		
		list.addLast(o);
	}
	private static void out(LinkedList<String> list){
		//list.removeLast();
		System.out.println("out:"+list.removeLast());
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> ll = new LinkedList<String>();
		in(ll, "1");
		in(ll, "2");
		in(ll, "3");
		System.out.println("in:"+ll);
		out(ll);
		out(ll);
		out(ll);
		
/*		LinkedList<String> lk = new LinkedList<String>();
		lk.add("1");
		lk.add("2");
		lk.add("3");
		System.out.println(lk);
		System.out.println("first"+lk.removeFirst());*/
		
		 List list = new ArrayList();
		 list.add("qqyumidi");
		 list.add("corn");
		 list.add(100);
		 System.out.println(list);
		 for (int i = 0; i < list.size(); i++) {
			 Object name = (Object) list.get(i); // 1
			 System.out.println("name:" + name);
			 }
	}

}
