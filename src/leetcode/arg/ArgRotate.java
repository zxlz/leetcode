package leetcode.arg;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Properties;

public class ArgRotate {
	public  void main() throws Exception {
		Properties pro = new Properties();
		FileInputStream in = new FileInputStream("/Users/zxl/eclipse-workspace/leetcode/src/leetcode/arg.properties");
		pro.load(in);
		              
		              String numstr = pro.getProperty("nums");
		              
		int[] nums =  Arrays.stream(numstr.split(",")).mapToInt(Integer::valueOf).toArray();
		
				//int[] nums= {1,2,3,4,5,6};
		rotate(nums,11939);
		System.out.println(nums);
		
	}
	    public  void rotate(int[] nums, int k) {
	    	long start = System.currentTimeMillis();  
	    	int count=0;
	    	//有余数
	    	if(k % nums.length !=0){
	    		//奇数
	           if(nums.length % 2==1) {
	        	   offset(nums,0,k);
	           }else {//偶数
	        	   int center=nums.length/2;
	        	   int rk=k % nums.length;
	        	   int i=Math.abs(center-rk);
	        	   for(int j=0;i<center;i++) {
	        		   long start1 = System.currentTimeMillis();  
	        		   offset(nums,++j,k);
	        		   long end1 = System.currentTimeMillis(); 
	        		   System.out.println(end1-start1);
	        		   ++count;
	        		   
	        	   }
	        	   System.out.println("总长一半："+center);
	           }
	        }
	    	System.out.println("循环次数："+count);
	    	long end = System.currentTimeMillis(); 
	    	System.out.println(end-start);
	    }
	    /**
	     * 
	     * @param nums 待移动数组
	     * @param m 起点
	     * @param k 移动距离
	     */
	    public  void offset(int[] nums, int m,int k) {
	    	int  targetIndex;
            int temp2;
            int sourceIndex=m;
         int temp1= nums[sourceIndex];
         do {
             targetIndex= (sourceIndex+k) % nums.length;
             temp2 = nums[targetIndex];
             
             nums[targetIndex]=temp1;
             temp1 = temp2;
             sourceIndex=targetIndex;
         } while(sourceIndex!=m);
		      
	    }
	    
	    
}
