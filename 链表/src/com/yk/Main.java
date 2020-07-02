package com.yk;

public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		
		linkedList.add(0, 100);
		
		System.out.println(linkedList);

	}
}
