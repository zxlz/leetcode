package leetcode.linkedlist;

/**
 * 扁平化多级双向链表
您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。
这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。

扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。

 

示例:

输入:
 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL

输出:
1-2-3-7-8-11-12-9-10-4-5-6-NULL
 
 * @author zxl
 *
 */
public class Flatten {
	class Node {
	    public int val;
	    public Node prev;
	    public Node next;
	    public Node child;
	};
    public Node flatten(Node head) {
    	Node node=head;
    	run(node);
    	
		return head;
        
    }
	private Node run(Node node) {
		// TODO Auto-generated method stub
//		Node cHead=node;
		while(node!=null) {
			if(node.child!=null) {
				Node c=node.child;
				Node cTail=run(node.child);

				if(node.next!=null) { //node下一个不是null，把子的尾部和node 的下一个link
					cTail.next=node.next;
					node.next.prev=cTail;
				}					
				//node和child节点link
				node.next=c;
				node.child=null;
				c.prev=node;
				
				node=cTail.next;
				if (node==null) {
					return cTail;
				}
			}else {
				if(node.next ==null) {
					return node;
				}
				node=node.next;
				
			}
    	}
		return null;
		
	}
}
