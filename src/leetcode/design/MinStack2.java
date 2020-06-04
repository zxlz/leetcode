package leetcode.design;

public class MinStack2 {
	/**
	 * 每个节点都记录到当前节点最小值
	 */
	    ListNode head;
	    class ListNode{
	        int min;
	        int val;
	        ListNode next;
	        public ListNode(int val,int min,ListNode node){
	            this.val=val;
	            this.min=min;
	            this.next=node;
	        }
	    }

	    /** initialize your data structure here. */
	    public MinStack2() {
	        head=null;
	    }

	    public void push(int x) {
	        if(head==null)
	            head=new ListNode(x,x,null);
	        else head=new ListNode(x, Math.min(x,head.min),head);
	    }

	    public void pop() {
	        head=head.next;
	    }

	    public int top() {
	        return head.val;
	    }

	    public int getMin() {
	        return head.min;
	    }

}
