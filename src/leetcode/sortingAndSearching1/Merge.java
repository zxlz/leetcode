package leetcode.sortingAndSearching1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 合并区间
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * @author zxl
 *
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
    	if(intervals.length<2)return intervals;
    	Arrays.sort(intervals,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {

				return o1[0]-o2[0];
			}
		});
    	int[][] res=new int[intervals.length][];
    	int next=0;
    	res[0]=intervals[0];
    	//0从小到大 ，0位小于等于上一个的1位，此位置可消掉
    	for(int i=1;i<intervals.length;i++) {
    		if(intervals[i][0]>res[next-1][1]) {//区间结尾大于上一个，不能重叠
    			res[++next]=intervals[i];
    		}else {
    			//合并，取1位最大的
    			res[next-1][1]=Math.max(res[next-1][1], intervals[i][1]);
    		}
    	}
    	return Arrays.copyOf(res,next);
    }
}
