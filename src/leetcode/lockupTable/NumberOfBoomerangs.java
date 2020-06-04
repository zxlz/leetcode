package leetcode.lockupTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 回旋镖的数量
给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。

找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
输入:
[[0,0],[1,0],[2,0]]

输出:
2

解释:
两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * @author zxl
 *
 */
public class NumberOfBoomerangs {
	public int numberOfBoomerangs(int[][] points) {
		int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int[] i : points) {
            for (int[] j : points) {
                if (i == j) continue;
                Integer dist = (i[0] - j[0]) * (i[0] - j[0]) + (i[1] - j[1]) * (i[1] - j[1]);
                Integer prev = map.get(dist);
                if (prev != null) res += 2 * prev;
                //1
                //1  2  3  4
                //0  2  4  8
                map.put(dist, (prev == null) ? 1: prev + 1);
            }
            map.clear();
        }
        return res;
    }
    public int numberOfBoomerangs1(int[][] points) {
    		int res = 0;
    		for (int[] i : points) {
    			Map<Integer, Integer> map = new HashMap<>();
    			for (int[] point : points) {
    				if (point!=i){
    					int dis = distance(i,point);
    					map.put(dis,map.getOrDefault(dis,0)+1);
    				}
    			}
    			for (Integer integer : map.keySet()) {
    				res+=map.get(integer)*(map.get(integer)-1);
    			}
    		}
    		return res;
    		
    }

	private int distance(int[] a , int[] b){
		return (a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]);
	}
}
