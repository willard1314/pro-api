package com.willard.javase.infa;

/**
 * Java中的接口
 * @author zl
 *
 */
interface Demo01_Interface {
	public void method();

}
/**
 * 抽象类
 * @author zl
 *
 */
abstract class Demo01_Abstract implements Demo01_Interface{
	
}

/**普通类
 * @author zl
 *
 */
class Demo01_Ordinary implements Demo01_Interface{

	@Override
	public void method() {
		// TODO Auto-generated method stub
		System.out.println("非抽象类必须实现接口中的所有方法");
	}
	
}