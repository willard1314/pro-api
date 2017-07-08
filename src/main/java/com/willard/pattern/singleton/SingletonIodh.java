package com.willard.pattern.singleton;

/**
 * 
 * <p>Title: SingletonIodh </p>
 * <p>Description: 
 * IODH方式实现单例，这种目前实现单例模式比较好的一种方式
 * </p>
 * Date: 2017年7月8日下午5:46:48
 * @author zl
 * @version 1.0 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年7月8日           zl        创建文件,实现基本功能
 * 
 * ==========================================================
 */
public class SingletonIodh {
	//1 私有化构造函数
	private SingletonIodh(){}
	//2 静态内部类中创建单实例对象
	private static  class SingletonHolder{
		private static final SingletonIodh instance = new SingletonIodh();
	}
	//3 提供公共方法
	public static final SingletonIodh getInstance(){
		return SingletonHolder.instance;	
	}  
	

	public static void main(String[] args) {
		//验证是否返回同一实例
		SingletonIodh s1 =  SingletonIodh.getInstance();
		SingletonIodh s2 =  SingletonIodh.getInstance();
		System.out.println(s1==s2);

	}

}
