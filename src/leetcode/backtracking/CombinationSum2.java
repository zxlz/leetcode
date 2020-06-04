package leetcode.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和 II
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
 * @author zxl
 *
 */
public class CombinationSum2 {
    List<List<Integer>> res ;
//    Deque<Integer> temp ;
    List<Integer> temp ;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new LinkedList<List<Integer>>();
//        temp = new ArrayDeque<Integer>();
        temp = new ArrayList<Integer>();
        Arrays.sort(candidates);
        backtrack(candidates,target,temp,0);
        return res;
    }
    private void backtrack(int[] candidates, int target, List<Integer> temp,int start) {
        for (int i = start; i < candidates.length; i++) {
            if(i>start && candidates[i]==candidates[i-1])continue;
            if(candidates[i]==target) {
                temp.add(candidates[i]);
                res.add(new ArrayList<Integer>(temp));
                temp.remove(temp.size()-1);
            }else if(candidates[i]<target) {
                temp.add(candidates[i]);
                backtrack(candidates,target-candidates[i],temp,i+1);
                temp.remove(temp.size()-1);
            }else {
                return;
            }
        }
     }
}
