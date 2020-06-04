package leetcode.dynamicProgramming1;

import org.junit.Test;

/**
 *  不同路径
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？
提示：

1 <= m, n <= 100
题目数据保证答案小于等于 2 * 10 ^ 9
 * @author zxl
 * 1 2 3 4 5 6 7
 *   2 1 1 1 1 
 * 2 2 1
 *  d[i][j]
 *  d[i+1][j]+d[i][j+1]
 *  d[1][0]=1
 *  d[0][1]=1
 *   
 */
public class UniquePaths {
	@Test
	public void main() {
		System.out.println(uniquePaths(51, 9));
	}
	public int uniquePaths(int m, int n) { 
		int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];  
 
    }

//	int[][] cache=new int[100][100];
//    public int uniquePaths(int m, int n) {
//    	if(m==1|| n==1)return 1;
//    	if(cache[m][n]==0) {
//    		int i=uniquePaths(m-1,n)+uniquePaths(m,n-1);	
//       	    cache[n][m]=i;
//       	    return i;
//    	}else {
//    		return cache[m][n];
//    	}
//    	 
//    }
}
