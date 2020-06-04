package leetcode.queueStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 完全平方数
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3 
解释: 12 = 4 + 4 + 4.
 * @author zxl
 *
 */
public class NumSquares {
	/**
	 * 
	 *       x
	 *   1     4  9 ...
	 * 1 4...  
	 * 
	 * @param n
	 * @return
	 */
    public int numSquares(int n) {
    	/**
    	 * 
拉格朗日四平方数和定理：
任何一个正整数都可以表示成不超过四个整数的平方之和。 
推论：满足四数平方和定理的数n（四个整数的情况），必定满足 n=4^a(8b+7)n
    	 */
    	 //先根据上面提到的公式来缩小n
        while(n % 4 == 0) {
            n /= 4;
        }
        //如果满足公式 则返回4
        if(n % 8 == 7) {
            return 4;
        }

    	List<Integer> squares = new ArrayList<Integer>();
    	for(int i=1,temp=1;temp<=n;i++,temp=i*i) {
    		squares.add(temp);
    	}
    	Queue<Integer> queue=new LinkedList<Integer>();
    	int count=0;
    	queue.offer(n);
    	
    	while(!queue.isEmpty()) {
    		int layerLength=queue.size();
        	while(layerLength>0) {
        		int cur=queue.poll();
        		for(int s:squares) {
        			int diff=cur-s;
        			if( diff>0) {
        				queue.add(diff);
        			}else if(diff==0) {
        				return count+1;
        			}
        		}
        		
        		layerLength--;
        	}
        	count++;
    	}
    	
    	
		return -1;

    }
}
