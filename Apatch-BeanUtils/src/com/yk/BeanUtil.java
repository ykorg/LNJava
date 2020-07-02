package com.yk;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtil {
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
	
		Map<String ,Object> map = new HashMap<>();
		Person person = new Person();
		System.out.println(person.toString());
//		person.setAge(18);
//		person.setId(123L);
//		person.setName("张三");
		
		map.put("id", 123L);
		map.put("name", "张三");
		map.put("age", 18);
		
		BeanUtils.copyProperties(person, map);
		System.out.println(person.toString());
	
		
	}
	

}
