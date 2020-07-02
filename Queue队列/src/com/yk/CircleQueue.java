package com.yk;
/**
 * 循环队列,一般使用数组来实现
 * @author yinyakun
 *
 * @param <E>
 */
public class CircleQueue<E> {
	public int size;
	int frout;
	private static final int DEFAULT_CAPACITY = 10;
	E[] elements;
	
	@SuppressWarnings("unchecked")
	public CircleQueue() {
		elements = (E[]) new Object[DEFAULT_CAPACITY];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	/**
	 * 队列,先进先出
	 * 尾    头
	 */
	public void enQueue(E element) {
		checkCapackty(size + 1);
		elements[index(size)] = element;
		size++;
	}
	public E outQueue() {
		E element = elements[frout];
		elements[frout] = null;
		size--;
		frout = index(1);
		return element;
	}

	public E frount() {
		return elements[0];
	}
	
	private void checkCapackty(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) {
			return;
		}
		int newCapacity = oldCapacity + (oldCapacity>>1);
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < elements.length; i++) {
			newElements[i] = elements[index(i)];
		}
		elements = newElements;
		frout = 0;
	}
	
	private int  index(int oldIndex) {
		return (frout + oldIndex)%elements.length;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("capacity = ").append(elements.length).append(" size = ").append(size).
		append(", [");
		for (int i = 0; i < elements.length; i++) {
			builder.append(" ").append(elements[i]);
		}
		builder.append("]");
		return builder.toString();
	}
}
