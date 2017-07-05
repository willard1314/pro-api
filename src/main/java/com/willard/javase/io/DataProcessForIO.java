package com.willard.javase.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.Test;

/** 
 * 说明：针对对应的知识点给出相应的demo
* @ClassName: DataProcessForIO 
* @Description: 通过io操作处理数据
* @author willard
* @date 2017年6月23日 下午10:33:37 
*  
*/
public class DataProcessForIO {
	
	/**
	 * @throws Exception  
	* @Title: copyFile 
	* @Description: 将一个文件的内容读取到另一个文件中
	* @param      
	* @return void   
	* @throws 
	*/
	@Test
	public void copyFile() throws Exception{
		String path = "src/main//java/com/willard/javase/io/music.mp3";
		String path1 = "src/main//java/com/willard/javase/io/copy.mp3";
		FileInputStream fis = new FileInputStream(path);
		FileOutputStream fos = new FileOutputStream(path1);
		byte [] byteArr = new byte[fis.available()];
		
		//通过数组进行读写
		fis.read(byteArr);
		fos.write(byteArr);
		
		fis.close();
		fos.close();
		fos.flush();
		System.out.println("拷贝完成");
	}

}
