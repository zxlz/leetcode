package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * 子集
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 * @author zxl
 *
 */
public class Subsets1 {
	@Test
	public void main() {
		subsets(new int[] {1,1,2,2});
	}
	List<List<Integer>> res= new LinkedList<List<Integer>>();
	int[] nums;
	//toArray()比linked快，直接copy，而linked是循环添加
	List<Integer> temp=new ArrayList<Integer>();
    public List<List<Integer>> subsets(int[] nums) {
    	this.nums=nums;
    	Arrays.sort(nums);
    	find(0,temp);
    	return res;
    }
	private void find(int i, List<Integer> temp) {
		
		//arrays比linked的构造快，linked是获取array后循环建立节点关系，arrays是直接copy数组。
		res.add(new ArrayList<Integer>(temp));
		
		for (int j = i; j < nums.length; j++) {
			if( j>i && nums[j]==nums[j-1])continue;//和前一个迭代数相同，则跳过
			temp.add(nums[j]);
			find(j+1,temp);
			temp.remove(temp.size()-1);
		}
	}
    
}
