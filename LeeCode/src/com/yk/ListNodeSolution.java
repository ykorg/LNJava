package com.yk;

import java.util.Stack;

import javax.xml.transform.Templates;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//class Solution {
//    public void deleteNode(ListNode node) {
//        
//    }
//}


public class ListNodeSolution {

	public static class ListNode {
		int val;
		ListNode next;
	    ListNode(int x) { val = x; }
	}
	
	 public void deleteNode(ListNode node) {
	     node.val = node.next.val;
	     node.next = node.next.next;
	 }
	 // 翻转列表
	 /**
	  	反转一个单链表。
		示例:
		输入: 1->2->3->4->5->NULL
		输出: 5->4->3->2->1->NULL
		进阶:
		你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
	  * */
	 public static ListNode reverseList(ListNode head) {
		 Stack<ListNode> result = new Stack<>();
		 while (head != null) {
			result.push(head);
			 head = head.next;
		 }
		 while (result.size() > 0) {
			head = result.pop();
			head = head.next;
		}
		 return head;
	 }
	 
	 
	 
	 /**
	  给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

		示例 1:
		
		输入: [1,2,3,4,5,6,7] 和 k = 3
		输出: [5,6,7,1,2,3,4]
		解释:
		向右旋转 1 步: [7,1,2,3,4,5,6]
		向右旋转 2 步: [6,7,1,2,3,4,5]
		向右旋转 3 步: [5,6,7,1,2,3,4]
		示例 2:
		
		输入: [-1,-100,3,99] 和 k = 2
		输出: [3,99,-1,-100]
		解释: 
		向右旋转 1 步: [99,-1,-100,3]
		向右旋转 2 步: [3,99,-1,-100]
	  
	  * */
	static public void rotate(int[] nums,int k) {
//		 int temp,prev;
//		 for (int i = 0; i < k; i++) {
//			 prev = arr[arr.length - 1];
//			 for (int j = 0; j < arr.length; j++) {
//				temp = arr[j];
//				arr[j] = prev;
//				prev = temp;
//			}
//		}
//		int[] a = new int[nums.length];//1,2,3,4,5,6,7 k = 3
//        for (int i = 0; i < a.length; i++) {
//			a[(k + i) % nums.length] = nums[i];
//		}
//        for (int i = 0; i < a.length; i++) {
//        	nums[i] = a[i];
//		}
		// 原地翻转
		
		k = k % nums.length;
		reverse(nums);
		int [] arr1 = new int [k];
		int [] arr2 = new int [Math.abs( nums.length - k)];
		for (int i = 0; i < nums.length; i++) {
			if (i >= k) {
				arr2[i - k] = nums[i];
			}else {
				arr1[i] = nums[i];
			}
		}
		reverse(arr1);
		reverse(arr2);
		for (int i = 0; i < nums.length; i++) {
			if (i >= k) {
				nums[i] = arr2[i - k]; 
			}else {
				nums[i] = arr1[i]; 
			}
		}
	 }
	
	static public void reverse(int [] arr) {
		int times = arr.length / 2;
		for (int i = 0; i < times; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
		
	}


	public static void main(String[] args) {		
		System.out.println("list node solution");
//		int [] arr = {1,3,4};
//		int k = 10;
//		rotate(arr, k);
//		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		ListNode node = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		
		node.next = node1;
		node1.next = node2;
		node2.next = node3;

		node = reverseList(node);
		
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
		
//		System.out.println(node);
	}

}
