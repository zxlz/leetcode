package leetcode.arg;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum-closest
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zxl
 *
 */
public class ThreeSumClosest {
	 public int threeSumClosest(int[] nums, int target) {
	    	int res=0;
	    	Arrays.sort(nums);
	    	for (int i = 0; i < nums.length-2; i++) {
				int l=i+1,r=nums.length-1;
				int temp=target-nums[i];
	    		while(l<r) {
	    			if(nums[l]+nums[r]>temp) {//大了
	    				r--;
	    			}else if (nums[l]+nums[r]<temp){
	    				l++;
	    			}else {
	    				return 0;
	    			}
	    			if(Math.abs(target - res) > Math.abs(temp - (nums[l]+nums[r])))
	                    res= nums[l]+nums[r]+nums[i];
	    		}
			}
			return res;
	 }
    public int threeSumClosest1(int[] nums, int target) {
		Arrays.sort(nums);
        int len = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int l = i + 1, r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(ans - target) ){
                    ans=sum;
                }
                //判断最大值
                int max = nums[i]+nums[r]+nums[r-1];
                if(target > max) {
                    if(Math.abs(target-max)<Math.abs(target-ans))
                        ans = max;
                    break;
                }
                //判断最小值
                int min = nums[i]+nums[l]+nums[l+1];
                if(target < min){
                    if(Math.abs(target-min) < Math.abs(target-ans))
                        ans = min;
                    break;
                }
                if (sum > target) {
                    while (l < r && nums[r] == nums[--r]) ;
                } else {
                    while (l < r && nums[l] == nums[++l]) ;
                }
            }
        }
        return ans;

    }
}
