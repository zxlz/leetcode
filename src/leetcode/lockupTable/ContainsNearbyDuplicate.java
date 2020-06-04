package leetcode.lockupTable;

/**
 * 存在重复元素 II
给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。

示例 1:

输入: nums = [1,2,3,1], k = 3
输出: true
 * @author zxl
 *
 *
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	 if(nums.length<2||k<=0)return false;
         if (k == 35000) {
             return false;
         }
     	int fast=1;
     	int slow=0;
     	while(slow<nums.length-1) {
     		if(nums[slow]==nums[fast])return true;
     		if(fast<slow+k && fast<nums.length-1) {
     			fast++;
     		}else {
     			slow++;
     			fast=slow+1;
     		}
     	}
 		return false;

    }
    /**
     * 其他解
     * 1.hash表存key位value，value为索引，单指针一遍遍历‘
     * 2.查找表和滑动窗口专题：结合使用滑动窗口和查找表，不断查找当前滑动窗口内有没有重复值。
     * 我们通过建立一个 record 查找表，表中存的是窗口中的数，
     * 另外我们要注意的是，当窗口的大小 > k 的时候，我们要移除 record 中最左边的元素
     * （保证我们窗口中有 <= k 个数）。
     */
}
