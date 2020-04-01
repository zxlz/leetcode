package leetcode.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

/**
 * 39. 组合总和
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
 * @author zxl
 *
 */
public class CombinationSum {
    @Test
    public void main() {
        combinationSum(new int[] {2,3,6,7}, 7);
        System.out.println();
    }
    List<List<Integer>> res ;
    Deque<Integer> temp ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new LinkedList<List<Integer>>();
        temp = new ArrayDeque<Integer>();
        Arrays.sort(candidates);
        backtrack(candidates,target,temp,0);
        return res;
    }

    private void backtrack(int[] candidates, int target, Deque<Integer> temp,int start) {
       for (int i = start; i < candidates.length; i++) {
           if(candidates[i]==target) {
               System.out.println(candidates[i]);
               temp.offer(candidates[i]);
               res.add(new ArrayList<Integer>(temp));
               System.out.println(temp.pollLast());
           }else if(candidates[i]<target) {
               temp.offer(candidates[i]);
               backtrack(candidates,target-candidates[i],temp,i);
               temp.pollLast();
           }else {
               return;
           }
       }
    }
}
