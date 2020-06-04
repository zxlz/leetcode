package leetcode.treesAndGraphs2;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  Friend Circles
班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。
如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。

给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，
表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。

示例 1:

输入: 
[[1,1,0],
 [1,1,0],
 [0,0,1]]
输出: 2 
说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
第2个学生自己在一个朋友圈。所以返回2。
 * @author zxl
 *其他解法：并查集
 */
public class FindCircleNum {
	//递归dfs
	public int findCircleNum(int[][] M) {
    	boolean[] visited = new boolean[M.length];
        int count = 0;
//        Queue<Integer> queue = new LinkedList<Integer>();
    	for (int i = 0; i < M.length; i++) {
			if(!visited[i]) {
				dfs(visited,M,i);
				count++;
			}
		}
		return count;
    }
	
	private void dfs(boolean[] visited, int[][] M, int i) {
		// TODO Auto-generated method stub
		for (int j = 0; j < M.length; j++) {
			visited[j]=true;
			if(M[i][j]==1 && !visited[j]) {
				dfs(visited, M, j);
			}
		}
	}

	//队列bfs
    public int findCircleNum1(int[][] M) {
    	boolean[] visited = new boolean[M.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
    	for (int i = 0; i < M.length; i++) {
			if(!visited[i]) {
				queue.offer(i);
				while(!queue.isEmpty()) {
						int x=queue.poll();//同学x的朋友圈
						visited[x]=true;
					for (int j = 0; j < M.length; j++) {
						if(M[x][j]==1 && !visited[j]) {//
							queue.offer(j);
						}
					}
					
				}
				count++;
			}
		}
		return count;
    }
}
