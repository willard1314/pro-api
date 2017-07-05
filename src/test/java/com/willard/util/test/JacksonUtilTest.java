package com.willard.util.test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.willard.util.json.JacksonUtil;


public class JacksonUtilTest {
	
	@Test
	public void testMaptoJson(){
		List<Object> list = new ArrayList<Object>();
		for(int i=0;i<4;i++){
		Map<String,String> map = new HashMap<String,String>();
		String data[] = new String[]{"data1","data2"};
		map.put("name", "zhang--"+i);
		map.put("age", "11");
		map.put("data", data.toString());
		String jsonStr = JacksonUtil.convertObjToStr(map);
		list.add(jsonStr);
		}
		System.out.println(list);
		
	}
	
	
	
	@Test
	public void testTwoArrayToJson(){
		String str[][] = new String[2][1];
		str[0][0] ="data001";
		str[1][0] ="data002";
		String jsonStr = JacksonUtil.convertObjToStr(str);
		System.out.println(jsonStr);
	}
	
	@Test
	public void testListToJson(){
		List<String> list = new ArrayList<String> ();
		list.add("Attl");
		list.add("anaPnr");
		list.add("pnr");
		String jsonStr = JacksonUtil.convertObjToStr(list);
		System.out.println(jsonStr);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
