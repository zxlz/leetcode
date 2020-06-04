package leetcode.linkedlist;
/**
 * 删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？
 * @author zxl
 *
 */
public class RemoveNthFromEnd {
	/**
	 * 快慢指针就是定义两根指针，移动的速度一快一慢，以此来制造出自己想要的差值。这个差值可以让我们找到链表上相应的节点。
	 * 1 找中间值
		一般的思路是：先遍历一次链表，记录住一共有多少个节点，然后，再次遍历找寻中点。
		利用快慢指针，我们来看看这个问题会变成什么样。思路如下：我们把一个链表看成一个跑道，
		假设a的速度是b的两倍，那么当a跑完全程后，b刚好跑一半，以此来达到找到中间节点的目的。
		2 判断链表中的环
		还是把链表比作一条跑道，链表中有环，那么这条跑道就是一条圆环跑道，在一条圆环跑道中，两个人有速度差，
		那么迟早两个人会相遇，只要相遇那么就说明有环。
		3.删除倒数第n个节点
		删除倒数第n个节点，那就等于是要我们先找出待删除元素前一个元素，也就是第n-1个节点。
		一开始就让fast指针比slow指针快n+1个元素，接下来，两个指针都是一步一步来往下走。
		那么当fast指针走完时，slow指针就刚刚好停留在第(n-1)个元素上。
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		
		ListNode fast=head;ListNode slow=head;
		while(n>0) {
			fast=fast.next;
			n--;
		}
		if(fast==null) {
			return head.next;
		}
	
		while(fast.next!=null) {
			slow=slow.next;
		}
		
		slow.next=slow.next.next;
		
		return head;
        
    }
	
public ListNode removeNthFromEnd1(ListNode head, int n) {
		
	 ListNode p1 = head, p2 = head;
     while (p2 != null){
         p2 = p2.next;
         n --;
         if (n < -1)p1 = p1.next;
     } 
     if (n == 0)return head.next;
     p1.next = p1.next.next;
     return head;
        
    }
	
}
