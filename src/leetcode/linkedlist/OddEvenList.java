package leetcode.linkedlist;

/**
 * 奇偶链表
给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

示例 1:

输入: 1->2->3->4->5->NULL
输出: 1->3->5->2->4->NULL
 * @author zxl
 *
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
    	if(head==null||head.next==null)return head;
    	ListNode oddNode=head;
    	ListNode evenHead=head.next;
    	ListNode evenNode=head.next;
    	while(oddNode.next!=null && oddNode.next.next!=null) {
    		oddNode.next=evenNode.next;
    		oddNode=oddNode.next;
    		evenNode.next=oddNode.next;
    		evenNode=evenNode.next;
    	}
    	oddNode.next=evenHead;
		return head;

    }
}
