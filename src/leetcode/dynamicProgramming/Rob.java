package leetcode.dynamicProgramming;

/**
 * 打家劫舍
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

示例 1:

输入: [1,2,3,1]
 1  3  4  5  2  3  5  1
输出: 4
解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。
 * @author zxl
 *n= n-1+ ((n-2)+n)
 *
 */
public class Rob {
	/**
	 * 递归会有大量重复计算，用cache，用for迭代，尾递归？
	 */
	Integer[] resCache;
    public int rob(int[] nums) {
    	if(nums==null|| nums.length<1) {
    		return 0;
    	}
    	if(nums.length==1)return nums[0];
    	resCache=new Integer[nums.length];
    	resCache[0]=nums[0];
    	resCache[1]=nums[1]>nums[0]?nums[1]:nums[0];
		return rob(nums,nums.length-1);
    }

	private int rob(int[] nums, int n) {

		if(resCache[n]!=null) {
			return resCache[n];
		}
		int a=rob(nums,n-1);
		int b=rob(nums,n-2)+nums[n];
		resCache[n]=a>b?a:b;
		return resCache[n];
	}
	
}
