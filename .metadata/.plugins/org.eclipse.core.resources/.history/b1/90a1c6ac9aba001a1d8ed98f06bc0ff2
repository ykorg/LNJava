package com.yk;

public class ArrayList<E> {
	int size = 0;
	private E [] elements;
	static final int DEFAULT_CAPACITY = 10;
	
	public ArrayList(int size) {
		// 所有的类,都集成object
		elements = (E[])new Object[size];
	}
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("传入的 index 无效");
		}
		return elements[index];
	}
	
	public boolean isContain(E element) {
		return this.indexOf(element) != -1 ? true : false;
	}
	
	public int indexOf(E element) {
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] == element) {
 				return i;
 			}
		}
		return -1;
	} 
	public void clear() {
		size = 0;
	}
	public void add(E element) {
		elements[size] = element;
		size++;
	}
	public void add(int index, E element) {
		ensureCapacity(elements.length + 1);
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("传入的 index 无效");
		}
		// 挪动的: index, size
		for (int i = size - 1;i>=index;i--) {
			elements[i + 1] = elements[i];
		}
		elements[index] = element;
		size++;
	}
	public void remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("传入的 index 无效");
		}
		// index + 1 , size - 1
		for (int i = index + 1; i < size - 1; i++) {
			elements[i - 1] = elements[i];
		}
		size--;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("size= ").append(size).append(" ;").append("[");
		for (int i = 0; i < size; i++) {
			str.append(elements[i]);
			if (i != size - 1) {
				str.append(" , ");
			}
		}
		str.append("]");
		
		return str.toString();
	}
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) {
			return;
		}
		int newCapacity = oldCapacity + oldCapacity>>1;
		E[] newArr = (E[])new Object[newCapacity];
		for (int i = 0; i < oldCapacity; i++) {
			newArr[i] = elements[i];
		}
		elements = newArr;
	}
}
