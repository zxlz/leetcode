package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 * @author zxl
 */
public class Permute {
	List<List<Integer>> res= new LinkedList<List<Integer>>();
	Integer[] comb;
	int[] nums;
	boolean[] used;
	public List<List<Integer>> permute(int[] nums) {
		 comb = new Integer[nums.length];
		 used=new boolean[nums.length];
		 this.nums=nums;
		find(0);
		return res;
    }
	private void find(int index) {
		if(index==comb.length) {
			res.add( new ArrayList<Integer>(Arrays.asList(comb)) );
			return;
		}

		for (int j = 0; j < nums.length; j++) {
			if(used[j]==false) {
				comb[index]=nums[j];
				used[j]=true;
				find(index+1);
				used[j]=false;
			}
		}
		
	}
}
