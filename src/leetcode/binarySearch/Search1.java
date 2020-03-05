package leetcode.binarySearch;

import org.junit.Test;

/**
 * 搜索旋转排序数组
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。
 * @author zxl
 *
 */
public class Search1 {
	@Test
	public void main() {
		search(new int[]{1,3},3);
	}
    public int search(int[] nums, int target) {
    	int left=0;
    	int right=nums.length-1;
    	while(left<=right) {
    		int mid = (left + right) >>> 1;
    		
    		if(nums[mid]>target) {
    			//右边递增或者右边最大的也比target小
    			if(nums[right]>nums[mid] || nums[right]<target) {
    				right=mid-1;
    			}else {
    				left=mid+1;
    			}
    		}else if(nums[mid]<target) {
    			//右边递增或者右边最大的也比target小
    			if(nums[right]>nums[mid] && nums[right]<target) {
    				right=mid-1;
    			}else {
    				left=mid+1;
    			}
    			
    		}else {
    			return mid;
    		}
    	}
		return -1;
    }
}
