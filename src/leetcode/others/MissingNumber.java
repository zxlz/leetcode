package leetcode.others;

/**
 * 缺失数字
给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

示例 1:

输入: [3,0,1]
输出: 2
示例 2:

输入: [9,6,4,2,3,5,7,0,1]
输出: 8
线性时间复杂度。你能否仅使用额外常数空间来实现?
 * @author zxl
 *
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
    	boolean[] tab=new boolean[nums.length+1];
    	for(int num:nums) {
    		tab[num]=true;
    	}
    	for(int i=0;i<tab.length;i++) {
    		if(!tab[i])return i;
    	}
		return 0;

    }
    public int missingNumber1(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret = ret ^ i ^ nums[i];
        }
        return ret ^ nums.length;
    }
}
