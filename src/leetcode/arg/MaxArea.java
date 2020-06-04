package leetcode.arg;

/**
 * 双索引--对撞指针
 *  盛最多水的容器
给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * @author zxl
 *
 */
public class MaxArea {
    public int maxArea(int[] height) {
    	int left=0;
    	int right=height.length-1;
    	int res=0;
    	do {
    		int area=(height[left]<height[right]?height[left]:height[right])*(right-left);
    		if(area>res)res=area;
    		if(height[left]<height[right]) {
    			left++;
    		}else {
    			right--;
    			
    		}
    	}while(left<right);
		return res;
    }
}
