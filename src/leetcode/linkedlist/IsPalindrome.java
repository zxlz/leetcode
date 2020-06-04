package leetcode.linkedlist;

import java.util.Stack;

/**
 * 回文链表
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
1 2 3 3 2 1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * @author zxl
 *
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
    	if(head!=null && head.next!=null){
            ListNode fast=head;
            ListNode slow=head;
            boolean odd=true;//奇数
            Stack<Integer> checkStack=new Stack<Integer>();
            while(fast!=null && fast.next!=null) {
                checkStack.push(slow.val);
                slow=slow.next;
                fast=fast.next.next; 
                if(fast==null) odd=false;
            }
            if(odd) {
                slow=slow.next;
            }
            while(!checkStack.empty()) {

                if(checkStack.pop()!=slow.val) {
                    return false;
                };
                slow=slow.next;
            }
        }
		return true;
        
    }
    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
        if (slow.val != prev.val) {
            return false;
        }
            slow = slow.next;
            prev = prev.next;
        }

        return true;   
    }
}
