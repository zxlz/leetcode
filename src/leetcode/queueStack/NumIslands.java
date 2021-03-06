package leetcode.queueStack;

import java.util.Queue;

/**
 * 岛屿数量
给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

示例 1:

输入:
11110
11010
11000
00000

输出: 1
示例 2:

输入:
11000
11000
00100
00011

输出: 3
 * @author zxl
 *
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
    	if(grid==null||grid.length==0)return 0;
    	int res = 0;
    	for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j]=='1') {
					dfs(i,j,grid);
					res++;
				}
			}
		}
		return res;

    }

	private void dfs(int i, int j, char[][] grid) {

		grid[i][j]='0';
		if(i>0 && grid[i-1][j]=='1') {
			dfs(i-1,j,grid);
		}
		if(i<grid.length && grid[i+1][j]=='1') {
			dfs(i+1,j,grid);
		}
		if(j>0 && grid[i][j-1]=='1') {
			dfs(i,j-1,grid);
		}
		if(i<grid[0].length && grid[i][j+1]=='1') {
			dfs(i,j+1,grid);
		}
	}
    
}
