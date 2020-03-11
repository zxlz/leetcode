package leetcode.dynamicProgramming1;

import org.junit.Test;

/**
 * Longest Increasing Subsequence
给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4 
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * @author zxl
 *
 * fn = fn-1
 *
 */

public class LengthOfLIS {
	@Test
	public void main() {
		lengthOfLIS(new int[] {-2,-1});
	}
	
	public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            if(res==0){
                tails[res++]=num;
                continue;
            }
            if(num>tails[res-1]){
                tails[res++]=num;
            }
            else if(num<tails[res-1]){//num 比前一个小 不符合子序， 
            	//在子序中找到最早比num大的位置 i
                int i=0,j=res-1;
                while(i<j){
                    int m = (i+j)/2;
                    if(tails[m]<num){
                        i = m+1;
                    }
                    else{
                        j=m;
                    }
                }
                if(i<res){
                    tails[i]=num;
                }
                // 1 3  4 5  9  100  1000 6  7  8 10 11 13
                // 1 3 4 5  9 100 1000
                // 1 3 4 5  6 7 1000  
                //保留了前面升子序  
            }
        }
        return res;
    }
    public int lengthOfLIS1(int[] nums) {
    	int ans=0;
    	int[] dp=new int[nums.length];
    	for (int i = 0; i < nums.length; i++) {
    		dp[i]=0;
			for (int j = i-1; j >=0; j--) {
				if(nums[j]<nums[i]&&dp[j]>dp[i]) {//一次与前一个比较，前一个比较小，并且len更大
					dp[i]=dp[j];
					if(dp[j]>j)break;
				}
			}
			dp[i]++;
			if(dp[i]>ans)ans=dp[i];
		}
		return ans;

    }
}
