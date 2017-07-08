package com.willard.pattern.singleton;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * <p>Title: LazySingletonDemo </p>
 * <p>Description: 
 * 单例模式：懒汉式多线程环境
 * </p>
 * Date: 2017年7月8日上午10:49:36
 * @author zl
 * @version 1.0 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年7月8日           zl        创建文件,实现基本功能
 * 
 * ==========================================================
 */
public class SingletonDemo {
	
	
	private SingletonDemo(){}
	
	
	//2 private SingletonDemo(){}
	private static SingletonDemo lazySingle = null ;
	//懒汉式采用加锁的方式进行解决多线程环境下存在的安全问题
	public static SingletonDemo  getInstance() {
		if(lazySingle==null){
			//锁对象只能是当前类实例的字节码对象
			synchronized (SingletonDemo.class) {
			lazySingle = new SingletonDemo() ;
			return lazySingle;
			}
		}
		return lazySingle ;
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		//1 单线程环境下
		//SingletonDemo s1 = SingletonDemo.getInstance();
		//SingletonDemo s2 = SingletonDemo.getInstance();
		//System.out.println("单例模式下线程安全："+(s1==s2));
		
		//2 多线程模式下存在线程安全问题（结果示例：set:[com.willard.pattern.singleton.SingletonDemo@586f4a16, com.willard.pattern.singleton.SingletonDemo@334b8b84]）
		ThreadSingleTest ts  = new ThreadSingleTest();
		new Thread(ts).start();
		new Thread(ts).start();
		new Thread(ts).start();
		new Thread(ts).start();
		new Thread(ts).start();
		new Thread(ts).start();
		new Thread(ts).start();
		new Thread(ts).start();
		new Thread(ts).start();
		new Thread(ts).start();
		Thread.sleep(2000);
	    System.out.println("set:"+ts.set);
		
	}

}

 //验证多线程环境下单例模式存在的线程安全问题
 class ThreadSingleTest  implements Runnable{

	Set<SingletonDemo> set = new HashSet<>();

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SingletonDemo s = SingletonDemo.getInstance();
		set.add(s);
	}
	
}



