package com.yk.easymvc.bean;
//封装每一个处理请求的方法的信息

import java.lang.reflect.Method;

public class ControllerBean {
	private Class<?> controllerClass;//当前方法所属的字节码
	private Method controllerMethod;//当前方法对象
	public ControllerBean(Class<?> controllerClass, Method controllerMethod) {
		this.controllerClass = controllerClass;
		this.controllerMethod = controllerMethod;
	}
	
	public Class<?> getControllerClass() {
		return controllerClass;
	}
	
	public Method getControllerMethod() {
		return controllerMethod;
	}
	
	
}
