package leetcode.others2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 天际线问题
城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。现在，假设您获得了城市风光照片（图A）上显示的所有建筑物的位置和高度，
请编写一个程序以输出由这些建筑物形成的天际线（图B）。

Buildings Skyline Contour

每个建筑物的几何信息用三元组 [Li，Ri，Hi] 表示，其中 Li 和 Ri 分别是第 i 座建筑物左右边缘的 x 坐标，Hi 是其高度。
可以保证 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX 和 Ri - Li > 0。您可以假设所有建筑物都是在绝对平坦且高度为 0 的表面上的完美矩形。

例如，图A中所有建筑物的尺寸记录为：[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] 。

输出是以 [ [x1,y1], [x2, y2], [x3, y3], ... ] 格式的“关键点”（图B中的红点）的列表，它们唯一地定义了天际线。
关键点是水平线段的左端点。请注意，最右侧建筑物的最后一个关键点仅用于标记天际线的终点，并始终为零高度。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。

例如，图B中的天际线应该表示为：[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]。

说明:

任何输入列表中的建筑物数量保证在 [0, 10000] 范围内。
输入列表已经按左 x 坐标 Li  进行升序排列。
输出列表必须按 x 位排序。
输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；
三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
 * @author zxl
 *
 */
public class GetSkyline {
	//待优化，效率慢，堆的remove太慢？看PriorityQueue要先遍历找出index，然后移除，再还要重新子节点递归上移
	//[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] 。
    public List<List<Integer>> getSkyline(int[][] buildings) {
    	int[][] newbuild = new int[2*buildings.length][2];//o位是x坐标，1位 正值是高度，负值是该高度退出 
    	for (int i = 0; i < buildings.length; i++) {
			newbuild[2 * i][0] = buildings[i][0];
			newbuild[2 * i][1] = buildings[i][2];
			newbuild[2 * i + 1][0] = buildings[i][1];
			newbuild[2 * i + 1][1] = -buildings[i][2];
		}
    	Arrays.sort(newbuild,new Comparator<int[]>() {
			@Override//按照x的坐标升序排列，若x坐标相同，右端点在前
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0])return o2[1]-o1[1];
				return o1[0]-o2[0];
			}
		});
//    	HashMap<Integer,HashSet<Object>> outMap = new HashMap<Integer, HashSet<Object>>();//key 开始无效坐标，value无效对象
    	List<List<Integer>> res= new LinkedList<List<Integer>>();
    	PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) { 
				return o2-o1;
			}
		});
    	maxHeap.offer(0);
    	for (int i = 0; i < newbuild.length; i++) {
			if(newbuild[i][1]>0) {
				if(newbuild[i][1]>maxHeap.peek()) {//左端点 比堆中最高的还高，是转折点
					res.add(Arrays.asList(newbuild[i][0], newbuild[i][1]));
				}
				maxHeap.offer(newbuild[i][1]);
			}else {//到了这个房子的右端点了，要在堆中移除
				maxHeap.remove(-newbuild[i][1]);//
				if(-newbuild[i][1]>maxHeap.peek()) {//右端点 比堆中最高的还高，是转折点
					res.add(Arrays.asList(newbuild[i][0], maxHeap.peek()));
				}
			}
		}
    	return res;
    }
}
