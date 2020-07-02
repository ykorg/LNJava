package com.yk;

public abstract class AbstractList<E> implements List<E> {
	protected int size = 0;
	public static final int ELEMENT_NO_FOUND = -1;

	public boolean isEmpty() {
		return size == 0;
	}
	public boolean isContain(E element) {
		return this.indexOf(element) != -1 ? true : false;
	}
	protected void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("传入的 index 无效");
		}
	}


}
