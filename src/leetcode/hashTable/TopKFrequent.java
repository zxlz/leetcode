package leetcode.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 前 K 个高频元素
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * @author zxl
 *你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
    	 
//        Map<Integer, Integer> map = new HashMap<>();//每个数的出现次数
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        List<Integer>[] frequence = new LinkedList[nums.length];//各个出现次数下的数
//        for(Map.Entry<Integer, Integer> e:map.entrySet()) {
//        	if(frequence[e.getValue()]==null) {
//        		frequence[e.getValue()]=new LinkedList<Integer>();
//        	}
//        	frequence[e.getValue()].add(e.getKey());
//        }
        Arrays.sort(nums);
        List<Integer>[] frequence = new List[nums.length+1];
        int start = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]==nums[start]) continue;
            if (frequence[i-start]==null) frequence[i-start] = new ArrayList<>();
            frequence[i-start].add(nums[start]);
            start = i;
        }
        if (frequence[nums.length-start]==null) frequence[nums.length-start] = new ArrayList<>();
        frequence[nums.length-start].add(nums[start]);
     // 逆序（频次由高到低）取出元素
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length-1; i >= 0 && res.size() < k; --i) {
            if (frequence[i] != null) {
                res.addAll(frequence[i]);
            }
        }
    	
		return res;

    }
}
