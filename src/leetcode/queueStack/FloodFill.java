package leetcode.queueStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 图像渲染
有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。

给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。

为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。

最后返回经过上色渲染后的图像。

示例 1:

输入: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
输出: [[2,2,2],[2,2,0],[2,0,1]]
解析: 
在图像的正中间，(坐标(sr,sc)=(1,1)),
在路径上所有符合条件的像素点的颜色都被更改成2。
注意，右下角的像素没有更改为2，
因为它不是在上下左右四个方向上与初始点相连的像素点。
注意:

image 和 image[0] 的长度在范围 [1, 50] 内。
给出的初始点将满足 0 <= sr < image.length 和 0 <= sc < image[0].length。
image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535]内。

		1 1 1
		1 1 0
		1 0 1
		
		2 2 2
		2 2 0
		2 0 1
 * @author zxl
 *
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    	
    	boolean[][] visited=new boolean[image.length][image[0].length];
    	Queue<int[]> queue=new LinkedList<int[]>();
    	
    	int oldColor=image[sr][sc];
    	image[sr][sc]=newColor;
    	queue.offer(new int[]{sr,sc});
    	while(!queue.isEmpty()) {
    		int[] cur=queue.poll();
    		if(!visited[cur[0]][cur[1]]) {//没被访问过
    			int r=cur[0];
        		int c=cur[1];
        		//上，没到边界，等于颜色，没被访问
        		if(r>0 && image[r-1][c]==oldColor && !visited[r-1][c]) {
        			image[r-1][c]=newColor;
        			queue.offer(new int[] {r-1,c});
        		}
        		//下
        		if(r<image.length-1 && image[r+1][c]==oldColor && !visited[r+1][c]) {
        			image[r+1][c]=newColor;
        			queue.offer(new int[] {r+1,c});
        		}
        		//左
        		if(c>0 && image[r][c-1]==oldColor && !visited[r][c-1]) {
        			image[r][c-1]=newColor;
        			queue.offer(new int[] {r,c-1});
        		}
        		//右
        		if(c<image[0].length-1 && image[r][c+1]==oldColor && !visited[r][c+1]) {
        			image[r][c+1]=newColor;
        			queue.offer(new int[] {r,c+1});
        		}
        		visited[r][c]=true;
    		}
    		
    	}
    	
		return image;
    }
    public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        int target = image[sr][sc];
        dfs(image, newColor, sr, sc, target);
        return image;
    }
    
    private void dfs(int[][] image, int newColor, int i, int j, int target) {
        if (image[i][j] == newColor || image[i][j] != target) {
            return;
        }
        image[i][j] = newColor;
        if (i > 0) {
            dfs(image, newColor, i - 1, j, target);
        }
        if (i < image.length - 1) {
            dfs(image, newColor, i + 1, j, target);
        }
        if (j > 0) {
            dfs(image, newColor, i, j - 1, target);
        }
        if (j < image[i].length - 1) {
            dfs(image, newColor, i, j + 1, target);
        }
    }
}
