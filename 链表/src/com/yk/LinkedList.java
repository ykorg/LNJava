package com.yk;

public class LinkedList<E> extends AbstractList<E>{
	private Node<E> first;
  private static class Node<E>{
	 E element;
	 Node<E> next;
	 public Node(E element,Node<E> next) {
		 this.element = element;
		 this.next = next;
	}
  }

  	public void clear() {
		size = 0;
		first = null;
  	}
	@Override
	public E get(int index) {
		return node(index).element;
	}
	
	public E set(int index,E element) {
		Node<E> node = node(index);
		E oldElement = node.element;
		node.element = element;
		return oldElement;
	}
	
	
	@Override
	public int indexOf(E element) {
		if (element == null) {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (node.element == null) {
					return i;
				}
				node = node.next;
			}
		}else {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (node.element.equals(element)) {
					return i;
				}
				node = node.next;
			}
		}
		return ELEMENT_NO_FOUND;
	}
	
	@Override
	public void add(E element) {
		add(size,element);
	}
	
	@Override
	public void add(int index, E element) {
		if (index == 0) {	// 添加到头部
			Node<E> node = new Node(element, first);
			first = node;
		}else {	// 添加到非头部
			Node<E> prev = node(index - 1);
			Node<E> node = new Node(element, prev.next);
			prev.next = node;
		}
		size++;
	}
	
	@Override
	public void remove(int index) {
		if (index == 0) {	// 删除在头部
			first = first.next;
		}else {	// 删除非头部
			Node<E> prev = node(index - 1);
			prev.next = prev.next.next;
		}
		size--;
	}
	/*
	 * 获取 index 位置的元素
	 */
	private Node<E> node(int index) {
		rangeCheck(index);
		Node<E> tempNode = first;
		for (int i = 0; i < index; i++) {
			tempNode = tempNode.next;
		}
		return tempNode;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("size= ").append(size).append(" ;").append("[");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			str.append(node.element);
			if (i != size - 1) {
				str.append(" , ");
			}
			node = node.next;
		}
		str.append("]");
		
		return str.toString();
	}

	
}
