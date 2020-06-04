package leetcode.treesAndGraphs2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import javax.swing.plaf.SliderUI;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 被围绕的区域 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 
 * 示例:
 * 
 * X X X X X O O X X X O X X O X X 运行你的函数后，矩阵变为：
 * 
 * X X X X X X X X X X X X X O X X 解释:
 * 
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O'
 * 最终都会被填充为 'X'。 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 
 * @author zxl 从边界上的0 bfs,加cache，置'A',遍历所有非‘A’换为X
 *
 */
public class Solve {
	@Test
	public void main() {
		solve(new char[][] {{'O','O','O','O','O','O','O','O','X','O','O','O','O','O','X','O','O','O','O','O'},{'O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},{'X','O','O','X','O','X','O','O','O','O','X','O','O','X','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','X','O'},{'O','X','X','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','X','O','O','O','O','O','O','X','O','O','O','O','O','X','X','O'},{'O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','O','O','O','O','O','X','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','O'},{'O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','X','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O'},{'X','O','O','O','O','O','O','O','O','X','X','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O'},{'O','O','O','O','X','O','O','O','O','O','O','O','O','X','O','O','O','O','O','X'},{'O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','X','O','X','O','O'},{'O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','X','X','O','O','O','X','O','O','X','O','O','X'},{'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'}});
	}
	int rows;
	int columns;

	public void solve(char[][] board) {
		rows = board.length;
		if(rows<2)return;
		columns = board[0].length;
		if(columns<2)return;
		Queue<int[]> queue = new LinkedList<int[]>();
//    	Set<Character> visit = new HashSet<Character>();

//		boolean[][] visit = new boolean[rows][columns];
		for (int i = 0; i < rows; i++) {
			bfs(i, 0, board, queue);
			bfs(i, columns - 1, board, queue);
			// --
		}
		for (int i = 1; i < columns-1; i++) {
			bfs(0, i, board, queue);
			bfs(rows-1, i, board, queue);
			// --
		}
		for (int i = 0; i < rows; i++) {		
			for (int j = 0; j < columns; j++) {
				if(board[i][j]=='A') {
					board[i][j]='O';
				}else{
					board[i][j]='X';
				};
			}
		}
		
	}

	private void bfs(int i, int j, char[][] board, Queue<int[]> queue) {
		// TODO Auto-generated method stub
		if (board[i][j] == 'O' ) {// 没被访问的边界0，bfs
			// --bfs
			queue.offer(new int[] { i, j });
			board[i][j]='A';
			while (!queue.isEmpty()) {
				int[] COORD = queue.poll();
				int x = COORD[0];
				int y = COORD[1];
				
				
				if (x > 0 && board[x - 1][y] == 'O' ) {
					queue.offer(new int[] { x - 1, y });
					board[ x - 1][y]='A';
				}
					
				if (x < rows - 1 && board[x + 1][y] == 'O') {
					queue.offer(new int[] { x + 1, y });
					board[ x + 1][y]='A';
				}
					
				if (y > 0 && board[x][y - 1] == 'O' ) {
					queue.offer(new int[] { x, y - 1 });
					board[ x][y-1]='A';
				}
					
				if (y < columns - 1 && board[x][y + 1] == 'O') {
					queue.offer(new int[] { x, y + 1 });
					board[ x][y+1]='A';
				}	
			}
		}
	}
}
