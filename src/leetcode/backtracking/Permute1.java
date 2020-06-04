package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  全排列II
 *nums有重复元素，结果不能重复。
 *解决：在版本I基础上 剪支。 排序后旁分支元素一样就不进入分支，跳过。
 * @author zxl
 */
public class Permute1 {
	List<List<Integer>> res= new LinkedList<List<Integer>>();
	Integer[] comb;
	int[] nums;
	boolean[] used;
	public List<List<Integer>> permute(int[] nums) {
		 comb = new Integer[nums.length];
		 used=new boolean[nums.length];
		 this.nums=nums;
		 Arrays.sort(nums);
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
				if(j>0 && nums[j]==nums[j-1] && !used[j-1]) continue;
				comb[index]=nums[j];
				used[j]=true;
				find(index+1);
				used[j]=false;
			}
		}
		
	}
}
