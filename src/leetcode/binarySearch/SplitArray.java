package leetcode.binarySearch;

import org.junit.Test;

/**
 * 分割数组的最大值
给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。

注意:
数组长度 n 满足以下条件:

1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
示例:

输入:
nums = [7,2,5,10,8]
m = 2

输出:
18

解释:
一共有四种方法将nums分割为2个子数组。
其中最好的方式是将其分为[7,2,5] 和 [10,8]，
因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * @author zxl
 *
 */
public class SplitArray {
	@Test
	public void main() {
		//splitArray(new int[] {1,2147483647}, 2);
		splitArray(new int[] {7,2,5,10,8}, 2);
	}
	//32 31   18 17 - 15 14   10  midSum
	// 1  2   2  3     3  5    5  tempM
	//
	 public int splitArray(int[] nums, int m) {
	    	long sumOfMinM=0;
	    	long sumOfMaxM=0;//最大分组时的
	    	for (int i = 0; i < nums.length; i++) {
	    		sumOfMaxM +=nums[i];
	    		if(sumOfMinM<nums[i])sumOfMinM=nums[i];
			}
	    	long ans = sumOfMaxM;
	    	while (sumOfMinM<sumOfMaxM) {
	    		long midSum=sumOfMinM+(sumOfMaxM-sumOfMinM)/2;//
				int tempM=findMOfSum(nums,midSum);//和小于midSum 的最大数组分组数
				if(tempM>m) {//由上图，tempM大了，要降低，也就是midSum要变大
					sumOfMinM=midSum+1;
				}else if(tempM<=m)  {
					ans=Math.min(midSum, ans);
					sumOfMaxM=midSum;
				}
			}
			return (int)ans;

	    }

	 //子数组和不超过sumOfMidM时需要的数组分组
	private int findMOfSum(int[] nums, long midSum) {

		long sum=0;
		int count=1;
		for(int i=0;i<nums.length;i++) {
			if((sum+=nums[i])>=midSum) {
				if(sum==midSum) {
					sum=0;
					if(i<nums.length-1)count++;
				}else {
					sum=nums[i];
					count++;
				}
				
				
			}
		}
		return count;
	}
}
