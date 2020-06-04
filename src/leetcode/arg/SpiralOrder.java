package leetcode.arg;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
 * @author zxl
 *  1  2  3  4  5
 *  14 15 16 17 6
 *  13 20 19 18 7
 *  12 11 10 9  8
 *  
 *  
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix==null|| matrix.length==0)return new ArrayList<Integer>();
    	int length=matrix[0].length;
    	int height=matrix.length;
    	int size=length*height;
    	List<Integer> res = new ArrayList<Integer>(size);
    	int a=0,b=0,c=0,d=0;//上下左右 四条边已遍历次数
    	while(res.size()<size) {
    		//→→→→
    		for(int i=d;i<length-b;i++) {
    			res.add(matrix[a][i]);
    		}
            if(res.size()==size)return res;
    		a++;
    		//向下
    		for(int i=a;i<height-c;i++) {
    			res.add(matrix[i][length-d-1]);
    		}
            if(res.size()==size)return res;
    		b++;
    		//向左
    		for(int i=length-b-1;i>=d;i--) {
    			res.add(matrix[height-c-1][i]);
    		}
            if(res.size()==size)return res;
    		c++;
    		//向上
    		for (int i =height-c-1; i >=a; i--) {
				res.add(matrix[i][d]);
			}
            if(res.size()==size)return res;
            d++;
    		
    	}
    	return res;
    }
}
