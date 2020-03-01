package leetcode.queueStack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 01 矩阵
给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。

两个相邻元素间的距离为 1 。

示例 1:
输入:

0 0 0
0 1 0
0 0 0
输出:

0 0 0
0 1 0
0 0 0
示例 2:
输入:

0 0 0
0 1 0
1 1 1
输出:

0 0 0
0 1 0
1 2 1
注意:

给定矩阵的元素个数不超过 10000。
给定矩阵中至少有一个元素是 0。
矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 * @author zxl
 *
 */
public class UpdateMatrix {
	 public int[][] updateMatrix(int[][] matrix) {
	        int m = matrix.length ;
	        int n = matrix[0].length;
	        boolean[][] visit=new boolean[m][n];
	        for(int i = 0;i < m; i++){
	            for(int j = 0; j < n; j++){
	                matrix[i][j] = dfs(matrix,visit, i, j);
	                visit[i][j]=true;
	            }
	        }
	       return matrix;     
	    }
	    public  int dfs(int[][] matrix,boolean[][] visit, int i, int j){
	        int m = matrix.length ;
	        int n = matrix[0].length;
	         if(i<0 || i>m-1 || j < 0 || j > n-1) return 9999;
	         //如果自己是0
	         if(matrix[i][j] == 0) return 0;
	         //如果周围有0；
	         if(i > 0 && matrix[i-1][j] == 0) return 1;
	         if(j < n-1 && matrix[i][j+1] == 0) return 1;
	         if(i < m-1 && matrix[i+1][j] == 0) return 1;
	          if(j>0 && matrix[i][j-1] == 0) return 1;
	        
	        int left,bottom,right,top;
	        left=top=9999;
	        //把上和左的赋值,dfs时左和上没值没关系
	        /**
	         * 检查区域是已i，j点为中心的十字的左上部分和右下部分，  如果右上部分和左下部分有近0距离，则在左上部分和 右，下边界线也可获得，
	         * 省掉很多遍历
	         */
	        
	        if(i > 0 && visit[i-1][j]){
	            top = matrix[i-1][j];
	        }
	        if(j> 0 && visit[i][j-1]){
	            left = matrix[i][j-1];
	        }
	        bottom = dfs(matrix,visit,i+1, j);
	        right = dfs(matrix,visit,i,j+1);
	        return Math.min(Math.min(left, right), Math.min(top,bottom))+1; 
	    }
	    
    public int[][] updateMatrix1(int[][] matrix) {
    	// visited=new boolean[matrix.length][matrix[0].length] ;
    	Queue<int[]> queue = new LinkedList<>();
    	int max=matrix.length+matrix[0].length;
    	for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j]==0	) {
					queue.add(new int[]{i, j});
				}else {
					matrix[i][j]=max;
				}
			}
		}
    	//bfs
    	while(!queue.isEmpty()) {
    		int[] c=queue.poll();
    		int value=matrix[c[0]][c[1]];
    		if(c[0]>0 && matrix[c[0]-1][c[1]]>value+1) {//判断是否需要更新上邻节点
    			matrix[c[0]-1][c[1]]=value+1;
    			queue.offer(new int[] {c[0]-1,c[1]});//刷新了节点值，也要重新更新节点周围
    		}
    		if(c[0]<matrix.length-1 && matrix[c[0]+1][c[1]]>value+1) {
    			matrix[c[0]+1][c[1]]=value+1;
    			queue.offer(new int[] {c[0]+1,c[1]});
    		}
    		if(c[1]>0 && matrix[c[0]][c[1]-1]>value+1) {
    			matrix[c[0]][c[1]-1]=value+1;
    			queue.offer(new int[] {c[0],c[1]-1});
    		}
    		if(c[1]<matrix[0].length-1 && matrix[c[0]][c[1]+1]>value+1) {
    			matrix[c[0]][c[1]+1]=value+1;
    			queue.offer(new int[] {c[0],c[1]+1});
    		}
    		
    	}
    	
		return matrix;
    }
	
}
