package com.yk.mapper;

import java.util.List;
import com.yk.Employee;

import com.yk.queue.EmployeeQueryObject;

public interface EmployeeMapper {
	
	List<Employee> queryForList (EmployeeQueryObject queryObject);
	
	List<Employee> queryForSalary (EmployeeQueryObject queryObject);

}
