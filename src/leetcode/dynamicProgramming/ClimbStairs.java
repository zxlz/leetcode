package leetcode.dynamicProgramming;

import org.junit.Test;

/**
 * 爬楼梯
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
 * @author zxl
 *
 */
public class ClimbStairs {
	@Test
	public void main() {
		long a=System.currentTimeMillis();
		System.out.println(climbStairs(44));
		System.out.println(System.currentTimeMillis()-a);
	}
    /**
     * f(3)=f(2)+f(1) 
     *  
     * @param n
     * @return
     * 递归造成了大量的重复子问题
//	public int climbStairs(int n) {
//		if(n<=0)return 0;
//		if(n==1||n==2||n==3)return n;
//        if(n==4){
//            return 5;
//        }else if(n==5){
//        	return 8;
//        }else{
//            return climbStairs(n-1)+climbStairs(n-2);
//        }
//		
//    }
     /**
      * 尾递归
      * @param n
      * @return
      */
 	public int climbStairs(int n) {
		
		return climbStairs(n,1,2);
     }
     public int climbStairs(int n,int a,int b) {
 		if(n<=2)return a;
          return climbStairs(n-1,b,b+a);
      	
      }
     
}
