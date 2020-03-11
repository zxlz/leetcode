package leetcode.argAndString2;

import org.junit.Test;

/**
 * 除自身以外数组的乘积
给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

 

示例:

输入: [1,2,3,4]
输出: [24,12,8,6]
 * @author zxl
 *
 *方法1：索引处左侧的所有数字乘积和右侧所有数字的乘积相乘得到答案。
 */
public class ProductExceptSelf {
	@Test
	public void main() {
		productExceptSelf(new int[] {1,2,3,4});
	}
    public int[] productExceptSelf(int[] nums) {
    	int[] ans = new int[nums.length];
    	ans[1]=nums[0];
    	ans[0]=1;
    	for (int i = 2; i < nums.length; i++) {
			ans[i]=nums[i-1]*ans[i-1];
		}//生成每个数左边的乘积
    	int temp=1;//循环乘上每个数右边的乘积
    	for (int i = nums.length-2; i >=0; i--) {
			temp=temp*nums[i+1];
			ans[i] *=temp;
		}
    	return ans;
        
    }
}
