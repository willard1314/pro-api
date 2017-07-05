package com.willard.javase.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * inputStream 与OutPutStream相关操作
 * @author zl
 *
 */
public class Demo01_InputOutputStream {
	
	/** 
	* @Title: readFile 
	* @Description: 最原始通过io流读取文件的方式
	* @param      
	* @return void   
	* @throws 
	*/
	@Test
	public void readFile() {
		FileInputStream fis=null;
		String path = "src/main//java/com/willard/javase/io/test.txt";
		try {
			fis = new FileInputStream(path);//文件绝对路径
			int a = 0 ;
			while((a = fis.read())!=-1){
				System.out.println(a);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/** 
	* @Title: writeFile 
	* @Description: 使用输出流写文件
	* @param      
	* @return void   
	* @throws 
	*/
	@Test
	public void writeFile(){
		String path = "src/main//java/com/willard/javase/io/testWrite.txt";
		String path1 = "src/main//java/com/willard/javase/io/test.txt";
		FileOutputStream fos = null ;
		FileOutputStream fos1 = null ;
		try {
			//使用字节数组的方式
			fos = new FileOutputStream(path);
			byte[] b = new byte[1024];
			b[0] = '1';
			b[1] = '2';
			b[2] = '3';
			fos.write(b);
			fos.close();
			//使用
			fos1 = new FileOutputStream(path1,true);
			fos1.write('d');
			fos1.write('e');
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fos1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) throws Exception {
	
       
     
       
       //3.0 结合1.2实现文件拷贝
       FileInputStream fisC = new FileInputStream("test.txt");
       FileOutputStream fosC = new FileOutputStream("test1.txt");
       int tem=0 ;
       while((tem = fisC.read())!=-1){
    	   fosC.write(tem);
       }
       fisC.close();
       fosC.close();
       
       //4.0对文件拷贝进行优化，
       FileInputStream fisC1 = new FileInputStream("test.txt");
       FileOutputStream fosC1 = new FileOutputStream("test2.txt");
       byte byteArr[] = new  byte[fisC1.available()]; //根据文件大小构造一个字节数组,充当缓冲区的作用
       fisC1.read(byteArr);
       fosC1.write(byteArr);
       //System.out.println("tem -----------: "+fosC1.);
       fisC1.close();
       //5.0 构造缓冲区
       FileInputStream fisC2 = new FileInputStream("test.txt");
       FileOutputStream fosC2 = new FileOutputStream("test3.txt");
       byte [] byteArr2 = new byte [8*1024]; 
       int len = 0 ;
       while ((len = fisC2.read(byteArr2))!=-1){ //一次读取8*1024个字符到字符串缓冲区 
    	   System.out.println("//nlen" + len); //len指的是字符数量
    	   fosC2.write(byteArr2);//将缓冲区中的数据写入到流中
       }
       
       System.out.println("//nlen" + len);
       fisC2.close();
       
       //6.0 使用输入输出缓冲区复制music.mp3文件
       FileInputStream fisC4 = new FileInputStream("music.mp3");
       BufferedInputStream bis = new BufferedInputStream(fisC4);
       FileOutputStream fosC4 = new FileOutputStream("copy.mp3");
       BufferedOutputStream bos = new BufferedOutputStream(fosC4);
       int len4 ;
       while((len4 = bis.read())!=-1){
    	   bos.write(len4); //一次写入len4个字符到输出缓冲区
       }
       bis.close();
       bos.close();
       
	}

}
