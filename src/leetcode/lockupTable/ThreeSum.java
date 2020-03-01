package leetcode.lockupTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 三数之和
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。
 * @author zxl
 *
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
    	if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	for (int i = 0; i < nums.length; i++) {
			for(int j=i+1,k=nums.length-1;j<k;) {
				// System.out.println(nums[i]+"-"+nums[j]+"-"+nums[k]);
				int sum=nums[i]+nums[j]+nums[k];
				if(sum==0) {
					res.add(Arrays.asList(nums[i],nums[j],nums[k]));
					while( j<k && nums[j]==nums[j+1])j++;
                    while( j<k && nums[k]==nums[k-1])k--;
                    j++;
                    k--;
				}else if(sum>0) {
					k--;
				}else {
					j++;
				}
			}
            while( i<nums.length-1 && nums[i]==nums[i+1])i++;
		}
    	return res;
    }
}
