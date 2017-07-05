package com.willard.javase.keyword;

/** 
* @ClassName: KeyWordDemo 
* @Description: java中关键说明
* 1）
* @author willard
* @date 2017年6月6日 上午11:11:07 
*  
*/
public class KeyWordDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float f=3.411116789F;
		double d = 3.123456789012345111111;
		System.out.println(f);
		System.out.println(d);
		//short s1 = 1; s1 = s1 + 1;
		short s1 = 1; s1 += 1;
		
		//简单的说，如果整型字面量的值在-128到127之间，那么不会new新的Integer对象，而是直接引用常量池中的Integer对象，所以上面的面试题中f1==f2的结果是true，而f3==f4的结果是false。
		Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
        
        //左移
        System.out.println(5<<2);
        //优化31*2
        System.out.println((2<<5)-2);
	}

}
