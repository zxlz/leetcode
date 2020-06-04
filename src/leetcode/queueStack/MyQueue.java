package leetcode.queueStack;

import java.util.Queue;
import java.util.Stack;

/**
 * 用栈实现队列
使用栈实现队列的下列操作：

push(x) -- 将一个元素放入队列的尾部。
pop() -- 从队列首部移除元素。
peek() -- 返回队列首部的元素。
empty() -- 返回队列是否为空。
 * @author zxl
 *
 */
public class MyQueue {
	Stack<Integer> stack1;//入
	Stack<Integer> stack2;//出
	/** Initialize your data structure here. */
    public MyQueue() {
    	stack1=new Stack<Integer>();
    	stack2=new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	if(!stack2.isEmpty()) {
    		return stack2.pop();
    	}
    	while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
		return stack2.pop();

    }
    
    /** Get the front element. */
    public int peek() {
    	if(!stack2.isEmpty()) {
    		return stack2.peek();
    	}
    	while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    	
    		return stack2.peek();
    	
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
		return stack1.isEmpty()&& stack2.isEmpty();

    }
}
