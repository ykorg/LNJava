package com.yk;

public interface List <E>{
	/*
	 * 判断是否为空
	 */
	public boolean isEmpty();
	/*
	 * 获取 index 位置的元素
	 */
	public E get(int index);
	/*
	 * 是否包含元素element
	 */
	public boolean isContain(E element);
	/*
	 * element元素的index
	 */
	public int indexOf(E element);
	/*
	 * 清空
	 */
	public void clear() ;
	/*
	 * 添加元素
	 */
	public void add(E element);
	/*
	 * 在某个位置添加元素element
	 */
	public void add(int index, E element) ;
	/*
	 * 删除index 位置的元素
	 */
	public void remove(int index);
}
