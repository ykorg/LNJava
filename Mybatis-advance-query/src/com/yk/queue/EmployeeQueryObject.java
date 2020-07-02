package com.yk.queue;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

//封装员工的高级查询
@Getter@Setter
public class EmployeeQueryObject {
	// 员工的name, 或者编号
	private String keyword;
	//最少工资
	private BigDecimal minSalary;
	//最高工资
	private BigDecimal maxSalary;
	
	private Long deptId = -1L;//部门ID,缺省为-1,表示所有部门
} 
