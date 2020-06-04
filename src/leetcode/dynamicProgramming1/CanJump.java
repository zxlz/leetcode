package leetcode.dynamicProgramming1;

/**
 * 跳跃游戏
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * @author zxl
 * f(n)=f(n-1)>=1
 * 		f(n-2)>=2
 *
 */
public class CanJump {
	int[] nums;
    public boolean canJump(int[] nums) {
    	int needJump=1;	
    	this.nums=nums;
    	return dp(needJump,nums.length-1);
    }
	private boolean dp(int needJump, int i) {

		if(i==0)return true;
		while(nums[i-1]<needJump) {
			i--;
			needJump++;
			if(i==0)return false;
		}
		return dp(needJump, i-1);
	}
}
