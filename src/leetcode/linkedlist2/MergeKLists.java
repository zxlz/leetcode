package leetcode.linkedlist2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import leetcode.linkedlist.ListNode;

/**
 * 合并K个元素的有序链表
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
 * @author zxl
 *
 */
public class MergeKLists {
	//最小堆逐个加入，从小到大，只会比较前面几个
    public ListNode mergeKLists(ListNode[] lists) {
    	ListNode head=null;
    	PriorityQueue<ListNode> minHeap=new PriorityQueue<ListNode>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val-o2.val;
			}
		});
    	
    	 for (ListNode e : lists) {
    		 if(e!=null) minHeap.add(e);
    	 }
    	 
    	 head=minHeap.poll();
    	 ListNode node=head;
    	 while(!minHeap.isEmpty()) {
    		 if(node.next!=null) {
    			 minHeap.offer(node.next);
    		 }//原node的next发放入minheap比较
    		 node.next=minHeap.poll();//修改node的next为比较后的最小节点
    		 node=node.next;
    	 }
    	 return head;
    }
    //二分法分治。 
    public ListNode mergeKLists1(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if(start > end) {
            return null;
        }

        if(end - start == 1) {
            return mergeKLists(lists[start], lists[end]);
        }

        if(start == end) {
            return lists[start];
        }

        int mid = ((end + start) >> 1) + 1;
        ListNode node1 = mergeKLists(lists, start, mid - 1);
        ListNode node2 = mergeKLists(lists, mid, end);

        return mergeKLists(node1, node2);
    }

    private ListNode mergeKLists(ListNode node1, ListNode node2) {
        if(node1 == null || node2 == null) {
            return node1 == null ? node2 : node1;
        }

        ListNode head = new ListNode(-1);
        ListNode cur= head, cur1 = node1, cur2 = node2;
        while(cur1 != null) {
            while(cur2 != null && cur2.val <= cur1.val) {
                cur.next = cur2;
                cur2 = cur2.next;
                cur = cur.next;
            }

            cur.next = cur1;
            cur1 = cur1.next;
            cur = cur.next;
        }

        cur.next = cur2 != null ? cur2 : cur1;

        return head.next;
    }
}
