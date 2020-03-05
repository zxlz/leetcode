package leetcode.binarySearch;

/**
 * 寻找旋转排序数组中的最小值
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

请找出其中最小的元素。

你可以假设数组中不存在重复元素。
 * @author zxl
 *
 */
public class FindMin {
	/**
	 *     6
	 *   5 
	 * 4        
	 *         		   3
	 *         		2
	 *          1  
 	 *        0
 	 *   left和right肯定包括了最低点，mid要么在左侧，要么再右侧， 
 	 *   如果在左侧，mid肯定大于right
 	 *   如果在右侧，mid肯定小于left 
 	 *        
	 * @param nums
	 * @return
	 */
	public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
			return -1;

		int left = 0, right = nums.length;
		while (left < right) {
			int mid = left + (right - left) / 2;
			 if (nums[mid]>nums[right]) {
				left=mid+1;
			} else if(nums[mid]<nums[left]){
				right = mid;
			}else {
				return nums[mid];
			}
		}

		return nums[left];
    }
}
