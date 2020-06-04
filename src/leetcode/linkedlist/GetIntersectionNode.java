package leetcode.linkedlist;

/**
 * 相交链表
编写一个程序，找到两个单链表相交的起始节点。


注意：

如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * @author zxl
 * 方法1.同时遍历，记忆化访问过的节点，直到发现重复的【记忆化用hash时间效率，内存消耗】
 * 方法2.模拟环，每个单链到末尾回到head，第一次交点是【很多次循环才会碰到】
 * 方法3.遍历两个长度，长的单链和短的从同一长度开始遍历，同时依次比较  接近 O(2n)
 */
public class GetIntersectionNode {
	//时间ON-O2N之间
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if(headA==null || headB==null){
            return null;
        }
        ListNode longHead=headA;
        ListNode shortHead=headB;//先假设a长b短
        
    	while(longHead!=null||shortHead!=null) {
    		if(longHead!=null && shortHead!=null) {
                //System.out.println(shortHead.val);
    			longHead=longHead.next;
    			shortHead=shortHead.next;
                
    			continue;
    		}
    		//System.out.println(shortHead.val+"==");
    		ListNode temp=null;
    		if(shortHead!=null){//b更长
    			temp=shortHead;
    			longHead=headB;//longHead放长的head 起点
    			shortHead=headA;
    		}else if(longHead!=null){//a更长
    			temp=longHead;//temp放长的剩余
    			longHead=headA;//longHead放长的head 起点
                shortHead=headB;
    		}
    			
    			
    			while(temp!=null) {
    				temp=temp.next;
    				longHead=longHead.next;
    			}
    			//结束后longHead（长链表）已调整起始遍历点
    		break;	
    	}
        if(longHead==null && shortHead==null){
            longHead=headA;shortHead=headB;
        }
    	while(longHead!=null) {
    		if(longHead==shortHead)return longHead;
    		longHead=longHead.next;
    		shortHead=shortHead.next;
    	}
    	
    	return null;
    }
}
