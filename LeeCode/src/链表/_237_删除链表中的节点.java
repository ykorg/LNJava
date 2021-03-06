package 链表;
/*
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class _237_删除链表中的节点 {
	/*
	 * 4 ---->  5 ----> 1 -----> 9
	 * 如果穿过来的节点是 1, 那么要删除1节点,其实就是要把 1后面的节点 (9) 放到1的位置
	 * 就是把 node.val = node.next.val;
	 * 然后,指针指向就指向原来node.next 的next
	 * node.next = node.next.next;
	 */
	
	 public void deleteNode(ListNode node) {
		    node.val = node.next.val;
		    node.next = node.next.next;
	 }
}
