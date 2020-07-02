package com.yk;

import java.util.HashMap;
import java.util.Map;


public class Main {
	public static void main(String[] args) {
		int [] arr = {3,2,4};
		int target = 6;
	}
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	}
	

	
	
	/*
	 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

		如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

		您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

		示例：

		输入：(2 -> 4 -> 3 -> 2) + (5 -> 6 -> 4)
		输出：7 -> 0 -> 8
		原因：342 + 465 = 807
	 * */
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {        
	        //哨兵节点
	        ListNode dummyHead=new ListNode(0);        
	        ListNode curr=dummyHead;
	        //进位符号
	        int carryFlag=0;
	        //1
	        while(l1!=null || l2!=null){
	            int x= (l1==null) ? 0 : l1.val;
	            int y= (l2==null) ? 0 : l2.val;
	            int temp=x+y+carryFlag;
	            carryFlag=temp/10;
	            curr.next=new ListNode(temp%10);
	            curr=curr.next;
	            //2
	            if(l1!=null) l1=l1.next;
	            if(l2!=null) l2=l2.next;
	        }
	        //3
	        if(carryFlag!=0){
	            curr.next=new ListNode(carryFlag);            
	        }
	        return dummyHead.next;
	    }
	
}


/*
 static public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<> ();
        
        for (int i = 0; i < nums.length; i++) {
        	map.put(nums[i],i);
		}
        for (int  i = 0;  i < nums.length;  i++) {
			int component = target - nums[i];
			if (map.containsKey(component) && map.get(component) != i) {
				return new int[] {i,map.get(component)};
			}
		}
        
       return new int[] {0,0};        
    }
 * */
