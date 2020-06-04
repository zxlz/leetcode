package leetcode.design;

import java.util.Random;

/**
 * 打乱一个没有重复元素的数组。

示例:

// 以数字集合 1, 2 和 3 初始化数组。
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
solution.shuffle();

// 重设数组到它的初始状态[1,2,3]。
solution.reset();

// 随机返回数组[1,2,3]打乱后的结果。
solution.shuffle();
 * @author zxl
 *
 */
public class ShuffleAnArray {
	int[] originate;
	int temp;
	 Random random = new Random();
    public ShuffleAnArray(int[] nums) {
    	 originate=nums;
    	
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
		return originate;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
       
    	int[] res=new int[originate.length];
    	System.arraycopy(originate, 0, res, 0, originate.length);
    	for(int i=0;i<res.length;i++) {
    		int m=i+random.nextInt(res.length-i);
    		temp=res[i];
    		res[i]=res[m];
    		res[m]=temp;
    	}
		return res;
    }
}
