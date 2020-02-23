package leetcode.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 帕斯卡三角形
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * @author zxl
 *
 */
public class TriangleArray {
	@Test
	public void main() {
		long t=System.currentTimeMillis();
		int n=100000;
		while(n>0) {
//			ArrayList<Integer> obj = new ArrayList<Integer>() {{
//			    add(1);
//			    add(2); 
//			    add(3);
//			    add(4);
//			    add(5);
//			    add(2);
//			    add(6);
//			    add(224);
//			    add(652);
//			    add(2234);
//			    add(1);
//			    add(2); 
//			    add(3);
//			    add(4);
//			    add(5);
//			    add(2);
//			    add(6);
//			    add(224);
//			    add(652);
//			    add(2234);
//			    add(1);
//			    add(2); 
//			    add(3);
//			    add(4);
//			    add(5);
//			    add(2);
//			    add(6);
//			    add(224);
//			    add(652);
//			    add(2234);
//			    add(1);
//			    add(2); 
//			    add(3);
//			    add(4);
//			    add(5);
//			    add(2);
//			    add(6);
//			    add(224);
//			    add(652);
//			    add(2234);
//			}};
//			ArrayList<Integer> obj =new ArrayList<Integer>(Arrays.asList(1, 2,3,4,5,2,6,6,3,3,5,34,5,34,534,53,45,2,3,24,234,5,23,523,2));
			n--;
		}
		System.out.println(System.currentTimeMillis()-t);
		
	}
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> res=new ArrayList<List<Integer>>() {};
    	if(numRows==1) {
    		 res.add(new ArrayList<Integer>(Arrays.asList(1)));
    		 
    	}else {
    		res.add(new ArrayList<Integer>(Arrays.asList(1)));
    		res.add(new ArrayList<Integer>(Arrays.asList(1,1)));
    	}
    	
    	for(int n=3;n<=numRows;n++) {
    		res.add(new ArrayList<Integer>(n+1));
    		res.get(n-1).add(1);
    		for(int i=0;i<res.get(n-2).size()-1;i++) {
    			res.get(n-1).add(res.get(n-2).get(i)+res.get(n-2).get(i+1));
    		}
    		res.get(n-1).add(1);
    		
    	}
		return res;

    }
}
