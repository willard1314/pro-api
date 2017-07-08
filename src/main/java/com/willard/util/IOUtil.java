package com.willard.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.FileNameMap;
import java.net.URLConnection;



/**
 * 
 * <p>Title: IOUtil </p>
 * <p>Description: IO流操作工具类</p>
 * Date: 2017年7月8日下午6:19:38
 * @author zl
 * @version 1.0 
 * Significant Modify：通过工厂模式优化工具类
 * Date               Author           Content
 * ==========================================================
 * 2017年7月8日           zl        创建文件,实现基本功能
 * 
 * ==========================================================
 */
public class IOUtil {
	//1 私有化构造函数
	private IOUtil(){}
	//2 静态内部类
	private static class SingletonIO{
		private static final IOUtil instance = new IOUtil();
	}
	//3 对外提供公共实例
	public static final IOUtil getInstance(){
		return SingletonIO.instance;
	}
	
	
	/**
	 * 读取文本文件
	 * eg: 	IOUtil.writeTextFile("d:/temp/aa.txt", "hello world 1", false);
	 *		System.out.println(IOUtil.readTextFile("d:/temp/aa.txt"));
	 *
	 * @param fileName 文件全路径名称
	 * @return 字符串
	 * @throws Exception 异常
	 */
	public static String readTextFile(String fileName) throws Exception{
		BufferedReader br=new BufferedReader(new FileReader(fileName));
		String line="";
		StringBuffer buffer = new StringBuffer();
		while((line=br.readLine())!=null){
			buffer.append(line);
		}
		br.close();
		return buffer.toString();
	}
  
	
	
	/**
	 * 写入文本文件
	 * eg: 	IOUtil.writeTextFile("d:/temp/aa.txt", "hello world 1", false);
	 *		System.out.println(IOUtil.readTextFile("d:/temp/aa.txt"));
	 *
	 * @param fileName 文本文件全路径名
	 * @param fileData 欲写入的文本内容
	 * @param appendFlag 为True时表示在文档最后面追加。为False时，为覆写
	 * @throws Exception
	 */
	public static void writeTextFile(String fileName, String fileData, boolean appendFlag) throws Exception{
		File file = new File(fileName);
		if(appendFlag){
			BufferedWriter ow = new BufferedWriter(new FileWriter(file, true));
			ow.append(fileData);
			ow.close();
		}else{
			BufferedWriter ow = new BufferedWriter(new FileWriter(file));
			ow.write(fileData);
			ow.close();
		}
	}
	
	
	/**
	 * 读取二进制文件
	 * eg: 	byte[] barr = IOUtil.readBinFile("d:/temp/NewPlatform.rar");
	 * 		IOUtil.writeBinFile("d:/temp/NewPlatform1.rar", barr);
	 * 
	 * @param fileName 二进制文件全路径名称
	 * @return 返回文件二进制数组
	 * @throws Exception
	 */
	public static byte[] readBinFile(String fileName) throws Exception{  
		File file =new File(fileName);  
		long len = file.length();  
		byte[] bytes = new byte[(int)len];
		BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(file));  
		int r = bufferedInputStream.read(bytes);  
		 if (r != len){ LogUtil.exception("IOUtil.readBinFile("+fileName+") 读写文件异常"); } 
        bufferedInputStream.close();  
        return bytes;  
    }
	
	
	/**
	 * 写入二进制文件
	 * eg: 	byte[] barr = IOUtil.readBinFile("d:/temp/NewPlatform.rar");
	 * 		IOUtil.writeBinFile("d:/temp/NewPlatform1.rar", barr);
	 * 
	 * @param fileName 二进制文件全路径名称
	 * @param data 二进制数组
	 * @throws Exception
	 */
	public static void writeBinFile(String fileName, byte[] data) throws Exception{
		FileOutputStream fos = new FileOutputStream(fileName);  
		fos.write(data);
		fos.close();  
	}
	
	 
	/**
	 * 根据文件扩展名获得文件MIME类型。失败返回空“”。
	 * eg: System.out.println(IOUtil.getMimeType("a.xml"));
	 * 
	 * @param fileName 文件名，带不带路径均可
	 * @return MIME类型
	 * @throws Exception
	 */
	public static String getMimeType(String fileName)  throws Exception {
		
		//提取扩展名，若扩展名为空，则直接返回失败
		String extendStr = null;
		int dindex = fileName.trim().lastIndexOf(".");
		if(dindex>=0) 
			extendStr = fileName.substring(dindex).toLowerCase();
		else
			return "";
		//匹配mime类别（匹配特定扩展名，相当于是补充使用）
		//参考：http://tool.oschina.net/commons
		switch(extendStr){
			case ".jpg": return "image/jpeg";
			case ".png": return "image/png";
			case ".bmp": return "application/x-bmp";
			case ".jpeg": return "image/jpeg";
			case ".ico": return "image/x-icon";
			case ".tiff": return "image/tiff";
			
			case ".txt": return "text/plain";
			case ".html": return "text/html";
			case ".htm": return "text/html";
			case ".js":   return "application/x-javascript";
			case ".jsp": return "application/x-internet-signup";
			case ".java": return "java/*";
			case ".css": return "text/css";
			case ".xml": return "text/xml";
			case ".wml": return "text/vnd.wap.wml";
			
			case ".mp3": return "audio/mp3";
			case ".wav": return "audio/x-wav";
			case ".mp2": return "audio/mp2";
			case ".mid": return "audio/mid";
			case ".wma": return "audio/x-ms-wma";
			
			case ".mp4": return "video/mpeg4";
			case ".swf": return "application/x-shockwave-flash";
			case ".mpeg": return "video/mpg";
			case ".rmvb": return "application/vnd.rn-realmedia-vbr";
			
			case ".apk": return "application/vnd.android.package-archive";
			case ".ipa": return "application/vnd.iphone";
			case ".vsd": return "application/x-vsd";
			case ".xls": return "application/x-xls";
			case ".pdf": return "application/pdf";
			case ".wps": return "application/vnd.ms-works";
			case ".ppt": return "application/vnd.ms-powerpoint";
			case ".doc": return "application/msword"; 
			case ".docx": return "application/msword"; 
			case ".exe": return "application/x-msdownload";
			
		}
		//匹配mime类别（匹配普通扩展名）
		FileNameMap fileNameMap = URLConnection.getFileNameMap();   
		String type = fileNameMap.getContentTypeFor(fileName);   
		if(type==null) type = "";
		return type;
	} 
	
	
	

	/** 
     * 将String转换成InputStream 
     * 
     * @param in 
     * @return 
     * @throws Exception 
     */  
    public static InputStream covertString2InputStream(String inStr, String encoding) throws Exception{  
    	if(encoding==null || encoding.equals("")) encoding = "utf8";
        ByteArrayInputStream is = new ByteArrayInputStream(inStr.getBytes(encoding));
        return is;  
    }  
    
    

    /**
     *  将InputStream转换成某种字符编码的String 
     * @param in
     * @param encoding
     * @return
     * @throws Exception
     */
    public static String covertInputStream2String(InputStream in, String encoding) throws Exception{ 
    	//读取内容
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        byte[] data = new byte[4096];  
        int count = -1;  
        while((count = in.read(data,0,4096)) != -1){
        	outStream.write(data, 0, count);  
        }
        //编码返回
        if(encoding==null){
        	return new String(outStream.toByteArray());  
        }else{
        	if(encoding.equals("")) encoding = "utf8";
        	return new String(outStream.toByteArray(), encoding);  
        }
    }
    
	
    /**
     * 获取文件的扩展名
     * eg: System.out.println(IOUtil.getFileExtension("/Users/hbbc/Temp/aa.jpg"));
     * 
     * @param filename 文件名字符串，可以带路径，也可以不带
     * @return 文件的扩展名，如"jpg"，没有扩展名，或者解析错误返回空字符串“”
     */
	public static String getFileExtension(String filename) {
        if ((filename != null) && (filename.length() > 0)) {   
            int dot = filename.lastIndexOf('.');   
            if ((dot >-1) && (dot < (filename.length() - 1))) {   
                return filename.substring(dot + 1);   
            }   
        }   
        return "";   
    }
	
	
	
	/**
	 * 拷贝文件，从sourceFileFullName拷贝到targetFileFullName。拷贝后检查两个文件大小是否一致，一致才返回True。
	 * eg： 
	 * 
	 * @param sourceFileFullName  源文件
	 * @param targetFileFullName 目标文件
	 * @return 拷贝成功返回True，否则，返回False
	 */
	public static boolean copyFile(String sourceFileFullName, String targetFileFullName) {  
		try {  
			//拷贝文件
			FileInputStream in = new java.io.FileInputStream(sourceFileFullName);  
			FileOutputStream out = new FileOutputStream(targetFileFullName);  
			byte[] bt = new byte[1024];  
			int count;  
			while ((count = in.read(bt)) > 0) {  
				out.write(bt, 0, count);  
			}  
			in.close();  
			out.close();
			//完成拷贝后，比较一下两个文件的尺寸是否一致，一致的话，才返回成功
			if((new File(sourceFileFullName)).length()==(new File(targetFileFullName)).length())
				return true;
			else
				return false;  
		} catch (Exception e) {
			//LogUtil.log("文件拷贝失败，文件可能已丢失！");
			LogUtil.exception(e);
			return false;
		}  
	}  
	
	
	
	
}
