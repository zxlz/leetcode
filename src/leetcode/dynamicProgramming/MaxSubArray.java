package leetcode.dynamicProgramming;
/**
 * 最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * @author zxl
 * 1. 小于0，弃-下一位，
 *    大于0，累加下一位，2.小于0，弃-下一位
 * 				        大于0，累加下一位 回到step1 
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
    	int max=nums[0];
    	int tempMax=nums[0];
    	for(int i=1;i<nums.length;i++) {
    		if(tempMax>0) {
    			tempMax +=nums[i];
    		}else {
    			//tempMax小于0时，
    			if(nums[i]>tempMax) {
    				tempMax=nums[i];
    			}
    		}
    		
    		if(max<tempMax) {
    			max=tempMax;
    		}
    	}
		return max;

    }
}
