package leetcode.lcp;

import org.junit.Test;

/**
 * 你有一块棋盘，棋盘上有一些格子已经坏掉了。你还有无穷块大小为1 * 2的多米诺骨牌，你想把这些骨牌不重叠地覆盖在完好的格子上，请找出你最多能在棋盘上放多少块骨牌？这些骨牌可以横着或者竖着放。

 

输入：n, m代表棋盘的大小；broken是一个b * 2的二维数组，其中每个元素代表棋盘上每一个坏掉的格子的位置。

输出：一个整数，代表最多能在棋盘上放的骨牌数。

 

示例 1：

输入：n = 2, m = 3, broken = [[1, 0], [1, 1]]
输出：2
解释：我们最多可以放两块骨牌：[[0, 0], [0, 1]]以及[[0, 2], [1, 2]]。
限制：

1 <= n <= 8
1 <= m <= 8
0 <= b <= n * m

 * @author zxl
 *
 */
public class Domino {
	@Test
	public void main() {
		
		
//		System.out.println(domino(2, 3, new int[][]{{1, 0}, {1, 1}}));
		System.out.println(domino(8, 8, new int[][]{{0, 1}, {2, 0}, {4, 3}, {4, 7}, {5, 4}, {3, 4}}));
	}
	//匈牙利算法/二分图匹配
	private int colLen;
	private int rowLen;
	private boolean[][] bad ;
	private boolean[][] existLink =new boolean[8][8];
	private int[] link=new int[1<<6];
	private int[][] base = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

	public int domino(int n, int m, int[][] broken) {
		if (broken.length == 0) {
			return n * m >> 1;
		}
		colLen=m;
    	rowLen=n;
    	bad = new boolean[n][m];
		for (int i = 0; i < broken.length; i++) {
			bad[broken[i][0]][broken[i][1]]=true;
		}
    	int res = 0;
    	
    	for (int i = 0; i < rowLen; i++) {
			for (int j = i%2; j < colLen; j+=2) {//遍历 表1
				boolean visited[][]=new boolean[rowLen][colLen];
//				System.out.println("尝试表1的："+i+"=="+j);
				if(!existLink[i][j]&&!bad[i][j] && find(visited,i,j)) {//加入点i，j  找增广路径
					res++;
				}
			}
		}
    	return res;
		
	}
	private boolean find(boolean[][] visited, int i, int j) {
		visited[i][j]=true;
		existLink[i][j]=true;
		for (int[] b:base) {
			 int curI=i+b[0];
			 int curJ=j+b[1];
			 if(curI<0 || curJ<0 || curI>=rowLen || curJ>=colLen)continue;
			 if(!bad[curI][curJ] && !visited[curI][curJ]) { //不是坏的，没有访问过的
				 visited[curI][curJ]=true;
				 int v2= curI * colLen + curJ;
				 if(!existLink[curI][curJ] || (find(visited,link[v2]/colLen,link[v2]%colLen))) {
					 link[v2]=i * colLen + j;
					 existLink[curI][curJ]=true;
					 return true;
				 }
			 }
			 
		}
		return false;
	}
	//回溯------------------------------------------------
//	private int colLen;
//	private int rowLen;
//	private boolean[][] visted ;
//    public int domino1(int n, int m, int[][] broken) {
//    	if (broken.length == 0) {
//			return n * m >> 1;
//		}
//    	colLen=m;
//    	rowLen=n;
//    	visted = new boolean[n][m];
//    	for (int i = 0; i < broken.length; i++) {
//				visted[broken[i][0]][broken[i][1]]=true;
//		}
//    	
//    	
//		return dfs(0,0,0);
//    }
//
//	private int dfs(int row, int col, int depth) {
//
//		
//		if(col>=colLen) {
//			row++;col=0;
//		}
//		if(row>=rowLen)return depth;
//		//1.从左到右，找到空点
//		while(visted[row][col]) {
//			if(col+1<colLen) {
//				col++;
//			}else if(row+1<rowLen){
//				row++;
//				col=0;
//			}else {
//				return depth;//遍历完
//			}
//		}
//		visted[row][col]=true;
//		//2.找到右/下空白，填上，递归
//		
//		int count1=0;
//		//左->右
//		if(col+1 <colLen && !visted[row][col+1]) {
//			visted[row][col+1]=true;
//			count1=dfs(row,col+2,depth+1);
//			visted[row][col+1]=false;
//		}
//		
//		//下
//		int count2=0;
//		if(row+1 <rowLen && !visted[row+1][col]) {
//			visted[row+1][col]=true;
//			count2=dfs(row,col+1,depth+1);
//			visted[row+1][col]=false;
//		}
//		
//		visted[row][col]=false;
//		if(count1==0 && count2==0) {
//			return dfs(row,col+2,depth);
//		}else {
//			return Math.max(count1, count2);
//		}
//		
//		
//	}

}
