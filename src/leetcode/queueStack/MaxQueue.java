package leetcode.queueStack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {
	// 3 5 4 6
	// 5 4 
	Deque<Integer> maxDeque; 
	Queue<Integer> queue; 
	public MaxQueue() {
		maxDeque= new LinkedList<Integer>();
		queue= new LinkedList<Integer>();
	}

	public int max_value() {
		if(maxDeque.isEmpty())return -1;
		return maxDeque.peek();
	}

	public void push_back(int value) {
		queue.offer(value);
		while(!maxDeque.isEmpty() && maxDeque.getLast()<value) {
			maxDeque.pollLast();
		}
		maxDeque.offer(value);
	}

	public int pop_front() {
		if(maxDeque.isEmpty())return -1;
		int i=queue.poll();
		if(  maxDeque.peek().equals(i)) {
			maxDeque.poll();
		};
		return i;
	}

}
