package com.willard.javase.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class Demo01_HashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashMap<String,Integer> hm = new LinkedHashMap<String, Integer>();
		hm.put("k1", 11);
		hm.put("k2", 13);
		hm.put("k3", 13);
		hm.put("k4", 14);
		hm.put("k5", 15);
		//Collections.binarySearch(list, key)
		System.out.println(hm.get("k1"));
		//�Ƽ�ʹ��
		for(Map.Entry<String,Integer> entry : hm.entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		System.out.println("-----------------------------------");
		//����ȡֵ
		for(String s : hm.keySet()){
			System.out.println(s+":"+hm.get(s));
		}
		
		

	}

}
