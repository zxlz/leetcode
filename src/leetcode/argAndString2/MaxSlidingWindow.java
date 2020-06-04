package leetcode.argAndString2;

import java.util.ArrayDeque;

import org.junit.Test;

/**
 * 滑动窗口最大值
给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回滑动窗口中的最大值。

 

示例:

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7] 
解释: 

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 

提示：

你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。

 
 * @author zxl
 *
 */
public class MaxSlidingWindow {
	@Test
	public void main() {
		maxSlidingWindow1(new int[] {1,2,3,4,5,100,200,99,90,80,95},5);
	}
	ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
	  int [] nums;

	  public void clean_deque(int i, int k) {
	    // remove indexes of elements not from sliding window
	    if (!deq.isEmpty() && deq.getFirst() == i - k)
	      deq.removeFirst();

	    // remove from deq indexes of all elements 
	    // which are smaller than current element nums[i]
	    while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])deq.removeLast();
	  }

	  public int[] maxSlidingWindow(int[] nums, int k) {
	    int n = nums.length;
	    if (n * k == 0) return new int[0];
	    if (k == 1) return nums;

	    // init deque and output
	    this.nums = nums;
	    int max_idx = 0;
	    for (int i = 0; i < k; i++) {
	      clean_deque(i, k);
	      deq.addLast(i);
	      // compute max in nums[:k]
	      if (nums[i] > nums[max_idx]) max_idx = i;
	    }
	    int [] output = new int[n - k + 1];
	    output[0] = nums[max_idx];

	    // build output
	    for (int i  = k; i < n; i++) {
	      clean_deque(i, k);
	      deq.addLast(i);
	      output[i - k + 1] = nums[deq.getFirst()];
	    }
	    return output;
	  }
	  public int[] maxSlidingWindow1(int[] nums, int k) {
		    int n = nums.length;
		    if (n * k == 0) return new int[0];
		    if (k == 1) return nums;

		    int [] left = new int[n];
		    left[0] = nums[0];
		    int [] right = new int[n];
		    right[n - 1] = nums[n - 1];
		    for (int i = 1; i < n; i++) {
		      // from left to right
		      if (i % k == 0) left[i] = nums[i];  // block_start
		      else left[i] = Math.max(left[i - 1], nums[i]);

		      // from right to left
		      int j = n - i - 1;
		      if ((j + 1) % k == 0) right[j] = nums[j];  // block_end
		      else right[j] = Math.max(right[j + 1], nums[j]);
		    }

		    int [] output = new int[n - k + 1];
		    for (int i = 0; i < n - k + 1; i++)
		      output[i] = Math.max(left[i + k - 1], right[i]);

		    return output;
		  }
	  //{1,2,3,4,5,100,200,99,90,80,95}

	

		
}
