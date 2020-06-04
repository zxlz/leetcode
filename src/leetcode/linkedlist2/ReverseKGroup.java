package leetcode.linkedlist2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import leetcode.linkedlist.ListNode;

/**
 * 25. K 个一组翻转链表
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

 

示例：

给你这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5

 

说明：

你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * @author zxl
 *
 */
public class ReverseKGroup {
	@Test
	public void main() {
		ListNode node=  new ListNode(1);
		node.next=new ListNode(2);
		node.next.next=new ListNode(3);
		node.next.next.next=new ListNode(4);
		node.next.next.next.next=new ListNode(5);
		reverseKGroup(node, 2);
		System.out.println();
	}
    public ListNode reverseKGroup(ListNode head, int k) {
    	int i =0;
    	ListNode tail=head;
    	while(i<k ) {
    		if(tail==null) {
    			return head;
    		}
    		tail=tail.next;
    		i++;
    	}
    	ListNode curHead = reserveK(head,tail);//返回反转后的head(也就是这里tail的前一个,head)
    	//tail前有k个元素
    	System.out.println(curHead.val);
    	head.next=reverseKGroup(tail,k);
    	
    	return curHead;
    }
    /*    1  →2 →3 →4 →5→null
    *  p1 p2 p3
    *     p1 p2 p3
    */
	private ListNode reserveK(ListNode head, ListNode tail) {
		ListNode p3;
		ListNode p2 = head;
		ListNode p1 = null;
		while(p2!=tail) {
			p3=p2.next;
			
			p2.next=p1;
			p1=p2;
			p2=p3;	
		}
		return p1;
	}
}
