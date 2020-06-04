package leetcode.binarySearch;

/**
 * 寻找重复数
给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

示例 1:

输入: [1,3,4,2,2]
输出: 2
 * @author zxl
 *
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
    	int fast=0;
    	int slow=0;
    	while((fast=nums[nums[fast]])!=(slow=nums[slow])){
    		
    	}
    	
		return fast;

    }
}
