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
    /**
     * 杨辉三角 II
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。


1
1  1
1  2  1
1  3  3  1
1  4  6  4  1
1  5  10 10 5  1
1  6  15 20 15 6 1
     */
    public List<Integer> getRow(int rowIndex) {
    	//return generate(rowIndex+1).get(rowIndex);
        rowIndex++;   //从0开始
       List<Integer> res = new ArrayList<Integer>();
       res.add(1);
       long tem = 1;
       for (int i = 1; i < rowIndex; i++)
       {
           tem = tem * (rowIndex - i) / i;
           res.add((int)tem);
       }
       return res;
    	

    }
}
