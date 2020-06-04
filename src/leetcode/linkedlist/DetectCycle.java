package leetcode.linkedlist;

/**
 *  环形链表 II
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

说明：不允许修改给定的链表。
 * @author zxl
 *
 *1 2 3 4 5 6 7 8 9 x
 *    34
 *    
 * 笔记有证明  若在头结点和相遇结点分别设一指针，同步(单步)前进，则最后一定相遇在环入口结点p。
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
    	if(head==null||head.next==null)return null;
        ListNode slow=head;
    	ListNode fast=head;
    	while(fast!=null && fast.next!=null ) {
    		
    		slow=slow.next;
    		fast=fast.next.next;
            if(slow==fast)break;
    	}
        
        if(fast==null || fast.next==null )return null;
    	slow=head;
    	while(slow!=fast) {
    		slow=slow.next;
    		fast=fast.next;
    	}
    	
		return slow;
        
    }
}
