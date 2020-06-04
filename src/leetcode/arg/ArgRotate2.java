package leetcode.arg;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Properties;

public class ArgRotate2 {
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
	   
	    
	    
	    public  void rotate(int[] arr,int k) {
	    	long start = System.currentTimeMillis();  
	        //确定移动次数
	        k %= arr.length;
	        //将整个数组逆序
	        reserve(arr,0,arr.length - 1);
	        //将前k个逆序
	        reserve(arr,0,k-1);
	        //从下标k到数组长度之间逆序
	        reserve(arr,k,arr.length - 1);
	        long end = System.currentTimeMillis(); 
	    	System.out.println(end-start);
	    }
	    //逆序
	    public  void reserve(int[] arr,int start,int end) {
	        while(start < end) {
	            int tmp = arr[end];
	            arr[end--] = arr[start];
	            arr[start++] = tmp;
	        }
	    }
}
