package com.willard.javase.generic;

import java.util.ArrayList;
import java.util.Iterator;

import com.willard.javase.bean.Person11;


public class Demo1_Generic {

	/**
	 	* A:���͸���
		* B:���ͺô�
			* ��߰�ȫ��(�������ڵĴ���ת����������) 
			* ʡȥǿת���鷳
		* C:���ͻ���ʹ��
			* <>�зŵı����������������� 
		* D:����ʹ��ע������
			* ǰ��ķ��ͱ���һ��,���ߺ���ķ��Ϳ���ʡ�Բ�д(1.7�����������η���)  

	 */
	public static void main(String[] args) {
		//demo1();
		//int[] arr = new byte[5];							//����Ҫ��֤ǰ�����������һ��
		//ArrayList<Object> list = new ArrayList<Person>();	//���ϵķ���Ҫ��֤ǰ�����������һ��
		//ArrayList<Object> list = new ArrayList<>();		//1.7�汾��������,���η���
		ArrayList<Object> list = new ArrayList<>();			//������ò�Ҫ�����Object,û������
		list.add("aaa");
		list.add(true);
	}

	public static void demo1() {
		ArrayList<Person11> list = new ArrayList<Person11>();
	//	list.add(110);
	//	list.add(true);
		list.add(new Person11("����", 23));
		list.add(new Person11("����", 24));
		
		Iterator<Person11> it = list.iterator();
		while(it.hasNext()) {
			//System.out.println(it.next());
			
			//System.out.println(it.next().getName() + "..." + it.next().getAge());//next����ֻ�ܵ���һ��,������ö�λὫָ������ƶ����
			Person11 p = it.next();			
			System.out.println(p.getName() + "..." + p.getAge());
		}
	}

}
