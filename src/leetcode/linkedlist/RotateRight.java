package leetcode.linkedlist;

import org.junit.Test;

/**
 * 旋转链表
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
示例 2:

输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL
解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步: 0->1->2->NULL
向右旋转 4 步: 2->0->1->NULL
 * @author zxl
 *
 */
public class RotateRight {
	@Test
	public void main() {
//		int i=100;
//		int b=100;
//		int count=100000000;
//		long t=System.currentTimeMillis();
//		while(count!=0) {
//			if(i==b) {
//				count--;
//			}
//		}
////		while(count!=0) {
////			if(i%b==0) {
////				count--;
////			}
////		}
//		System.out.println(System.currentTimeMillis()-t);
		
	}
	/**
	 * 倒数第 k%length位置的节点开始为新head，原head接到原tail
	 * @param head
	 * @param k
	 * @return
	 * k 0 - intmax;
	 */
    public ListNode rotateRight(ListNode head, int k) {
    	ListNode node=head;
    	ListNode fast=head;
    	ListNode slow=head;
    	int i=k;
    	// 1 2 3 4 5
    	// 
    	while(i!=0) {
    		//next是null，则到底，
    		fast=fast.next;
    		i--;
    		if(fast==null) {//如果fast遍历结束全长
    			int len=k-i;
    			if(i>=len) {//剩余比len长就取余再给i，减少循环
    				i=i%len;
    			}
    			if(i==0) {
    				return head;
    			}else {
    				fast=head;
    			}
    		}
    	}
    	
    	while(fast!=null) {
    		fast=fast.next;
    		slow=slow.next;
    	}
    	
    	
		return head;

    }
}
