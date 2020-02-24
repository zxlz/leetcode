package leetcode.arg;

import org.junit.Test;

/**
 * 最大连续1的个数
给定一个二进制数组， 计算其中最大连续1的个数。

示例 1:

输入: [1,1,0,1,1,1]
输出: 3
解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.

输入的数组只包含 0 和1。
输入数组的长度是正整数，且不超过 10,000。
 * @author zxl
 *
 */
public class FindMaxConsecutiveOnes {
	@Test
	public void main() {
		
		findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1});
	}
    public int findMaxConsecutiveOnes(int[] nums) {
    	int head=0;
    	int tail=0;
    	int res=0;
    	int temp=0;
    	while(tail<nums.length && head<nums.length) {
    		
    		while(head<nums.length && nums[head]==0 ) {
    			head++;
    			tail++;
    		}
    		while(tail<nums.length && nums[tail]==1 ) {
    			tail++;
    			temp++;
    		}
    		
    		if(res<temp)res=temp;
    		temp=0;
            head=tail+1;
            tail=tail+1;
    	}
		return res;

    }
}
