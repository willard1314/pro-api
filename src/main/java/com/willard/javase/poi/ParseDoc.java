package com.willard.javase.poi;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.willard.javase.poi.bean.ParseDocBean;



/**
 * 
 * <p>Title: ParseDoc </p>
 * <p>Description: 解析word文档</p>
 * Date: 2017年7月4日下午2:05:51
 * @author zl
 * @version 1.0 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2017年7月4日           zl        创建文件,实现基本功能
 * 
 * ==========================================================
 */
public class ParseDoc {
	

	public static void main(String[] args) throws Exception {
		long t1 = System.currentTimeMillis();
		InputStream is = new FileInputStream(new File("src/main/java/com/willard/javase/poi/r12.docx"));
		long t = System.currentTimeMillis();
		XWPFDocument doc = new XWPFDocument(is);
		System.out.println("文件装载："+(t-t1));
		//段落
		List<XWPFParagraph> p = doc.getParagraphs();
		String paragraph = null ;
		//从段落的头部取出表名称
		for(XWPFParagraph x : p){
			paragraph = x.getText();
			System.out.println("段落内容"+paragraph);
		}
		  //获取文档中所有的表格
	      List<XWPFTable> tables = doc.getTables();
	      List<XWPFTableRow> rows;
	      List<XWPFTableCell> cells;
	      List<ParseDocBean> pdbList = new ArrayList<>();
	      
	      for (XWPFTable table : tables) {
	         //表格属性
	    	//获取表格对应的行
	         rows = table.getRows();
	         for (XWPFTableRow row : rows) {
	            //获取行对应的单元格
	            cells = row.getTableCells();
	            String str = cells.get(5).getText();
	            if(str.length()==1){
	            	ParseDocBean parseDocBean = new ParseDocBean();
	        		parseDocBean.setField(cells.get(1).getText());
	            	parseDocBean.setInterceptLen(cells.get(3).getText());
	            	parseDocBean.setBeginPos(cells.get(4).getText());
	        		pdbList.add(parseDocBean);
	            	//getParseDocList(cells);
	            System.out.println(cells.get(0).getText()+"::"+cells.get(1).getText()+"截取长度:"+cells.get(3).getText()+"截取字符串的起始长度:"+cells.get(4).getText());
	            }
	            /*for (XWPFTableCell cell : cells) { //遍历每一行的单元格
	                System.out.println(cell.get);;
	            }*/
	         }
	      }
	      /**
	       * 1  创建表
	       * 2  解析txt 为每个字段赋值
	       * 3  插入到表
	       * */
	     StringBuilder sb = new StringBuilder();
	     sb.append("CREATE TABLE r1( ");
	     String str = "" ;
	     for(ParseDocBean p1 :pdbList){
	    	 str +=p1.getField()+"VARCHAR(50) NOT NULL"+",";
	     }
	     str = str.substring(0,str.length()-1);
	     sb.append(str);
	     sb.append(")");
	     System.out.println("执行创建创建表sql："+sb.toString());
	     int c = pdbList.size();
	     String[][] strArr = null;
	    /* for(int i=0;i<c;i++){
	    	 strArr[i][j] ="";
	    	 
	    	// System.out.println("");
	     }*/
	      
	      
	     System.out.println(pdbList);
	     is.close();
	     long t2 = System.currentTimeMillis();
	     System.out.println("消耗时间："+(t2-t1));
	}
	
	public static void readTxtFile(int begin ,int end){
		int len =0 ;
        try {
            String encoding="GBK";
            File file=new File("src/test/resources/销售LK数据CRSTCN.CRS090510_ATK含联票样例.txt");
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                	int i = lineTxt.substring(0, 2).indexOf("0");
                	String recordNum = lineTxt.substring(0, 2);
                	if(i == 0){//判断字符串是否以"0"开头
                		recordNum = lineTxt.substring(0, 2).substring(1);
                	}
                	if(recordNum.equals("1")){// 匹配record序号
                		String val = lineTxt.substring((begin-1), (begin + len -1));
                		
                	}

                }
                read.close();
	        }else{
	            System.out.println("找不到指定的文件");
	        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
     
    }
	
	
	
	
	
	//将doc字段装入list
//	public static void getParseDocList(List<XWPFTableCell> cells){
//		ParseDocBean parseDocBean = new ParseDocBean();
//		parseDocBean.setField(cells.get(1).getText());
//    	parseDocBean.setInterceptLen(cells.get(3).getText());
//    	parseDocBean.setBeginPos(cells.get(4).getText());
//		pdbList = new ArrayList<>();
//		pdbList.add(parseDocBean);
//	}
	
	public String interceptStr(String strTitle){
		int begin = strTitle.indexOf("Record");
		strTitle = strTitle.substring(begin);
		String[] sArr = strTitle.split(" – ");
		System.out.println(sArr[0].substring(strTitle.indexOf("d")+1).trim()); //
		System.out.println(sArr[1]);
		return null;
		//System.out.println(doc.getDocument().getDomNode().getNodeName());
	}

}
