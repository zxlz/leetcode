package leetcode.lcp;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

/**
 * LCP 3. 机器人大冒险
力扣团队买了一个可编程机器人，机器人初始位置在原点(0, 0)。小伙伴事先给机器人输入一串指令command，机器人就会无限循环这条指令的步骤进行移动。指令有两种：

U: 向y轴正方向移动一格
R: 向x轴正方向移动一格。
不幸的是，在 xy 平面上还有一些障碍物，他们的坐标用obstacles表示。机器人一旦碰到障碍物就会被损毁。

给定终点坐标(x, y)，返回机器人能否完好地到达终点。如果能，返回true；否则返回false。

 

示例 1：

输入：command = "URR", obstacles = [], x = 3, y = 2
输出：true
解释：U(0, 1) -> R(1, 1) -> R(2, 1) -> U(2, 2) -> R(3, 2)。
示例 2：

输入：command = "URR", obstacles = [[2, 2]], x = 3, y = 2
输出：false
解释：机器人在到达终点前会碰到(2, 2)的障碍物。
示例 3：

输入：command = "URR", obstacles = [[4, 2]], x = 3, y = 2
输出：true
解释：到达终点后，再碰到障碍物也不影响返回结果。
 

限制：

2 <= command的长度 <= 1000
command由U，R构成，且至少有一个U，至少有一个R
0 <= x <= 1e9, 0 <= y <= 1e9
0 <= obstacles的长度 <= 1000
obstacles[i]不为原点或者终点
 * @author zxl
 *
 */
public class Robot {
	@Test
	public void main() {
		
//		System.out.println(robot("UR", new int[][] {{0, 2}, {4, 4}, {2, 4}, {3, 8}, {6, 5}, {6, 10}, {8, 4}, {7, 1}},197, 197));
//		System.out.println(robot("URR", new int[][] {},3, 2));
		System.out.println(robot("URRURRR", new int[][] {
			{7, 7}, {0, 5}, {2, 7}, {8, 6}, {8, 7}, {6, 5}, {4, 4}, {0, 3}, {3, 6}},4915,1966));
	}
    public boolean robot(String command, int[][] obstacles, int x, int y) {
    	int[][] run = new int[command.length()][2];
    	int[] u=new int[] {0,1};
    	int[] r=new int[] {1,0};
    	int roundX =0;
    	int roundY =0;
    	
    	for (int i = 0; i < command.length(); i++) {
			if(command.charAt(i)=='U') {
				run[i]= u;
				roundY++;
			}else {
				run[i]=r;
				roundX++;
			}
		}
    	
    	Arrays.sort(obstacles, (o1,o2)->{
    		if(o1[0]==o2[0])return o1[1]-o2[1];
    		return o1[0]-o2[0];	
    	});
    	
    	int curX=0;
    	int curY=0;	
    	int step=0;
    	int i=0;
    	// int temp=0;
    	boolean end = obstacles.length==0;
    	while(curX<=x && curY<=y ) {
    		if(step==0 && end) {
    			curX +=roundX;
	    		curY +=roundY;
	    		
	    		if(curX>x||curY>y) {
	    			curX -=roundX;
		    		curY -=roundY;
		    		curX +=run[0][0];
    	    		curY +=run[0][1];
		    		step=1;
		    		// temp=1;
	    		}
	    		if(curX==x && curY==y)return true;
    		}else {
    			 	
    	    		
    	    		curX +=run[step][0];
    	    		curY +=run[step][1];
                    step++;
    	    		if(step==run.length)step=0;
    	    		// temp= step;
    	    		if(curX==x && curY==y)return true;
    	    		if(!end) {
    	    			
    	        		if(curX>obstacles[i][0] || curY>obstacles[i][1]) {
    	        			i++;
    	        			if(i==obstacles.length) {
    	        				end=true;continue;
    	        			}
    	        		}
    	        		if(obstacles[i][0]==curX && obstacles[i][1]==curY)return false;
    	    		}
    		}
    		
    		
    		
    	}
    	
    	return false;
    }
}
