package leetcode.linkedlist;

/**
 *  反转链表
    反转一个单链表。
 * @author zxl
 *
 */
public class ReverseList {
    /**
     *  1  →2 →3 →4 →5→null
     *  p1 p2 p3
     *     p1 p2 p3
     * @param head
     * @return
     */
	public ListNode reverseList(ListNode head) {
    	ListNode p1=head;
    	ListNode p2=head.next;
    	ListNode p3=p2.next;
    	while(p3!=null) {
    		p3=p2.next;
    		p2.next=p1;
    		
    		p1=p2;
    		p2=p3;
    		
    		
    	}
    	head.next=null;
    	
		return p2;
        
    }
	/**
	 * 递归
	 * @param head
	 * @return
	 */
	 public ListNode reverseList1(ListNode head) {
	     if(head==null||head.next==null){
	         return head;
	     }else {
	          ListNode first=reverseList(head.next);
	          head.next.next=head;
	          head.next=null;
	          return first;
	     }
	    }
}
