package leetcode.linkedlist;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

/**
 * 445. 两数相加 II
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * <p>
 * <p>
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 进阶:
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 示例:
 * <p>
 * <p>
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 * <p>
 * 队列：offer poll
 * 栈：push pop
 */
public class AddTwoNumbers1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayDeque<Integer> deque1 = new ArrayDeque<>();
        ArrayDeque<Integer> deque2 = new ArrayDeque<>();

        ListNode curNode = null;
        while (l1 != null) {
            deque1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            deque2.push(l2.val);
            l2 = l2.next;
        }
        int spill = 0;
        while (!deque1.isEmpty() && !deque2.isEmpty()) {
            int x = spill + deque1.pop() + deque2.pop();
            spill = x % 10;

            ListNode pre = new ListNode(x / 10);
            //倒着构建链表
            pre.next = curNode;
            curNode = pre;
        }

        while (!deque1.isEmpty()) {
            int x = spill + deque1.pop();
            spill = x % 10;
            ListNode pre = new ListNode(x / 10);
            pre.next = curNode;
            curNode = pre;
        }

        while (!deque2.isEmpty()) {
            int x = spill + deque2.pop();
            spill = x % 10;
            ListNode pre = new ListNode(x / 10);
            pre.next = curNode;
            curNode = pre;
        }
        return curNode;
    }
}
