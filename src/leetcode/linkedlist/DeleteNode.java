package leetcode.linkedlist;

/**
 * 删除链表中的节点
请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * @author zxl
 *
 */
public class DeleteNode {
	 public void deleteNode(ListNode node) {
		   node.val=node.next.val;
	       node.next=node.next.next;
	       
	        
	    }
}
