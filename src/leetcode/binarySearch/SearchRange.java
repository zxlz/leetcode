package leetcode.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
 * @author zxl
 *
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
    	if(nums==null ||nums.length==0)return new int[]{-1,-1}; 
    	int left =0;int right=nums.length-1;
    	
    	//这种二分法内部至少有三个节点，里面找target可以继续用二分而不是前后遍历
    	while(left+1<right) {
    		int mid=left+(right-left)/2;
            // System.out.println(mid);
    		if((nums[mid]==target)){
    			int temp=mid;
    			while(++temp<nums.length&&nums[temp]==nums[temp-1]) {
    				
    			}
    			while(--mid>=0 && nums[mid]==nums[mid+1]) {
    				
    			}
    			return new int[]{++mid,--temp};
    		}else if(nums[mid]>target) {
    			right=mid;
    		}else {
    			left=mid;
    		}
    	}
        int i=-1;int j=-1;
        if(nums[left]==target && nums[right]==target){
            return new int[]{left,right};
        }else if(nums[right]==target){
            return new int[]{right,right};
        }else if(nums[left]==target){
            return new int[]{left,left};
        }
        
		return new int[]{i,j};

    }
}
