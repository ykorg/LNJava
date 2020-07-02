package com.yk;

import java.util.Comparator;

/**
 * @author yinyakun
 *
 * @param <E>
 */
public class AVL<E> extends BinarySearchTree<E> {

	/* 平衡因子 
	 * 某个节点左右子树的高度差
		左子树的高度 减去 右子树的高度
		下图中 1,6的平衡因子 是 0,
		4的平衡因子也是 0,
		2的平衡因子是1,
		5的平衡因子是-1
		11的平衡因子是2 , 13的平衡因子是: 3
	┌──────7──────┐
    │             │
  ┌─4─┐         ┌─13─┐
  │   │         │    │
┌─2   5─┐    ┌─11─┐  14
│       │    │    │
1       6 ┌─10    12
          │
        ┌─9
        │
        8
	 * */
	
	/* AVL树的特点 
	 	每个节点的平衡因子只可能是0,1, -1,(绝对值 <=1,如果超过1,称为'失衡')
	 	每个节点的左右子树高度差不超过1
	 	搜索,添加,删除的复杂度是O(logn)
	 * */
	
	
	public AVL() {
		this.comparetor = null;
	}
	
	public AVL(Comparator<E> comparetor) {
		super(comparetor);
	}
	
	/* 失衡 LL (右旋转) 
	  n : node,p : parent, g : grant 
	 * */
	
	@Override
	protected void addAfter(Node<E> node) {
		while ((node = node.parent) != null) {
			// 判断 node 是否平衡
			if (isBalanced(node)) {
				//更新高度
				updateHeight(node);
			}else {
				//恢复平衡
				rebalance(node);
				// 整棵树都恢复平衡了
				break;
			}
			
		}
	}
	
	private void rebalance(Node<E> grant) {
		Node<E> parent = ((AVLNode<E>)grant).tallerChild();
		Node<E> node = ((AVLNode<E>)parent).tallerChild();
		if (parent.isLeftChild()) {//L
			if (node.isLeftChild()) { //LL
				routeRight(grant);
			}else {					//LR
				routeLeft(parent);
				routeRight(grant);

			}
		}else {	//R
			if (node.isLeftChild()) { // RL
				routeRight(parent);
				routeLeft(grant);
			}else {	//RR
				routeLeft(grant);
			}
		}
	}
	
	private void routeLeft(Node<E> grant) {
		Node<E> parent = grant.right;
		Node<E> child = parent.left;
		grant.right = child;
		parent.left = grant;
		afterRoute(grant,parent,child);
		
	}
	private void routeRight(Node<E> grant) {
		Node<E> parent = grant.left;
		Node<E> child = parent.right;
		grant.left = child;
		parent.right = grant;
		afterRoute(grant,parent,child);
	}
	
	public boolean isBalanced(Node<E> node) {
		return Math.abs(((AVLNode<E>)node).balanceFactor()) <= 1;
	}
	
	private void updateHeight(Node<E> node) {
		AVLNode<E> avlNode = (AVLNode<E>)node;
		avlNode.updateHeight();
		
	}
	
	private void afterRoute(Node<E> grant,Node<E> parent,Node<E> child) {
		// 更新parent 的父节点
				parent.parent = grant.parent;
				if (grant.isLeftChild()) {
					grant.parent.left = parent;
				}else if (grant.isRightChild()){
					grant.parent.right = parent;
				}else {
					root = parent;
				}
				
				//更新child 的parent
				if (child != null) {
					child.parent = grant;
				}
				//更新grant 的parent
				grant.parent = parent;
				//更新高度
				updateHeight(grant);
				updateHeight(parent);
	}
	
	@Override
	protected Node<E> createNode(E element, Node<E> parentNode) {
		return new AVLNode<>(element, parentNode);
	}
	
	private static class AVLNode<E> extends Node<E> {
		int height = 1;
		public AVLNode(E element, Node<E> parentNode) {
			super(element, parentNode);
			
		}
		public int  balanceFactor() {
			int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
			int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
			return leftHeight - rightHeight;
		}
		
		public void updateHeight() {
			int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
			int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
			height = 1 + Math.max(leftHeight,rightHeight);
		}
		public Node<E> tallerChild() {
			int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
			int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
			if (leftHeight - rightHeight > 0) {
				return ((AVLNode<E>)left);
			}else if (leftHeight - rightHeight < 0) {
				return ((AVLNode<E>)right);
			}else {
				return isLeftChild() ? left : right;
			}
		}
	} 
	
	
	

}
