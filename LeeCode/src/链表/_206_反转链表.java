package 链表;
/*
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 反转一个单链表。
		示例:
		输入: 1->2->3->4->5->NULL
		输出: 5->4->3->2->1->NULL
 */
public class _206_反转链表 {
	
	 public ListNode reverseList(ListNode head) {
		 if (head == null || head.next == null) {
			return head;
		}
		 
		 ListNode newNode = reverseList(head.next);
		 head.next.next = head;
		 head.next = null;
		 return newNode;
	 }
	 //非递归,迭代
	 public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		 ListNode newHead = null;
		 ListNode node = head;
		while (node != null) {
			ListNode temp = node.next;
			node.next = newHead;
			newHead = node;
			node = temp;
		}
		return newHead;
	 }
	
}
