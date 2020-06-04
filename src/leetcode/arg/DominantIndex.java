package leetcode.arg;

import org.junit.Test;

/**
 * 至少是其他数字两倍的最大数
 * @author zxl
 *在一个给定的数组nums中，总是存在一个最大元素 。

	查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
	
	如果是，则返回最大元素的索引，否则返回-1。
	
	示例 1:
	
	输入: nums = [3, 6, 1, 0]
	输出: 1
	解释: 6是最大的整数, 对于数组中的其他整数,
	6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
	
	nums 的长度范围在[1, 50].
	每个 nums[i] 的整数范围在 [0, 100].

 */
public class DominantIndex {
	
	@Test
	public  void main() {
		int[] arg = {0,0,2,3};
		dominantIndex(arg);
	}
	   public int dominantIndex(int[] nums) {
		   int[] order = {0,0};
		   int index=0;
		   for(int i=0;i<nums.length;i++) {
			   if (nums[i]>order[0]) {
				   order[1]=order[0];
				   order[0]=nums[i];
				   index=i;
			   }else if(nums[i]>order[1]){
				   order[1]=nums[i];
			   }
		   }
		   System.out.println(order[1]<<1);
		   if(order[1]<<1<=order[0]) {
			   return index;
		   }
		return -1;
	    }
}
