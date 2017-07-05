package com.willard.javase.generic;

import java.util.ArrayList;

import com.willard.javase.bean.Person11;
import com.willard.javase.bean.Student;

public class Demo5_Generic {

	/**
	 * * A:����ͨ���<?>
			* �������ͣ����û����ȷ����ô����Object�Լ������Java����
		* B:? extends E
			* �����޶���E��������
		* C:? super E
			* �����޶���E���丸��
	 */
	public static void main(String[] args) {
		//List<?> list = new ArrayList<Integer>();			//���ұߵķ����ǲ�ȷ��ʱ,��߿���ָ��Ϊ?
		ArrayList<Person11> list1 = new ArrayList<>();
		list1.add(new Person11("����", 23));
		list1.add(new Person11("����", 24));
		list1.add(new Person11("����", 25));
		
		ArrayList<Student> list2 = new ArrayList<>();
		list2.add(new Student("����", 26));
		list2.add(new Student("����", 27));
		
		list1.addAll(list2);
		System.out.println(list1);
		
	}

}
