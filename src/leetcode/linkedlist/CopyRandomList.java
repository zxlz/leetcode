package leetcode.linkedlist;

import java.util.HashMap;

/**
 * 复制带随机指针的链表
给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

要求返回这个链表的 深拷贝。 

我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：

val：一个表示 Node.val 的整数。
random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * @author zxl
 *1.hash
 *2.交替next连接（高效）
 */
public class CopyRandomList {
	class Node {
	    int val;
	    Node next;
	    Node random;
	    
	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
    public Node copyRandomList(Node head) {
    	HashMap<Node, Node> hashMap=new HashMap<Node, Node>();
    	Node node=head;
    	while(node!=null) {
    		Node newNode=new Node(node.val);
    		hashMap.put(node, newNode);
    		node=node.next;
    	}
    	node=head;
    	while(node!=null) {
    		Node newNode=hashMap.get(node);
    		newNode.next=hashMap.get(node.next);
    		newNode.random=hashMap.get(node.random);
    		
    		node=node.next;
    	}
		return hashMap.get(head);
        
    }
    /**
     * A-- B-- C-- D-- E
     * 
     * A   B   C   D   E
     * | ↗ | ↗ | ↗ | ↗ |
     * a   b   c   d   e
     * 
     * 
     * @param head
     * @return
     */
    public Node copyRandomList1(Node head) {
    	Node node=head;
        if(node==null) return null;
    	while(node!=null) {
    		Node t=node.next;
    		node.next=new Node(node.val);//复制自己，把next指向自己
    		node.next.next=t;
    		
    		node=t;
    	}
        node=head;
    	//设置新节点的Rondom
    	while(node!=null) {
    		
    		if(node.random!=null) {
    			node.next.random=node.random.next;
    		}
    		
    		node=node.next.next;
    	}
    	node=head;
    	Node newHead=head.next;
    	
    	//断开和原节点的link
    	while(node.next.next!=null) {
    		Node newNode=node.next;
    		node.next=node.next.next;//原节点
    		newNode.next=newNode.next.next;//新节点

    	    node=node.next;
    	}
        node.next=null;//断掉最后一个link
		return newHead;
        
    }
}
