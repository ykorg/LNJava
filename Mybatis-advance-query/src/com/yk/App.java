package com.yk;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import com.yk.mapper.EmployeeMapper;
import com.yk.queue.EmployeeQueryObject;
import com.yk.utils.mybatisutil;

public class App {
	
	@Test
	void testQueryForList() throws Exception {
		
		EmployeeQueryObject queryObject = new EmployeeQueryObject();
//		queryObject.setKeyword("");
		queryObject.setMinSalary(new BigDecimal("200"));
		queryObject.setMaxSalary(new BigDecimal("3500"));
		queryObject.setDeptId(1L);
		SqlSession session = mybatisutil.getSession();
		EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
		List<Employee> list = mapper.queryForList(queryObject);
		session.close();
		for (Employee employee : list) {
			System.out.println(employee.toString());
		}
	}
}
