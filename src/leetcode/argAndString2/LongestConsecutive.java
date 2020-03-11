package leetcode.argAndString2;

import java.util.HashSet;

/**
 * 最长连续序列
给定一个未排序的整数数组，找出最长连续序列的长度。

要求算法的时间复杂度为 O(n)。

示例:

输入: [100, 4, 200, 1, 3, 2]
输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * @author zxl
 *
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
    	HashSet<Integer> cache=new HashSet<Integer>();
    	for(int num:nums) {
    		cache.add(num);
    	}
    	int res=0;
    	for (int i = 0; i < nums.length; i++) {
			if(!cache.contains(nums[i]-1)) {
				int count=1;
				int num=nums[i];
				while(cache.contains(num+1)) {
					num++;
					count++;
				}
				res=Math.max(res, count);
			}
			
		}
    	return res;
    }
}
