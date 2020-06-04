package leetcode.queueStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
使用队列实现栈的下列操作：

push(x) -- 元素 x 入栈
pop() -- 移除栈顶元素
top() -- 获取栈顶元素
empty() -- 返回栈是否为空
 * @author zxl
 *
 */
public class MyStack {
	Queue<Integer> queue1 ;//主队列
	Queue<Integer> queue2 ;
	/** Initialize your data structure here. */
    public MyStack() {
    	queue1= new LinkedList<Integer>();
    	queue2= new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
    	queue1.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	while(queue1.size()>1) {
    		queue2.offer(queue1.poll());
    	}
    	int o=queue1.poll();
    	Queue<Integer> temp=queue1;
    	queue1=queue2;
    	queue2=temp;
    	return o;
    }
    
    /** Get the top element. */
    public int top() {
    	while(queue1.size()>1) {
    		queue2.offer(queue1.poll());
    	}
    	int o=queue1.peek();
    	queue2.offer(queue1.poll());
    	
    	Queue<Integer> temp=queue1;
    	queue1=queue2;
    	queue2=temp;
    	return o;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
    	return queue1.isEmpty();
    }
}
