package com.yk;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.lang.model.element.VariableElement;

public class Tools {
	public static void main(String[] args) {
		
		Thread thread = new Thread(() ->  {
			System.out.println("当前线程为: " + Thread.currentThread());
	
		});
		thread.start();
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		})
		
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("rose");
		arrayList.add("jeck");
		arrayList.add("tom");
		arrayList.add("sendy");
		//1
//		for (String name : arrayList) {
//			System.out.println(name);
//		}
		//2
//		Iterator<String> iterator = arrayList.iterator();
//		while (iterator.hasNext()) {
//			System.out.println(iterator.next());			
//		}
		//3
//		for (int i = 0; i < arrayList.size(); i++) {
//			String name = arrayList.get(i);
//			System.out.println(name);
//			
//		}
		//4
//		arrayList.forEach((String item )->{
//			System.out.println(item);
//		});
		//5
//		Iterator<String> iterator = arrayList.iterator();
//		while (iterator.hasNext()) {
//			iterator.next();
//			iterator.remove();
//		}
//		
//		System.out.println(arrayList);
		
		
		Person[] persons = {
				 new Person(11),
				 new Person(77),
				 new Person(44)
				
		};
	 Person p = getMax(persons);
	 System.out.println(p.toString());
		
	 
	}
	
	
	static <T extends Comparable<T>> T getMax(T[] objs) {
		if (objs == null || objs.length == 0)return null;
		T max = objs[0];
		for (int i = 1; i < objs.length; i++) {
			if (max.compareTo(objs[i]) > 0) continue;
			max = objs[i];
		}
		return max;
	}
	

	public static void test1() {
		Integer num1 = 88;
		Integer num2 = 88;
		Integer num3 = 888;
		Integer num4 = 888;
		
		System.out.println(num1 == num2);
		
		System.out.println(num3 == num4);
	}
	
}
/*
 *	main函数 
 * 
 */