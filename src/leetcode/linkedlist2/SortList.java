package leetcode.linkedlist2;

import org.junit.Test;

import leetcode.linkedlist.ListNode;

/**
 * 链表排序
在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

示例 1:

输入: 4->2->1->3
输出: 1->2->3->4
 * @author zxl
 *
 */
public class SortList {
	@Test
	public void main() {
		ListNode node = new ListNode(4);
		node.next=new ListNode(2);
		node.next.next=new ListNode(1);
		node.next.next.next=new ListNode(3);
		sortList(node);
	}
	public ListNode sortList(ListNode head) {
    	ListNode dummyHead = new ListNode(0);
    	dummyHead.next=head;
   
    	ListNode cur=head;
    	int len=0;
    	while(cur!=null) {
    		cur=cur.next;
    		len++;
    	}
    	
    	
    	for (int i = 1; i < len; i<<=1) {
			cur=dummyHead.next;
			ListNode linkTool=dummyHead;
			ListNode tempTail=new ListNode(0);
			/**
			 *  4 2 1 3
			 *  
			 */
			while(cur!=null) {
				ListNode left=cur;
				ListNode right=cut(left,i);
				cur  =cut(right,i);
				if(tempTail.next==null) {
					linkTool.next=merge(left,right,tempTail);
//                    while(linkTool.next!=null)linkTool=linkTool.next;
				}else {
//					while(linkTool.next!=null)linkTool=linkTool.next;
					linkTool=tempTail.next;
					linkTool.next=merge(left,right,tempTail);
				}
				
			}	
		}
		return dummyHead.next;
    }
    
    /**
     * 
     * @param left
     * @param right
     * @param tempTail //记录尾部用于后续连接，避免重新找尾。
     * @return 
     */
	private ListNode merge(ListNode left, ListNode right, ListNode tempTail) {
		// TODO Auto-generated method stub
		ListNode pre=new ListNode(0);
		ListNode cur=pre;
		while(left!=null && right!=null) {
			if(left.val>right.val) {
				cur.next=right;
				right=right.next;
				cur=cur.next;
			}else {
				cur.next=left;
				left=left.next;
				cur=cur.next;
			}
		}//cur不为null
		
		//
		if(left==null) {
			cur.next=right;
		}
		if(right==null) {
			cur.next=left;
		}
		//调到最后一个节点
		while(cur.next!=null) {
			cur=cur.next;
		}
		tempTail.next=cur;
		return pre.next;
	}
	//i i>1;
	private ListNode cut(ListNode left, int i) {
		// TODO Auto-generated method stub
		//减到最后一个的前一个
		while(--i>0 && left!=null) {
			left=left.next;
		}
		//最后一个unlink，返回新node
		if(i==0 && left!=null) {
			ListNode newHead=left.next;
			left.next=null;
			return newHead;
		}
		return left;
	}
}
