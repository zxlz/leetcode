package leetcode.others2;

import org.junit.Test;

/**
 * 柱状图中最大的矩形
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

示例:

输入: [2,1,5,6,2,3]
输出: 10
 * @author zxl
 *
 */
public class LargestRectangleArea {
	@Test
	public void main() {
		largestRectangleArea(new int[] {2,1,5,6,2,3});
		System.out.println();
	}
	//分治
    public int largestRectangleArea(int[] heights) {
    	return DivideAndConquer(heights,0,heights.length-1);
    }

	private int DivideAndConquer(int[] heights, int start, int end) {
		// TODO Auto-generated method stub
		if(start>end)return 0;
//		System.out.println("start:"+start+"end:"+end);
		int minIndex=start;
		for(int i=start+1;i<=end;i++)
			if(heights[i]<heights[minIndex])minIndex=i;//找到最小i
		System.out.println("start:"+start+"end:"+end+"min:"+minIndex);
		return Math.max(heights[minIndex]*(end-start+1)
							,Math.max(DivideAndConquer(heights, start, minIndex-1)
									,DivideAndConquer(heights, minIndex+1, end)));
	}
}
