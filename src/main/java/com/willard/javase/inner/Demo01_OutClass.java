package com.willard.javase.inner;

/** 
* @ClassName: Demo01_InnerClass 
* @Description: 内部类几种方式
* 1 成员内部类
* 2 静态内部类
* 3 局部内部类
* 4 匿名内部类
* @author willard
* @date 2017年6月26日 下午3:07:01 
*  
*/
public class Demo01_OutClass {
	private String name="我是一个外部类成员变量" ;
	
	public static void main(String[] args) {
		//1.0 创建成员内部类对象，必须先创建一个外部类对象
		Demo01_OutClass outClass = new Demo01_OutClass();
		MemberInnerClass memInnerClass =outClass.new MemberInnerClass();
		memInnerClass.innerClassMethod();
		System.out.println(memInnerClass.age);
		
		//2.0 局部内部类
		outClass.outClassMethod();
		
		//3.0 嵌套内部类
		System.out.println(NestInnerClass.nestName);
		NestInnerClass.nestInnerClassStaticMethod();
		NestInnerClass.nestInnnerClassCommonMethod();
		
		//4.0匿名内部类
		outClass.anonymityInnerClassMethod();
		
		
	}
	
	
	/** 
	* @ClassName: MemberInnerClass 
	* @Description: 成员内部类
	* 1  成员内部类可以直接访问外部类的所有数据
	* 2 外部类访问成员内部类，需要使用内部类的对象.eg: new 外部类.new 内部类()
	* @author willard
	* @date 2017年6月26日 下午3:08:04 
	*  
	*/
	public class MemberInnerClass{
		private int age = 100 ;
		public void innerClassMethod(){
			System.out.println("内部类访问外部类数据："+name);
		}
	}
	
	
	
	/** 
	* @Title: outClassMethod 
	* @Description:
	* 1   局部内部类，定义在方法和作用域内。
	* 2   局部内部类只在其所在的方法或作用域内有效。
	* @param      
	* @return void   
	* @throws 
	*/
	public void outClassMethod(){
		class LocalInnerClass{
			private String localName = "局部内部类" ;
		}
		System.out.println(new LocalInnerClass().localName);
	}
	

	/** 
	* @ClassName: NestInnerClass 
	* @Description: 嵌套内部类
	* 1   嵌套内部类使用static关键字修饰
	* 2   嵌套内部类可以定义静态成员变量，非嵌套内部类不可以。
	* 3  外部类访问嵌套内部类的方法或者属性可以直接使用  类名. 的方式，而不需要创建对象。
	* 扩展：只有内部类才可以被声明为静态
	* @author willard
	* @date 2017年6月27日 上午11:08:15 
	*  
	*/
	public static class NestInnerClass{
		static String nestName = "嵌套内部类";
		static void nestInnerClassStaticMethod(){
			System.out.println("嵌套内部类的静态方法");
			System.out.println("外部类属性值："+ new Demo01_OutClass().name);
		}
		static void nestInnnerClassCommonMethod(){
			System.out.println("嵌套内部类普通方法");
		}
	}
	
	
	/** 
	* @Title: anonymityInnerClassMethod 
	* @Description: 匿名内部类的几种方式
	* @param      
	* @return void   
	* @throws 
	*/
	public void anonymityInnerClassMethod(){
		//基于接口式
		AnonymityInnerClassInterf anony = new AnonymityInnerClassInterf(){
			@Override
			public void anonymity() {
				System.out.println("我是一个接口式的匿名内部类！");
			}
		};
		anony.anonymity();
		
		//基于继承式
		Thread t = new Thread(){
			@Override
			public void run() {
				System.out.println("thread匿名内部类的写法！");
			}
		};
		t.start();
	}
	
	
	
	
}

/**
 * 匿名内部类：
 *1 接口式的匿名内部类
 *2 继承式的匿名内部类
 *3 参数式的匿名内部类
 * */
interface AnonymityInnerClassInterf{
	void anonymity();
};







