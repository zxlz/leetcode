package leetcode.lockupTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 存在重复元素 III
给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。

示例 1:

输入: nums = [1,2,3,1], k = 3, t = 0
输出: true
 * @author zxl
 *
 */
public class ContainsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	
    	if(k>=nums.length||k<=0)return false;
    	int fast=1;
    	int slow=0;
    	while(fast<nums.length) {
    		if(Math.abs((long)nums[slow]-nums[fast])<=t )return true;
    		if(fast<=slow+k) {
    			fast++;
    		}else {
    			slow++;
    			fast=slow+1;
    		}
    	}
		return false;
    	
    }
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        List<Integer> indics = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            indics.add(i);
        }
        sort(nums, indics, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j < nums.length){
                long val1 = nums[i];
                long val2 = nums[j];
                if (Math.abs(val1 - val2) > t)
                    break;

                int index1 = indics.get(i);
                int index2 = indics.get(j);
                if (Math.abs(index1 - index2) > k) {
                    j++;
                    continue;
                }
                return true;
            }
        }
        return false;
    }

    private void sort(int[] vals, List<Integer> indics, int begin, int end) {
        if (begin < end){
            int i = begin;
            int j = end;
            int key = vals[begin];
            int index = indics.get(begin);
            while (i < j){
                while (i < j && vals[j] < key)
                    j--;
                if (i < j){
                    vals[i] = vals[j];
                    indics.set(i, indics.get(j));
                    i++;
                }
                while (i < j && vals[i] > key)
                    i++;
                if (i < j){
                    vals[j] = vals[i];
                    indics.set(j, indics.get(i));
                    j--;
                }
            }
            vals[i] = key;
            indics.set(i, index);
            sort(vals, indics, begin, i - 1);
            sort(vals, indics, i + 1, end);
        }
    }
}
