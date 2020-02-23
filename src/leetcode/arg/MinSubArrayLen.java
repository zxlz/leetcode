package leetcode.arg;

/**
 * 
 * 双索引--滑动窗口（一些题目用滑动窗口方法解题，
 * 可以将时间复杂度控制在 O(n) 级别，最重要的是定义好滑动窗口，明确它要表达的意思，当然边界和初始值非常重要。）
 * 长度最小的子数组
给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。

示例: 

输入: s = 7, nums = [2,3,1,2,4,3]
输出: 2
解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * @author zxl
 *
 */
public class MinSubArrayLen {
	public int minSubArrayLen(int s, int[] nums) {
		if(nums==null|| nums.length==0)return 0;
        int head=0;
    	int tail=0;
    	int res=0;
    	int sum=nums[0];
    	while(tail<nums.length) {
    		if(sum>=s) {
    			int temp=tail-head+1;
    			if(res==0 || temp<res) {
    				res=temp;
    			}
    			sum -=nums[head];
    			head++;
    		}else {
    			tail++;
    			if(tail<nums.length)sum +=nums[tail];
    		}
    	}
		return res;

    }
	/**
	 * 等于s的长度最小子数组
	 * @param s
	 * @param nums
	 * @return
	 */
    public int minSubArrayLen1(int s, int[] nums) {
    	int head=0;
    	int tail=0;
    	int res=0;
    	int sum=nums[0];
    	while(tail<nums.length) {
    		if(head==tail) {
    			if(nums[head]==s)return 1;
    			if(nums[head]>s) {
    				sum -=nums[head];
    				head++;
    			}
    			tail++;
    			if(tail<nums.length)sum +=nums[tail];
    			continue;
    		}
    		
    		if(sum>s) {
    			sum -=nums[head];
    			head++;
    			
    		}else if(sum<s) {
    			tail++;
    			if(tail<nums.length)sum +=nums[tail];
    		}else {
    			int temp=tail-head+1;
    			if(res==0 || temp<res) {
    				res=temp;
    			}
    			sum -=nums[head];
    			head++;
    			tail++;
    			if(tail<nums.length)sum +=nums[tail];
    		}
    	}
		return res;

    }
}
