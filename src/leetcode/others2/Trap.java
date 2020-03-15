package leetcode.others2;

/**
 * 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
 * @author zxl
 *双指针
 */
public class Trap {
    public int trap(int[] height) {
    	if(height.length<3)return 0;
    	int res = 0;
    	int leftMax=0;int rightMax=0;
    	int left = 0,right=height.length-1; 
    	while (left < right) {
			if(height[left]<height[right]) {//算矮的一个
				if(height[left]>leftMax) {
					leftMax=height[left];
				}else {
					res +=leftMax-height[left];
				}
				left++;
			}else {
				if(height[right]>rightMax) {
					rightMax=height[right];
				}else {
					res += rightMax-height[right];
				}
				right--;
			}
		}
		return res;

    }
}
