package com.willard.javase.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import com.willard.javase.bean.Person;

/** 
* @ClassName: DataProcessForList 
* @Description: List常用数据处理方法
* @author willard
* @date 2017年6月22日 上午9:54:46 
*  
*/
public class DataProcessForList {
	
	
	/*----------------------------去除集合中重复元素begin-------------------------*/
	/** 
	* @Title: getNewArrayList 
	* @Description: 使用iterator的方式取出重复元素；保证了元素的顺序
	* @param      
	* @return void   
	* @throws 
	*/
	public static void getNewArrayList(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("2017-01-10");
		list.add("2017-01-11");
		list.add("2017-01-11");
		list.add("2017-01-12");
		ArrayList<String> newList  = new ArrayList<String>();
		for(Iterator<String> it = list.iterator();it.hasNext();){
			String str = it.next();
			if(!newList.contains(str)){
				newList.add(str);
			}
		}
		list.clear();
		list.addAll(newList);
		System.out.println(newList);
	}
	
	/** 
	* @Title: getNewArrayListTHashSet 
	* @Description: 通过HashSet的方式去除集合中的重复元素;但是HashSet本生不保证元素的顺序
	* @param      
	* @return void   
	* @throws 
	*/
	@Test
	public  void getNewArrayListTHashSet(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("2017-01-10");
		list.add("2017-01-11");
		list.add("2017-01-11");
		list.add("2017-01-12");
		list.add("2017-01-15");
		list.add("2017-01-14");
		list.add("2017-01-10");
		//通过HashSet去除重复元素
		Set<String> set = new HashSet<String>(list);
		ArrayList<String> newList = new ArrayList<String>(set);
		System.out.println(newList);
	}
	
	/** 
	* @Title: getNewListTreeSet 
	* @Description: 通过TreeSet的方式对集合进行去除重复
	* @param      
	* @return void   
	* @throws 
	*/
	@Test
	public void getNewListTreeSet(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("e");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("a");
		list.add("b");
		list.add("d");
		//通过TreeSet去除重复后，保持原有顺序
		Set<String> set = new TreeSet<String>(list);
		ArrayList<String> newList = new ArrayList<String>(set);
		System.out.println(newList);
	}
	
	@Test
	public void removeListElement(){
		List<Person> list = new  ArrayList<Person>();
		list.add(new Person("1",11));
		list.add(new Person("2",12));
		list.remove(new Person("1",11));
		System.out.println(list);
	}
	/*----------------------------去除集合中重复元素end-------------------------*/
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getNewArrayList();
	}


}
