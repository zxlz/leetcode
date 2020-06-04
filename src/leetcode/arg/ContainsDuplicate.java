package leetcode.arg;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class ContainsDuplicate {
	public  void main() throws Exception {
		// TODO Auto-generated method stub
		Properties pro = new Properties();
		FileInputStream in = new FileInputStream("/Users/zxl/eclipse-workspace/leetcode/src/leetcode/arg.properties");
		pro.load(in);
		              
		              String numstr = pro.getProperty("nums");
		              
		int[] nums =  Arrays.stream(numstr.split(",")).mapToInt(Integer::valueOf).toArray();
		
				//int[] nums= {1,2,3,4,5,6};
		long start = System.currentTimeMillis();  
		boolean a=containsDuplicate(nums);
		long end = System.currentTimeMillis(); 
    	System.out.println(end-start);
    	System.out.println(a);
		
	}
	public boolean containsDuplicate(int[] nums) {
		 Set<Integer> set = new HashSet<>();
		for(int i=0;i<nums.length;i++) {
			if(!set.add(nums[i])) return true;
		};
		return false;
   }
	

	/**
	 * 精度不高，模糊算法
	 * @param nums
	 * @return
	 */
	public boolean containsDuplicate1(int[] nums) {
		boolean[] table = new boolean[256];
		if (nums.length < 1 )
            return false;
        for (int num : nums) {
            if (table[num & 255])
                return true;
            else
            	table[num & 255] = true;
        }
      
		return false;
   }
	
	
	
	
}
