package com.willard.javase.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;


public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashMap<String,String> hashMap = new LinkedHashMap();
		hashMap.put("key01", "v01");
		hashMap.put("key02", "v02");
		hashMap.put("key03", "v03");
		hashMap.put("key04", "v04");
		hashMap.put(" ", " ");
		hashMap.put("11 ", " ");	
		hashMap.put("112 ", " ");
		System.out.println(hashMap);
		Map<String,String> h = Collections.synchronizedMap(hashMap);
		//Hashtable<String,String>   h = new Hashtable<String,String>   ();
		/*h.put("key01", "v01");
		h.put("key02", "v02");
		h.put("key03", "v03");
		h.put("key04", "v04");*/
		/*h.put(" ", " ");
		h.put("11 ", " ");
		h.put("112 ", " ");*/
		System.out.println(h);

	
	}
}
