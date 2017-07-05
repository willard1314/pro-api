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
 * inputStream ��OutPutStream��ز���
 * @author zl
 *
 */
public class Demo01_InputOutputStream {
	
	/** 
	* @Title: readFile 
	* @Description: ��ԭʼͨ��io����ȡ�ļ��ķ�ʽ
	* @param      
	* @return void   
	* @throws 
	*/
	@Test
	public void readFile() {
		FileInputStream fis=null;
		String path = "src/main//java/com/willard/javase/io/test.txt";
		try {
			fis = new FileInputStream(path);//�ļ�����·��
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
	* @Description: ʹ�������д�ļ�
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
			//ʹ���ֽ�����ķ�ʽ
			fos = new FileOutputStream(path);
			byte[] b = new byte[1024];
			b[0] = '1';
			b[1] = '2';
			b[2] = '3';
			fos.write(b);
			fos.close();
			//ʹ��
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
	
       
     
       
       //3.0 ���1.2ʵ���ļ�����
       FileInputStream fisC = new FileInputStream("test.txt");
       FileOutputStream fosC = new FileOutputStream("test1.txt");
       int tem=0 ;
       while((tem = fisC.read())!=-1){
    	   fosC.write(tem);
       }
       fisC.close();
       fosC.close();
       
       //4.0���ļ����������Ż���
       FileInputStream fisC1 = new FileInputStream("test.txt");
       FileOutputStream fosC1 = new FileOutputStream("test2.txt");
       byte byteArr[] = new  byte[fisC1.available()]; //�����ļ���С����һ���ֽ�����,�䵱������������
       fisC1.read(byteArr);
       fosC1.write(byteArr);
       //System.out.println("tem -----------: "+fosC1.);
       fisC1.close();
       //5.0 ���컺����
       FileInputStream fisC2 = new FileInputStream("test.txt");
       FileOutputStream fosC2 = new FileOutputStream("test3.txt");
       byte [] byteArr2 = new byte [8*1024]; 
       int len = 0 ;
       while ((len = fisC2.read(byteArr2))!=-1){ //һ�ζ�ȡ8*1024���ַ����ַ��������� 
    	   System.out.println("//nlen" + len); //lenָ�����ַ�����
    	   fosC2.write(byteArr2);//���������е�����д�뵽����
       }
       
       System.out.println("//nlen" + len);
       fisC2.close();
       
       //6.0 ʹ�������������������music.mp3�ļ�
       FileInputStream fisC4 = new FileInputStream("music.mp3");
       BufferedInputStream bis = new BufferedInputStream(fisC4);
       FileOutputStream fosC4 = new FileOutputStream("copy.mp3");
       BufferedOutputStream bos = new BufferedOutputStream(fosC4);
       int len4 ;
       while((len4 = bis.read())!=-1){
    	   bos.write(len4); //һ��д��len4���ַ������������
       }
       bis.close();
       bos.close();
       
	}

}
