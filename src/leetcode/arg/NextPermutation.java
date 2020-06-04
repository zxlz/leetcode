package leetcode.arg;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
    	int i = nums.length-1;
    	while (i>0 && nums[i]<=nums[i-1]) {//从末尾往前找到升序转折点
			i--;
		}
    	//i 最高 或 到0位
    	if(i>0) {
    		int a=i-1;
        	int temp = nums[i-1];//i-1和尾段的第一个比temp大的交换，没有就最后一个
        	//i=0
        	while(i< nums.length && nums[i]>=temp) {
        		i++;
        	}
        	//i超出1 或第一个小
        	swap(nums,a,--i);
        	i=a+1;
    	}

    	reverse(nums,i);
    	
    }
    
    private void reverse(int[] nums, int i) {

		int l=i,r=nums.length-1;
		while(l<r) {
			swap(nums, l++, r--);
		}
	}

	
	private void swap(int[] nums, int a, int b) {
		int t=nums[a];
    	nums[a]=nums[b];
    	nums[b]=t;
	}
    
}
