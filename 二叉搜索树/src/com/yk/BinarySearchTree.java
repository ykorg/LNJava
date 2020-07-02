package com.yk;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import com.mj.printer.BinaryTreeInfo;

public class BinarySearchTree<E> implements BinaryTreeInfo {
	
	private int size;
	private Node<E> root;
	
	private Comparator<E> comparetor;
	
	public BinarySearchTree() {
		this.comparetor = null;
	}
	
	public BinarySearchTree(Comparator<E> comparetor) {
		this.comparetor = comparetor;
	}

	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		
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
			this.root = new Node<>(element, null);
			size++;
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
		Node<E> insertNode = new Node<>(element, parent);
		// 插入到父节点那个方向
		if (compareResult > 0) {
			parent.right = insertNode;
		}else {
			parent.left = insertNode;
		}		
		size++;
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
		privoceTraval(root);

		return false;
	}
	
	//前序遍历
	public void privoceTraval() {
		privoceTraval(root);
	}
	//使用递归
	public void privoceTraval(Node<E> node) {
		if (node == null) {
			return;
		}
		System.out.println(node.element);
		privoceTraval(node.left);
		privoceTraval(node.right);
	}
	
	//中序遍历
	public void inorderTraval() {
		inorderTraval(root);
	}
	public void inorderTraval(Node<E> rnode) {
		if (rnode == null) {
			return;
		}
		inorderTraval(rnode.left);
		System.out.println(rnode.element);
		inorderTraval(rnode.right);
	}
	//层序遍历
	public void leavlOrderTraversal() {
		if (root == null) {
			return;
		}
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node<E>  node = queue.poll();
			System.out.println(node.element);
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}
	
	//层序遍历
	public void leavlOrderVisiotr(Visitor<E> visitor) {
			if (root == null || visitor == null) {
				return;
			}
			Queue<Node<E>> queue = new LinkedList<>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				Node<E>  node = queue.poll();
//				System.out.println(node.element);
				visitor.visit(node.element);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
		}
		//前驱节点
		private Node<E> predecessor(Node<E> node){
			if (node == null) {
				return null;
			}
			// 1. 前驱节点在左子树上.
			Node<E> p = node.left;
			if (p != null) {
				while (p.right != null) {
					p = p.right;
				}
				return p;
			}
			// 2. 从父节点, 祖父节点寻找前驱节点
			while (node.parent != null && node == node.parent.left) {
				node = node.parent;
			}
			return node.parent;
		}
		
		private Node<E> successor(Node<E> node){
			if (node == null) {
				return null;
			}
			// 1. 后驱节点在右子树上.
			Node<E> p = node.right;
			if (p != null) {
				while (p.left != null) {
					p = p.left;
				}
				return p;
			}
			// 2. 从父节点, 祖父节点寻找前驱节点
			while (node.parent != null && node == node.parent.right) {
				node = node.parent;
			}
			return node.parent;
		}
	
	
	
	
	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("参数不能为空");
		}
	}
	
	private static class Node<E>{
		E element;
		Node<E> left;
		Node<E> right;
		Node<E> parent;
		
		public Node(E element,Node<E> parentNode){
			this.element = element;
			this.parent = parentNode;
		}
	}
	
	public static interface Visitor<E>{
		public void visit(E element);
	}

	/********** BinaryTreeInfo **********/
	@Override
	public Object root() {
		return root;
	}

	@Override
	public Object left(Object node) {
		return ((Node)node).left;
	}

	@Override
	public Object right(Object node) {
		return ((Node)node).right;
	}

	@Override
	public Object string(Object node) {
		return ((Node)node).element;
	}
	/********** BinaryTreeInfo **********/
}
