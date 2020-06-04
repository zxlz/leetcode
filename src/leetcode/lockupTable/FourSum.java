package leetcode.lockupTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 * @author zxl
 *
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	if (nums.length < 4) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	int last2sum=nums[nums.length-1]+nums[nums.length-2];
    	for(int x=0;x<nums.length-3;x++) {
    		 int min1=nums[x]+nums[x+1]+nums[x+2]+nums[x+3];
             if(min1>target){
                 break;
             }
            
             int max1=nums[x]+last2sum+nums[nums.length-3];
             if(max1<target){
                 continue;
             }
    		for (int i = x+1; i < nums.length-2; i++) {
    			int first2sum=nums[x]+nums[i];
    			int min=first2sum+nums[i+1]+nums[i+2];
                if(min>target){
                    continue;
                }
                
                int max=first2sum+last2sum;
                if(max<target){
                    continue;
                }
                
    			int target1=target-nums[i]-nums[x];
    			for(int j=i+1,k=nums.length-1;j<k;) {
    				// System.out.println(nums[i]+"-"+nums[j]+"-"+nums[k]);
    				int sum=nums[j]+nums[k];
    				if(sum==target1) {
    					res.add(Arrays.asList(nums[x],nums[i],nums[j],nums[k]));
    					while( j<k && nums[j]==nums[j+1])j++;
                        while( j<k && nums[k]==nums[k-1])k--;
                        j++;
                        k--;
    				}else if(sum>target1) {
    					k--;
    				}else {
    					j++;
    				}
    			}
                while( i<nums.length-2 && nums[i]==nums[i+1])i++;
    		}
    		while( x<nums.length-4 && nums[x]==nums[x+1])x++;
    	}
    	
    	return res;
    }
}
