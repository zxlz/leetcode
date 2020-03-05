package leetcode.binarySearch;

import org.junit.Test;

/**
 * 有效的完全平方数
给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。

说明：不要使用任何内置的库函数，如  sqrt。

示例 1：

输入：16
输出：True
 * @author zxl
 *
 */
public class IsPerfectSquare {
	@Test
	public void main() {
		isPerfectSquare(2147395600);//46340
	}
    public boolean isPerfectSquare(int num) {
    	int small=0;
    	int large=num>>1;
    	int max=46340;
    	while(max<large) {
    		large=max;
    	}
        if(num==1)return true;
    	while(small<=large) {
    		int mid=small+(large-small)/2;
    		long temp=mid*mid;
    		if(temp==num) {
    			return true;
    		}else if(temp<num) {
    			small=mid+1;
    		}else {
    			large=mid-1;
    		}
    	}
		return false;

    }
}
