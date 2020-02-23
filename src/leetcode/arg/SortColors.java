package leetcode.arg;

public class SortColors {
	/**
	 * 三路快速排序方法
设置三个 lt, gt, i 定义：nums[0...lt] == 0，nums[lt+1...i-1] = 1，nums[gt...n-1] == 2，遍历一遍改数列保持这个定义。


	 * @param nums
	 */
    public void sortColors(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int i=0;
        int temp;
        while(i<=right) {
        	if(nums[i]==0) {
        		temp=nums[left];
        		nums[left]=nums[i];
        		nums[i]=temp;
        		i++;
        		left++;
        	}else if(nums[i]==2) {
        		temp=nums[right];
        		nums[right]=nums[i];
        		nums[i]=temp;
        		
        		right--;
        	}else {
        		i++;
        	}
        }
    }
}
