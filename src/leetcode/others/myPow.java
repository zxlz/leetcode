package leetcode.others;

/**
 * Pow(x, n)
实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
 * @author zxl
 *
 */
public class myPow {
    public double myPow(double x, int n) {
        if(n==0)return 1;
        double res=1;
        double cur=x;
        for(int i=n;i>0;i=i/2) {
        	if(i%2==1) {
        		res=res*cur;
        	}
        	cur=cur*cur;
        }
		return res;
        
    }
}
