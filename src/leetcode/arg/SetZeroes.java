package leetcode.arg;

/**
 * 矩阵置零
给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

输入: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5] 
]
输出: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
进阶:

一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
你能想出一个常数空间的解决方案吗？

 * @author zxl
 *       
 *
 *
 */
public class SetZeroes {
    public void setZeroes(int[][] matrix) {
    	boolean firstRowZero=false;
    	boolean firstColumnZero=false;
    	int rowLen=matrix.length;
    	int columnLen=matrix[0].length;
    	
    		for(int i:matrix[0]) {
        		if(i==0) {
        			firstRowZero=true;
        			break;
        		}
        	}
        	for(int[] i:matrix) {
        		if(i[0]==0) {
        			firstColumnZero=true;
        			break;
        		}
        	}
    	
    	
    	for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < columnLen; j++) {
				if(matrix[i][j]==0) {
					matrix[0][j]=0;
					matrix[i][0]=0;
				}
			}
		}
    	for(int j=1;j<columnLen;j++) {
    		if(matrix[0][j]==0) {
    			int i=rowLen;
    			while(i--!=0)matrix[i][j]=0;
    		}
    	}
    	for(int i=1;i<rowLen;i++) {
    		if(matrix[i][0]==0) {
    			int j=columnLen;
    			while(j--!=0)matrix[i][j]=0;
    		}
    	}
    	if(firstRowZero) {
    		for(int j=0;j<columnLen;j++) {
    			matrix[0][j]=0;
    		}
    	}
    	if(firstColumnZero) {
    		for (int i = 0; i < rowLen; i++) {
				matrix[i][0]=0;
			}
    	}
    	
    }
}
