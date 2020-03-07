package leetcode.tree;

import leetcode.tree.Codec.TreeNode;

/**
 * Kth Largest Element in a Stream
设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。

你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，
它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。

示例:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
说明:
你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 * @author zxl
 *
 */
public class KthLargest {

	/**
	 * 			  1
	 * 		2          3
	 *   4     5     6    7
	 * 8  9  10 11 12 13 14 15
	 * 
	 *  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
	 * @param k
	 * @param nums
	 */
	int[] minHeap;
	int next=0;
	int len=0;
	public KthLargest(int k, int[] nums) {
		minHeap = new int[k];
		len=k;
		for (int i = 0; i < nums.length; i++) {
			_insert(nums[i]);
		}
    }
	void _insert(int x){
		//满了，比min大的才可以放进去， 放在堆顶再换位置
		if(next>minHeap.length-1) {
			if(x>minHeap[0]) {
				minHeap[0]=x;
				int temp=2;
				if(len>=3){
					temp=minHeap[temp-1]
							<minHeap[temp]?temp:temp+1;
				}
				while(temp<=len &&(minHeap[temp/2-1]>minHeap[temp-1] )) {
					minHeap[temp/2-1]=minHeap[temp-1];
					minHeap[temp-1]=x;
					temp=temp*2;
					if(temp>len) break;
					if(temp==len) {
					}else {
						temp=minHeap[temp-1]
								<minHeap[temp]?temp:temp+1;
					}	
				}
			}
		}else {
			minHeap[next++]=x;
		    int temp=next;
		    //1 0
		    //2-0
		    //3-0 4-1 5-1
		    while(temp>1&&minHeap[temp/2-1]>minHeap[temp-1]){
		    	minHeap[temp-1]=minHeap[temp/2-1];
		    	minHeap[temp/2-1]=x;
		    	temp/=2;
		    }
		}
	}
    public int add(int val) {
    		_insert(val);
    		return minHeap[0];
    		
    }
}
