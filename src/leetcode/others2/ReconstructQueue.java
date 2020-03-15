package leetcode.others2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Queue Reconstruction by Height
假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。

注意：
总人数少于1100人。

示例

输入:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

输出:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * @author zxl
 *
 *4,4 5,0 5,2 6,1 7,0 7,1
 *
 *7,0 7,1  6,1 5,0 5,2  4,4
 *
 */
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
    	//因为个子矮的人相对于个子高的人是 “看不见” 的，所以可以先安排个子高的人。
    	Arrays.sort(people,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0];
			}
		});
    	
    	List<int[]> list = new ArrayList<>();
    	for (int i = 0; i < people.length; i++) {
			list.add(people[i][1],people[i]);
		}
    	return list.toArray(new int[people.length][2]);
    }
}
