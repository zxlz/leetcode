package leetcode.linkedlist;


public class MyLinkedList {
	 private static class Node {
	        int item;
	        Node next;
	        Node prev;

	        Node(Node prev, int element, Node next) {
	            this.item = element;
	            this.next = next;
	            this.prev = prev;
	        }
	    }
	  private int size = 0;
	  Node first;
	  Node last;
    /** Initialize your data structure here. */
    public MyLinkedList() {

    }
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }
    Node node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
    	if(isElementIndex(index)) {
    		return node(index).item;
    	}
        return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
    	final Node f = first;
        final Node newNode = new Node(null, val, f);
        first = newNode;
        if (f == null) {
        	 last = newNode;
        }else {
        	f.prev = newNode;
        }
        size++;
    }
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
    	final Node l = last;
        final Node newNode = new Node(l, val, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
    	if(index >= 0 && index <= size) {
    		if (index == size)
                addAtTail(val);
            else
                linkBefore(val, node(index));
    	}
    }
    
    private void linkBefore(int val, Node succ) {

    	// assert succ != null;
        final Node pred = succ.prev;
        final Node newNode = new Node(pred, val, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
	}
	/** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
    	if(index >= 0 && index < size) {
    		Node x=node(index);
//    		final int element = x.item;
            final Node next = x.next;
            final Node prev = x.prev;

            if (prev == null) {
                first = next;
            } else {
                prev.next = next;
                x.prev = null;
            }

            if (next == null) {
                last = prev;
            } else {
                next.prev = prev;
                x.next = null;
            }

//            x.item = 0;
            size--;
    	}
    }
}
