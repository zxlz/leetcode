package leetcode.linkedlist;

/**
 * 两数相加
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 * @author zxl
 *
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int next = 0;
    	ListNode res=l2;
    	while(l2!=null) {
    		int i=(l1==null?0:l1.val)+l2.val+next;
        	l2.val=i%10;
        	next =i/10;
        	if(next!=0) {//下轮继:
        		l1=l1==null?null:l1.next;
        		if(l2.next==null)l2.next=new ListNode(0);
            	l2=l2.next;
        	}else {
        		l1=l1==null?null:l1.next;
        		if(l1==null)break;//没有进位，下一个l1为空
        		if(l2.next==null)l2.next=new ListNode(0);
        		l2=l2.next;
            	
        	}	
    	}
		return res;
    }
}
