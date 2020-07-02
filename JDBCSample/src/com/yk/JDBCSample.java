package com.yk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCSample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("hello jdbc");
		// 贾琏欲执事
		// 1. 加载并注册jdbc
//		Class.forName("com.mysql.jdbc.Driver");
//		// 2. 连接
//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?characterEncoding=utf8&useSSL=false", "root", "Yinyakun123");
//		//3. 语句
//		Statement statement = connection.createStatement();
//		//4. 执行语句
//		// 4.1 sql 语句
//		String sql = "Select * from t_student;";
//		ResultSet resultSet = statement.executeQuery(sql);
//		while (resultSet.next()) {
//			
//			System.out.println(resultSet.getString("gender"));
//		}
//		resultSet.close();
//		statement.close();
//		connection.close();
		
		insertSql();

	}
	
	static void updateSql() throws Exception{
		//贾琏欲执事
		//1.  加载
		Class.forName("com.mysql.jdbc.Driver");
		//2. 连接对象
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useSSL=false","root","Yinyakun123");
		//3. 语句
		Statement st = con.createStatement();
		//4. 执行
		int rows = st.executeUpdate("update t_student set name = 'zzzzz' where id = 2; ");
		//4. 关闭
		st.close();
		con.close();
		System.out.println("更新了行数: " + rows);		
		
	}
	
	static void insertSql() throws Exception{
		//贾琏欲执事
		//1.加载 mysql driver
		Class.forName("com.mysql.jdbc.Driver");
		//2. 获取连接多想
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useSSL=false", "root", "Yinyakun123");
		//3. 创建执行语句
		Statement st = cn.createStatement();
		//4. 执行
		int rows = st.executeUpdate("insert into t_student (name,gender) values ('yinyakun','nan');");
		//5. 释放
		st.close();
		cn.close();
		System.out.println("插入了 " + rows);
		
		//3.
		//4.
		
	}

}
