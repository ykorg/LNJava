package com.yk;

public class CircleDeque<E> {
	public int size;
	int frout;
	private static final int DEFAULT_CAPACITY = 10;
	E[] elements;
	
	@SuppressWarnings("unchecked")
	public CircleDeque() {
		elements = (E[]) new Object[DEFAULT_CAPACITY];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	/**
	 * 头部入队
	 * 尾    头
	 */
	public void enQueueFromFront(E element) {
		checkCapackty(size + 1);
		frout = index(-1);
		elements[frout] = element;
		size++;
		
	}
	/**
	 * 尾部入队
	 * @param element
	 */
	public void enQueueFromTail(E element) {
		checkCapackty(size + 1);
		elements[index(size)] = element;
		size++;
	}
	/**
	 * 头部出队
	 * @return
	 */
	public E outQueueFromFront() {
		E element = elements[frout];
		elements[frout] = null;
		size--;
		frout = index(1);
		return element;
	}
	/**
	 * 尾部出队
	 * @return
	 */
	public E outQueueFromTail() {
		int realIndex = index(size - 1);
		E element = elements[realIndex];
		elements[realIndex] = null;
		size--;
		return element;
		
	}

	public E peekTail() {
		return elements[index(size - 1)];
	}
	public E peekFront() {
		return elements[frout];
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
		oldIndex += frout; 
		if (oldIndex < 0) {
			oldIndex += elements.length;
		}
		return oldIndex%elements.length;
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
