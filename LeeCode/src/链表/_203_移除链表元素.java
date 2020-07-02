package 链表;
/*
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 删除链表中等于给定值 val 的所有节点。
	
	示例:
	
	输入: 1->2->6->6->3->4->5->6, val = 6
	输出: 1->2->3->4->5
 */

public class _203_移除链表元素 {
	public ListNode removeElements(ListNode head, int val) {
		ListNode newHead = head;
		while (head != null) {
			if (head.val == val) {
				if (head.next == null) {
					head = null;
				}else {
					head.val = head.next.val;
					head.next = head.next.next;
				}
				continue;
			}
			head = head.next;
		}
		return newHead;
    }
}
