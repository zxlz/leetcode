package leetcode.others1;

import org.junit.Test;

/**
 * 695. 岛屿的最大面积
给定一个包含了一些 0 和 1 的非空二维数组 grid 。

一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。
你可以假设 grid 的四个边缘都被 0（代表水）包围着。

找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 * @author zxl
 *
 */
public class MaxAreaOfIsland {
	@Test
	public void main() {
		maxAreaOfIsland(new int[][] {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}});
		System.out.println();
	}
	int res = 0;
	int rows;
	int cols;
    public int maxAreaOfIsland(int[][] grid) {
    	 rows=grid.length;
    	 cols=grid[0].length;
    	for (int i = 0; i <rows; i++) {
			for (int j = 0; j < cols; j++) {
				if(grid[i][j]==1) {
					res=Math.max(res, dfs(grid,i,j));
				}
			}
		}
		return res;

    }
	private int dfs(int[][] grid, int i, int j) {
		int c=1;
		grid[i][j]=0;
		if(i>0 && grid[i-1][j]==1) {
			c+=dfs(grid,i-1,j);
		}
		if(i<rows-1 && grid[i+1][j]==1) {
			c+=dfs(grid,i+1,j);
		}
		if(j>0 && grid[i][j-1]==1) {
			c+=dfs(grid,i,j-1);
		}
		if(j<cols-1 && grid[i][j+1]==1) {
			c+=dfs(grid,i,j+1);
		}
		return c;
	}
}
