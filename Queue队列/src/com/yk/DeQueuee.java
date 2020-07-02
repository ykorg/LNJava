package com.yk;

import java.util.LinkedList;

public class DeQueuee<E> {
	public int size;
	LinkedList<E> list = new LinkedList<>();
	
	public boolean isEmpty() {
		return size == 0;
	}
	/**
	 * 队列,先进先出
	 * 尾    头
	 */
	public void enQueueFromFront(E element) {
		list.add(0,element);
		size++;
	}
	public void enQueueFromTail(E element) {
		list.add(element);
		size++;
	}
	public E outQueueFromFront() {
		E element = list.remove(0);
		size--;
		return element;
	}
	public E outQueueFromTail() {
		E element = list.remove(list.size() - 1);
		size--;
		return element;
	}

	public E peekTail() {
		return list.peekLast();
	}
	public E peekFront() {
		return list.peek();
	}
}
