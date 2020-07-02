package com.yk;
import java.util.PriorityQueue;

public class KthLargest {
	 PriorityQueue<Integer> queue;
	int targetK ;
	
	public static void main(String[] args) {
		KthLargest kthLargest = new KthLargest(3, new int[] {4,5,8,2});
		System.out.println("第三大的元素是: " + kthLargest.add(3));// returns 4
		System.out.println("第三大的元素是: " +kthLargest.add(5));//   // returns 5
		System.out.println("第三大的元素是: " +kthLargest.add(10));//  // returns 5
		System.out.println("第三大的元素是: " +kthLargest.add(9));//   // returns 8
		System.out.println("第三大的元素是: " +kthLargest.add(4));//   // returns 8

	}
	
	 public KthLargest(int k, int[] nums) {
		 targetK = k; // 3 大的
		 queue = new PriorityQueue<Integer>();
		 for (int i = 0; i < nums.length; i++) {
			 queue.add(nums[i]);
			 if (queue.size() > targetK) {
				queue.poll();
			}
		}
		 
	 }
	    
	 public int add(int val) {
		 queue.add(val);
		 if (queue.size() > targetK) {
			queue.poll();
		}
		 return queue.peek();
	 }

}
