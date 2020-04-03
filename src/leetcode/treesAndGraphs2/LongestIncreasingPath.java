package leetcode.treesAndGraphs2;

import org.junit.Test;

/**
 * 矩阵中的最长递增路径
给定一个整数矩阵，找出最长递增路径的长度。

对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。

示例 1:

输入: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
输出: 4 
解释: 最长递增路径为 [1, 2, 6, 9]。
示例 2:

输入: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
输出: 4 
解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * @author zxl
 *
 */
public class LongestIncreasingPath {
	@Test
	public void main() {
		longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}});
	}
	int rows;
	int columns;
    public int longestIncreasingPath(int[][] matrix) {
          if (matrix.length == 0) return 0;
    	 rows=matrix.length;
    	columns=matrix[0].length;
    	int[][] cache = new int[rows][columns];
    	int max=0;
    	for (int i = 0; i < rows; i++) {	
			for (int j = 0; j < columns; j++) {
				int x=dfs(i,j,matrix,cache);
				if(x>max)max=x;
			}
		}
		return max;

    }

	private int dfs(int i, int j, int[][] matrix, int[][] cache) {

		if(cache[i][j]>0)return cache[i][j];
		int top=0,left=0,down=0,right=0;
		if(i>0 && matrix[i-1][j]>matrix[i][j])
			top=dfs(i-1,j,matrix,cache);
		if(i<rows-1 && matrix[i+1][j]>matrix[i][j])
			down=dfs(i+1,j,matrix,cache);
		if(j>0 && matrix[i][j-1]>matrix[i][j])
			left=dfs(i,j-1,matrix,cache);
		if(j<columns-1 && matrix[i][j+1]>matrix[i][j])
			right=dfs(i,j+1,matrix,cache);
		cache[i][j]=Math.max(Math.max(top, down), Math.max(left, right)) +1;
		return cache[i][j];
	}
}
