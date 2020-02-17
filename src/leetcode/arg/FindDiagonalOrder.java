package leetcode.arg;
/**
 * 对角线遍历
给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

输出:  [1,2,4,7,5,3,6,8,9]

0      00
1    01  10 
2   20 11 02
3    12  21
4      22

0      00
1    01  10 
2   20 11 02
3  03 12 21 30
4   31 22 13
5    32  23
6      33
峰值前
索引和为{偶}数，向上遍历，{横}索引值递减，遍历值依次是(x,0),(x-1,1),(x-2,2),…,(0,x)
												 c       c       c     c  
索引和为{奇}数，向下遍历，{纵}索引值递减，遍历值依次是(0,y),(1,y-1),(2,y-2),…,(y,0)
                                               c    c        c           c

0:              (00)
1:            (01)(10)
2:          (20)(11)(02)
3:        (03)(12)(21)(30)
4:      (40)(31)(22)(13)(04)
5:    (05)(14)(23)(32)(41)(50)
6:  (60)(51)................(06)

 * @author zxl
 *
 */
public class FindDiagonalOrder {
	 public int[] findDiagonalOrder(int[][] matrix) {
		 if(matrix==null||!( matrix.length>0 && matrix[0].length>0)){
	            return null;
	        }
		  int rl = matrix.length;
		  int cl = matrix[0].length;
		  int k = 0;
		  int[] res= new int[rl*cl];
		 for (int i = 0; i < rl + cl - 1; ++i) {
	            int low =  (i - cl + 1)>0?(i - cl + 1):0;
	            int high = (rl - 1)<i?(rl - 1):i;
	            if (i % 2 == 0) {
	                for (int j = high; j >= low; --j) {
	                    res[k++] = matrix[j][i - j];
	                }
	            } else {
	                for (int j = low; j <= high; ++j) {
	                    res[k++] = matrix[j][i - j];
	                }
	            }
	        }
		 
		return res;
	    }
	 
	 
	 /**
	  * 最快
	  * @param matrix
	  * @return
	  */
	 public int[] findDiagonalOrder1(int[][] matrix) {
	        if(null == matrix || matrix.length == 0 || matrix[0].length == 0) {
	            return new int[0];
	        }
	        int m = matrix.length;
	        int n = matrix[0].length;
	        if(m == 1) {
	            return matrix[0];
	        }
	        int[] result = new int[m * n];
	        if(n == 1) {
	            for(int i = 0;i < m; i++) {
	                result[i] = matrix[i][0];
	            }
	            return result;
	        }
	        
	        int x1 = 0;
	        int y1 = 0;
	        int x2 = 0;
	        int y2 = 0;
	        int pos = 0;
	        boolean upDir = true;
	        while(y1 < n) {
	            pos = setArr(matrix, result, x1, y1, x2, y2, pos, upDir);
	            upDir = !upDir;
	            if(x1 == m - 1) {
	                y1++;
	            } else {
	                x1++;
	            }
	            if(y2 == n - 1) {
	                x2++;
	            } else {
	                y2++;
	            }
	        }
	        return result;
	    }
	    
	    private int setArr(int[][] matrix, int[] arr, int x1, int y1, int x2, int y2, int pos, boolean upDir) {
	        if(!upDir) {
	            while(y2 >= y1) {
	                arr[pos] = matrix[x2][y2];
	                x2++;
	                y2--;
	                pos++;
	            }
	        } else {
	            while(y1 <= y2) {
	                arr[pos] = matrix[x1][y1];
	                x1--;
	                y1++;
	                pos++;
	            }
	        }
	        return pos;
	    }
}
