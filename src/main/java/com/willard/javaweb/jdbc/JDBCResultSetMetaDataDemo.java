package com.willard.javaweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

/** 
* @ClassName: JDBCResultSetMetaDataDemo 
* @Description: ResultSetMetaData的使用
* @author willard
* @date 2017年6月2日 上午10:15:41 
*  
*/
public class JDBCResultSetMetaDataDemo {
	
	public static void main(String[] args) throws Exception {
		//注册数据库驱动
		Class.forName("com.mysql.jdbc.Driver");
		//建立连接
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","1");
		//创建statement
		String sql = "select * from student";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.executeQuery();
		//获取ResultSet中列的类型和属性信息
		ResultSetMetaData res = pst.getMetaData();
		System.out.println("列数："+res.getColumnCount());
		System.out.println("第二列的类型："+res.getColumnTypeName(2));
			
	}

}
