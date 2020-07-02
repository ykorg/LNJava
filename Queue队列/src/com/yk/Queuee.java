package com.yk;
import java.util.LinkedList;
public class Queuee<E> {
	public int size;
	LinkedList<E> list = new LinkedList<>();
	
	public boolean isEmpty() {
		return size == 0;
	}
	/**
	 * 队列,先进先出
	 * 尾    头
	 */
	public void enQueue(E element) {
		list.add(element);
		size++;
	}
	public E outQueue() {
		E element = list.remove(0);
		size--;
		return element;
	}

	public E peek() {
		return list.peek();
	}
}
