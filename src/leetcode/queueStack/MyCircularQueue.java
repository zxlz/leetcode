package leetcode.queueStack;


public class MyCircularQueue {
	final Object[] items;
	/** items index for next take, poll, peek or remove */
    int takeIndex;
    /** items index for next put, offer, or add */
    int putIndex;
    /** Number of elements in the queue */
    int count;
	/** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
    	
    	if (k <= 0)
            throw new IllegalArgumentException();
        this.items = new Object[k];
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
    	if (count == items.length)
            return false;
        else {
            items[putIndex] = value;
            if (++putIndex == items.length)
                putIndex = 0;
            count++;
            return true;
        }
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
    	if (count == 0)
           return false;
//        E x = (E) items[takeIndex];
        items[takeIndex] = null;
        if (++takeIndex == items.length)
            takeIndex = 0;
        count--;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
    	if(count==0)return -1;
    	return (int) items[takeIndex];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
    	if(count==0)return -1;
    	if(putIndex==0) {
    		return (int) items[items.length-1];
    	}
    	return (int) items[putIndex-1];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
    	return count==0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
    	return count==items.length;
    }
}
