package com.yk.easymvc.bean;

import java.util.HashMap;
import java.util.Map;

//表示模型对象(共享的数据)和视图对象(跳转的页面)的合体.
public class ModelAndView {
	private  String viewName;
	private Map<String, Object> model = new HashMap<>();

	public void addAttribute(String key,Object value) {
		model.put(key, value);
	}
	
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	public Map<String, Object> getModel() {
		return model;
	}
	public void setModel(Map<String, Object> model) {
		this.model = model;
	}
	
}
