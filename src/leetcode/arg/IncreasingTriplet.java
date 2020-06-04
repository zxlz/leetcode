package leetcode.arg;

/**
 * 递增的三元子序列
给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。

数学表达式如下:

如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。

示例 1:

输入: [1,2,3,4,5]
输出: true
 * @author zxl
 *
 */
public class IncreasingTriplet {
	//largr，short两个值 ，
    public boolean increasingTriplet(int[] nums) {
    	int big=Integer.MAX_VALUE;
    	int small=Integer.MAX_VALUE;
    	for (int i = 0; i < nums.length; i++) {
			if(nums[i]<small) {
				small=nums[i];
			}else if(nums[i]>small){
				if(nums[i]>big) {
					return true;
				}else {
					big=nums[i];
				}
			}
		}
    	return false;
    }
}
