package leetcode.design2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数据流的中位数
中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。

例如，

[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：

void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。
示例：

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
进阶:

如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 * @author zxl
 *
 */
public class MedianFinder {
	Queue<Integer> largeHeap;
	Queue<Integer> smallHeap;
	boolean isOdd;
	/** initialize your data structure here. */
    public MedianFinder() {
    	largeHeap=new PriorityQueue<Integer>();//小的在顶部
    	smallHeap=new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});//大的在顶部
    	
    	isOdd=false;
    }
    
    public void addNum(int num) {
    	isOdd=!isOdd;//true 这次加入后是奇数
    	if(isOdd) {
    		if(smallHeap.isEmpty() ||num>=smallHeap.peek()) {//优先去large堆
        		largeHeap.offer(num);
        	}else {
        		smallHeap.offer(num);
        	}
    	}else {
    		if(num>largeHeap.peek()) {//优先去small堆
        		largeHeap.offer(num);
        	}else {
        		smallHeap.offer(num);
        	}
    	}
    	if(smallHeap.size()>largeHeap.size())largeHeap.offer(smallHeap.poll());
    	if(largeHeap.size()-smallHeap.size()>1)smallHeap.offer(largeHeap.poll());
    	
    }
    
    public double findMedian() {
    	if(isOdd)return largeHeap.peek();
    	return (largeHeap.peek()+smallHeap.peek())/2.0;
    }
}
