package com.willard.javaweb.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

/**
 * @ClassName: JDBCDatabaseMetaDataDemo
 * @Description: 关于DatabaseMetaData的使用
 * @author willard
 * @date 2017年6月2日 上午9:54:20
 * 
 */
public class JDBCDatabaseMetaDataDemo {

	public static void main(String[] args) throws Exception {
		// 注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 建立连接
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "1");
		DatabaseMetaData dbmd = con.getMetaData();
		System.out.println("数据库产品名：" + dbmd.getDatabaseProductName());
		System.out.println("数据库版本信息：" + dbmd.getDatabaseProductVersion());
		System.out.println("数据库类型信息：" + dbmd.getTypeInfo());

	}
}
