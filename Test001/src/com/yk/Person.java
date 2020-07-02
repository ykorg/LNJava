package com.yk;

public class Person<T> implements Comparable<Person<T>> {
	private Integer age;
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public Person(Integer age) {
		this.age = age;
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int compareTo(Person<T> o) {
		// TODO Auto-generated method stub
		return age - o.age;
	}
	
	@Override
	public String toString() {
		return "Person + age +" + age;
	}
	
	
	
	
	
}
