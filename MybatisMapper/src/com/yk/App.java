package com.yk;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import com.yk.utils.mybatisutil;

public class App {
	
	
	
//	@Test
//	void testInsert() throws Exception{
//		System.out.println("hello update");
//		SqlSession session = null;
//		try {
//			session = mybatisutil.getSession();
//			User user = new User();
//			user.setName("天山童姥");
//			user.setSalary(4000.00);
//			session.insert("com.yk.UserMapper.insertUser",user);
//			session.commit();//提交事务
//			
//			System.out.println(user.getId());
//		} finally {
//			session.close();
//		}
//	}
	
	
//	@Test
//	void testDelete() throws Exception{
//		SqlSession session = null;
//		try {
//			session = mybatisutil.getSession();
//			session.delete("com.yk.UserMapper.deleteUser",1L);
//			session.commit();
//		} finally {
//			session.close();
//		}
//	}
//	
//	@Test
//	void testUpdate() throws Exception{
//		System.out.println("hello update");
//		SqlSession session = null;
//		try {
//			session = mybatisutil.getSession();
//			User user = new User();
//			user.setName("天山童姥");
//			user.setSalary(4000.00);
//			user.setId(1);
//			session.update("com.yk.UserMapper.updateUser",user);
//			session.commit();
//		} finally {
//			session.close();
//		}
//	}
	
	
	
	@Test
	void testSelectAll() throws Exception {
		SqlSession session = null;
		 List<User> users = null;
		try {
			 session = mybatisutil.getSession();
//			  users = session.selectList("com.yk.UserMapper.allUser");	
			  UserMapper mapper = session.getMapper(UserMapper.class);			 
			 users = mapper.allUser();

		} finally {
			session.close();
		}
		for (User user : users) {
			System.out.println(user.toString());
		}
	
	}
	
	
	
	
	
//	@Test
//	void testSelect() throws Exception {
//		SqlSession session = null;
//		User user = null;
//		try {
//			 session = mybatisutil.getSession();
//			 user = session.selectOne("com.yk.UserMapper.selectUser",2L);			
//		} finally {
//			session.close();
//		}
//		System.out.println(user.toString());
//	}
}
