package leetcode.queueStack;

import org.junit.Test;

/**
 * 目标和
给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

返回可以使最终数组和为目标数 S 的所有添加符号的方法数。

示例 1:

输入: nums: [1, 1, 1, 1, 1], S: 3
输出: 5
解释: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

一共有5种方法让最终目标和为3。
注意:

数组非空，且长度不会超过20。
初始的数组的和不会超过1000。
保证返回的最终结果能被32位整数存下。

			+     -
		  +  -   +   -
		+ - + - + - + -
 * @author zxl
 *
 */
public class FindTargetSumWays {
	@Test
	public void main() {
		findTargetSumWays1(new int[] {1,2,3,4,5}, 3);
	}
	int count=0;
    public int findTargetSumWays(int[] nums, int S) {
    	int sum = 0;
    	// 计算数组中元素之和
    	for (int i = 0; i < nums.length; i++)
    		sum += nums[i];
 
    	if (S > sum || (sum + S) % 2 == 1)
    		return 0;
    	
    	dfs(0,nums,S);
		return count;
    }
//加记忆化缓存会更高效
	private void dfs(int layer, int[] nums, int S) {

		if(layer==nums.length) {
			if( S==0) {
				count++;	
			}
		}else {
			dfs(layer+1,nums,S-nums[layer]);
			dfs(layer+1,nums,S+nums[layer]);
			
		}

	}
	

/**
 * 原问题等同于： 找到nums一个正子集和一个负子集，使得总和等于target

我们假设P是正子集，N是负子集 例如： 假设nums = [1, 2, 3, 4, 5]，target = 3，
一个可能的解决方案是+1-2+3-4+5 = 3 这里正子集P = [1, 3, 5]和负子集N = [2, 4]

那么让我们看看如何将其转换为子集求和问题：

                  sum(P) - sum(N) = target
sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
                       2 * sum(P) = target + sum(nums)
因此，原来的问题已转化为一个求子集的和问题： 找到nums的一个子集 P，
使得sum(P) = (target + sum(nums)) / 2

请注意，上面的公式已经证明target + sum(nums)必须是偶数，否则输出为0 java代码示例：

 */
	 public int findTargetSumWays1(int[] nums, int S) {
	        int sum = 0;
	        for(int num : nums){
	            sum += num;
	        }
	        if(sum<S||(sum+S)%2==1){
	            return 0;
	        }
	        int target = (sum+S)>>>1;
	        int[] dp =  new int[target+1];
	        dp[0] = 1;
	        for(int num :nums){ //从nums找 sum为target的子集
	            for(int j = target;j>=num;j--){    
	                dp[j] +=dp[j-num];
	            }
	        }
	        return dp[target];
	    }
}
