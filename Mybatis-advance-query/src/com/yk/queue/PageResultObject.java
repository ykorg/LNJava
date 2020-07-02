package com.yk.queue;

import java.util.List;

public class PageResultObject {
	private List<?> result;
	private int totalCount;
	
	private int currentPage = 1;//当前页面数
	private int pageSize = 10;	//每页最多多少条数据
}
