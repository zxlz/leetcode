package leetcode.dynamicProgramming1;

import java.util.Arrays;

/**
 * 零钱兑换
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

示例 1:

输入: coins = [1, 2, 5], amount = 11
输出: 3 
解释: 11 = 5 + 5 + 1
 * @author zxl
 *
 */
public class CoinChange {
	
	public int coinChange(int[] coins, int amount) {
    	if(coins.length==0)return -1;
    	int[] dp=new int[amount];
    	Arrays.fill(dp, amount);
    	dp[0]=0;
    	for(int i=1;i<=amount;i++) {
    		if(i>=coins[0]) {
				dp[i]=dp[i-coins[0]]+1;
			}
    		for (int j = 1; j < coins.length; j++) {
    			if(i>=coins[j]) {
    				dp[i]=Math.min(dp[i-coins[j]]+1,dp[i]);
    			}
			}
    	}
		return dp[amount]==0?-1:dp[amount];

    }
}
