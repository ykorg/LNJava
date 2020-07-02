package com.yk;

import java.util.Comparator;

public class BinarySearchTree<E> extends BinaryTree<E> {
	
	protected Comparator<E> comparetor;
	
	public BinarySearchTree() {
		this.comparetor = null;
	}
	
	public BinarySearchTree(Comparator<E> comparetor) {
		this.comparetor = comparetor;
	}
	// 返回值 = 0 ,代表E1 == E2
	//返回值 > 0  , E1 > E2
	// 返回值 < 0 , E1 < E2
	@SuppressWarnings("unchecked")
	private int compare(E e1,E e2) {
		if (this.comparetor != null) {
			return this.comparetor.compare(e1, e2);
		}
		return ((Comparable<E>)e1).compareTo(e2);
	}
	
	public void add(E element) {
		elementNotNullCheck(element);
		if (root == null) {
			this.root = createNode(element, null);
			size++;
			addAfter(root);
			return;
		}
		//能来到后面添加的都是非根节点
		// 添加一个节点,首先要找到父节点 (parentNode),
		// 创建新的节点
		// 让父节点的左子树或者右子树 等于新节点 即可.		
		Node<E> node = root;
		Node<E> parent = root;
		int compareResult = 0;
		while (node != null) {
			compareResult = compare(element, node.element);
			parent = node;
			if (compareResult > 0) {
				node = node.right;
			}else if (compareResult < 0) {
				node = node.left;
			}else {
				return;
			}
		}
		Node<E> insertNode = createNode(element, parent);
		// 插入到父节点那个方向
		if (compareResult > 0) {
			parent.right = insertNode;
		}else {
			parent.left = insertNode;
		}		
		size++;
		addAfter(insertNode);
		
	}
	//  node 添加后之后的操作
	protected void addAfter(Node<E> node) { }
	
	protected Node<E> createNode(E element, Node<E> parentNode) {
		return new Node<>(element, parentNode);
		
	}
	
	// 删除节点
	public void remove(E element) {
		//1. 现根据元素找到节点位置.
		//2. 删除
		remove(node(element));
	}
	
	private void remove(Node<E> node) {
		if (node == null) {
			return;
		}
		// 度为2
		if (node.left != null && node.right != null) {
			// 找到前驱节点
			Node<E> s = predecessor(node);
			// 使用前驱节点覆盖度为2的节点的值
			node.element = s.element;
			// 删除后继节点
			node = s;
		}
		// 删除node 节点 ( node 节点度必然为1 或者 0)
		Node<E> replace = node.left != null ? node.left : node.right;
		if (replace != null) {// 度为1的节点
			// 更改parent
			replace.parent = node.parent;			
			//更改 parent 的指向
			if (node.parent == null) { // 根节点
				root = replace;
			}else {
				if (node.parent.left == node) {
					node.parent.left = replace;
				} else {
					node.parent.right = replace;
				}
			}			
		}else if (node.parent == null){// node 为叶子节点, 并且是根节点
			root = null;
		}else {
			if (node == node.parent.right) {
				node.parent.right = null;
			} else {
				node.parent.left = null;
			}
		}
		node.parent = null;
		size--;
	}
	
	private Node<E> node(E element){
		Node<E> node = root;
		while (node != null) {
			int cmp = compare(element, node.element);
			if (cmp == 0) {
				return node;
			}else if (cmp < 0){
				node = node.left;
			}else {
				node = node.right;
			}
		}
		return null;
	}
	
	public boolean contains(E element) {
		return false;
	}
	
	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("参数不能为空");
		}
	}
}
