package leetcode.binarySearch;

import java.util.Arrays;

/**
 * 找出第 k 小的距离对
给定一个整数数组，返回所有数对之间的第 k 个最小距离。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值。

示例 1:

输入：
nums = [1,3,1]
k = 1
输出：0 
解释：
所有数对如下：
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
因此第 1 个最小距离的数对是 (1,1)，它们之间的距离为 0。
提示:

2 <= len(nums) <= 10000.
0 <= nums[i] < 1000000.
1 <= k <= len(nums) * (len(nums) - 1) / 2.

 * @author zxl
 *找出第 k 小的距离对
 */
public class SmallestDistancePair {
	public int smallestDistancePair(int[] nums, int k) {
    	Arrays.sort(nums);
    	int minDiff =0;
    	int maxDiff=nums[nums.length-1]-nums[0];
    	while(minDiff<maxDiff) {
    		int midDiff=(minDiff+maxDiff)>>1;
    		int count=findCountByDiff(nums,midDiff);//距离小于midDiff的数量
    		if(count<k) {
    			minDiff=midDiff+1;
    		}else {
    			maxDiff=midDiff;
    		}
    	}
    	
		return minDiff;

    }
    //距离小于等于midDiff的数量
	private int findCountByDiff(int[] nums, int diff) {
		// TODO Auto-generated method stub
		int len=nums.length; int big=nums.length-1;
		int res=0;
		for (int i = nums.length-2; i >=0; --i) {
			while(big>i && nums[big]-nums[i]>diff) {
				big--;
			}
			res +=big-i;
		}
		return res;
	}
     
}
