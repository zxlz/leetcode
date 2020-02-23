package leetcode.arg;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	/**
	 * 两数之和
	 * 无序数组
	 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
	 * @param nums
	 * @param target
	 * @return
	 * @throws Exception
	 * 
	 * 
	 * 两数之和 II - 输入有序数组
	 * 二分搜索法
	 * 双索引（对撞指针）
	 * 
	 */
	public int[] twoSum(int[] nums, int target)  {
        Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[] { map.get(complement), i };
                }
                map.put(nums[i], i);
            }
            return null ; 
    }
//	 public int[] twoSum1(int[] nums, int target) {
//	       int max = 2047 ; // 0111 1111 1111
//	    	int[] test = new int[max+1] ; 
//	    	for(int i=0 ; i<nums.length ; i++) {
//	    		int temp = target-nums[i]; 
//	    		int pos = test[temp & max] ; //与运算
//	    		if(pos!=0) return new int[] {pos-1 , i } ;
//	    		test[nums[i]&max] = i + 1;
//	    	}
//	        return null ; 
//	    }
}
