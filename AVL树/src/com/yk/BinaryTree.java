package com.yk;

import java.util.LinkedList;
import java.util.Queue;

import com.mj.printer.BinaryTreeInfo;

public class BinaryTree<E> implements BinaryTreeInfo {

	protected int size;
	protected Node<E> root;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {

	}

	// 前序遍历
	public void privoceTraval() {
		privoceTraval(root);
	}

	// 使用递归
	public void privoceTraval(Node<E> node) {
		if (node == null) {
			return;
		}
		System.out.println(node.element);
		privoceTraval(node.left);
		privoceTraval(node.right);
	}

	// 中序遍历
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

	// 层序遍历
	public void leavlOrderTraversal() {
		if (root == null) {
			return;
		}
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			System.out.println(node.element);
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}

	// 层序遍历
	public void leavlOrderVisiotr(Visitor<E> visitor) {
		if (root == null || visitor == null) {
			return;
		}
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
//					System.out.println(node.element);
			visitor.visit(node.element);
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}

	public boolean contains(E element) {

		return false;
	}

	// 前驱节点
	protected Node<E> predecessor(Node<E> node) {
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

	protected Node<E> successor(Node<E> node) {
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

	protected static class Node<E> {
		E element;
		protected Node<E> left;
		protected Node<E> right;
		protected Node<E> parent;

		public Node(E element, Node<E> parentNode) {
			this.element = element;
			this.parent = parentNode;
		}
		public boolean isLeftChild() {
			return parent != null && parent.left == this;
		}
		public boolean isRightChild() {
			return parent != null && parent.right == this;
		}
	}

	public static interface Visitor<E> {
		public void visit(E element);
	}

	/********** BinaryTreeInfo **********/
	@Override
	public Object root() {
		return root;
	}

	@Override
	public Object left(Object node) {
		return ((Node<?>) node).left;
	}

	@Override
	public Object right(Object node) {
		return ((Node<?>) node).right;
	}

	@Override
	public Object string(Object node) {
		return ((Node<?>) node).element;
	}
	/********** BinaryTreeInfo **********/
}
