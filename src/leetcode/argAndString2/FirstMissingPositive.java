package leetcode.argAndString2;

import org.junit.Test;

/**
 * 第一个缺失的正数
给定一个未排序的整数数组，找出其中没有出现的最小的正整数。

示例 1:

输入: [1,2,0]
输出: 3
 * @author zxl
 *
 */
public class FirstMissingPositive {
	@Test
	public void main() {
		firstMissingPositive(new int[] {1,1});
	}
    public int firstMissingPositive(int[] nums) {
//    	for (int i = 0; i < nums.length; i++) {
//			if(nums[i]>nums.length-1) {
//				nums[i]=1;
//			}else if(nums[i]==1) {
//				return 1;
//			}else if(nums[i]<0) {
//				nums[i]=1;
//			}
//		}
    	for (int i = 0; i < nums.length; i++) { 
    		//下标i+1是要检查的数 1-len
    		//   			   0-len-1
    		//每个下标i的数据存是否有i+1的数（也就是检测1-len）,全都有，就是len+1缺失
    		/**
    		 * 例：   -1 -3  -4  0  2  1   100 9  4  6
    		 * 处理后： 1  2   -4 4  -3 6  100 9  0  -1
    		 * 结果：3
    		 */
			while(nums[i]!=i+1 && nums[i]>0 && nums[i]<=nums.length) {
				int t=nums[nums[i]-1];
				nums[nums[i]-1]=nums[i];
				if(t==nums[i])break;//避免死循环
				nums[i]=t;
			}
		}
    	for(int i = 0; i < nums.length; i++) {
    		if(nums[i]==i+1) {
    			continue;
    		}else {
    			return i+1;
    		}
    	}
    	
		return nums.length+1;
    }
}
