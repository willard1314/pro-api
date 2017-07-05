package com.willard.javaweb.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/** 
* @ClassName: DBConnectionDemo 
* @Description: JDBC连接数据库Demo
* @author willard
* @date 2017年6月1日 下午10:28:52 
*  
*/
public class JDBCConnectionDBDemo {

	public static void main(String[] args) throws ClassNotFoundException  {
	try {
		//1.0注册数据库驱动
		Class.forName("com.mysql.jdbc.Driver");//这种不会对具体的驱动类产生依赖（推荐）
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//2.0获取数据库连接
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1");
		//3.0创建Statement
		String param = "''or 1 or''";
		String sql = "select * from student  where id = ?";
//		Statement st = con.createStatement();
//		st.executeQuery(sql);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, param);
		st.addBatch();
		st.executeBatch();
		//4.0获取结果集并处理
		ResultSet res = st.getResultSet();
		
		while(res.next()){
			System.out.println("id"+res.getInt(1)+"--name:"+res.getString(2));//下标从1开始
		}
	
		//5.0关闭资源
		st.close();
		con.close();
		res.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
