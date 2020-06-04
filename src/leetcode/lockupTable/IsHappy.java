package leetcode.lockupTable;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
编写一个算法来判断一个数是不是“快乐数”。

一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。

示例: 

输入: 19
输出: true
解释: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 * @author zxl
 *
 */
public class IsHappy {
    /**
     * 快乐数不会有循环，否则会产生循环
     * @param n
     * @return
     */
	public boolean isHappy(int n) {
//    	Set<Integer> set=new HashSet<Integer>();
//    	int i=n;
//    	while(i!=1) {
//    		n=i;
//    		while(n!=0) {
//    			int x=n%10;
//        		n /= 10;
//        		i += x*x;
//    		}
//    		if(!set.add(i))return false;
//    	}
//    	return true;
		
//    	int i=n;
//    	while(i!=1) {
//    		n=i;
//    		while(n!=0) {
//    			int x=n%10;
//        		n /= 10;
//        		i += x*x;
//    		}
//    		if(i==4)return false;
//    	}
//    	return true;
    	
//    	1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91, 94, 97, 100
    	boolean[] isHappy=new boolean[101];
    	isHappy[1]=true;isHappy[7]=true;isHappy[10]=true;isHappy[13]=true;isHappy[19]=true;
    	isHappy[23]=true;isHappy[28]=true;isHappy[31]=true;isHappy[32]=true;isHappy[44]=true;
    	isHappy[49]=true;isHappy[68]=true;isHappy[70]=true;isHappy[79]=true;isHappy[82]=true;
    	isHappy[86]=true;isHappy[91]=true;isHappy[94]=true;isHappy[97]=true;isHappy[100]=true;
    	int i=n;
    	while(i!=1) {
    		n=i;
    		i=0;
    		while(n!=0) {
    			int x=n%10;
        		n /= 10;
        		i += x*x;
    		}
    		if(i<101) {
    			return isHappy[i];
    		}
    	}
    	return true;
    }
}
