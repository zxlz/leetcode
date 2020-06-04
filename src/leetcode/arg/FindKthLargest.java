package leetcode.arg;

import java.util.Arrays;

/**
 * 数组中的第K个最大元素
 * @author zxl
 *
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
//    	for (int i = 0; i < nums.length; i++) {
//    		for(int j=i;j<nums.length;j++ ) {
//    			if(nums[j]>nums[i]) {
//    				int temp=nums[i];
//    				nums[i]=nums[j];
//    				nums[j]=temp;
//    			}
//    		}
//    		if(k==i+1) return nums[i];
//		}
//    	return -1;
    
    	 Arrays.sort(nums);
		return nums[nums.length-k];

    }
}
