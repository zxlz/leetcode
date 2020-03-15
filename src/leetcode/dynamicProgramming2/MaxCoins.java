package leetcode.dynamicProgramming2;

/**
 * 戳气球
有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。

现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。

求所能获得硬币的最大数量。

说明:

你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
示例:

输入: [3,1,5,8]
输出: 167 
解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * @author zxl
 *
 */
public class MaxCoins {
	//i到j个球 
	//dp[i][j]=dp[i][k-1]+dp[k+1][j]+nums[i-1]nums[k]nums[j+1]  i<=k<=j
	//和回溯也是n！，但可以用记忆化cache
	int[][] dp ;
	public int maxCoins(int[] nums) {
		dp= new int[nums.length][nums.length];
		helper(nums,0,nums.length-1);
		return 0;
    }
	private int helper(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		if(i>j)return 0;
		if(dp[i][j]>0)return dp[i][j];
		for (int k = i; k <= j; k++) {
			int left=helper(nums, i, k-1);
			int right=helper(nums, k+1, j);
			int cur=nums[k]*i==0?1:nums[i-1]*j==nums.length-1?1:nums[j+1];
			dp[i][j]=Math.max(cur+left+right, dp[i][j]);
		}
		return dp[i][j];
	}
}
