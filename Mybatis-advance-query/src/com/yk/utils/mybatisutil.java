package com.yk.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class mybatisutil<T> {

	private static SqlSessionFactory factory = null;
	
	static {
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			//2. 创建一个sqlSessionFactory对象,类似DataSource
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSession() {
		SqlSession session = factory.openSession();
		return session;
	}
	
//	public static T getMapper(Class<T> type) {
//		SqlSession session = getSession();
//		T mapper =  session.getMapper(type);
//		return mapper;
//	}
	
	
}
