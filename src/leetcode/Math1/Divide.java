package leetcode.Math1;

import org.junit.Test;

/**
 * 两数相除
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。

示例 1:

输入: dividend = 10, divisor = 3
输出: 3
示例 2:

输入: dividend = 7, divisor = -3
输出: -2
说明:

被除数和除数均为 32 位有符号整数。
除数不为 0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 * @author zxl
 *
 *100 10 20 40
 *
 */
public class Divide {
	@Test
	public void main() {
		System.out.println(divide(-2147483648, 1));
		
	}
	// 2 4  8 16 32..
    public int divide(int dividend, int divisor) {
    	if(dividend==0)return 0;
    	int ans=0;
    	boolean isAdd=false;//true相反
    	boolean isPositive=dividend>0;//是正数
    	if((isPositive&&divisor<0) || (!isPositive&&divisor>0)) {
    		isAdd=true;
    	}
    	//
    	if(isAdd) {
    		int t=dividend+divisor;
    		if(t==0)return -1;
    		if(t>0!=isPositive) {
    			return 0;
    		}
    		
    	}else {
    		int t=dividend-divisor;
    		if(t==0)return 1;
    		if(t<0==isPositive) {
    			return 0;
    		}
    	}
    	int oldDivisor=divisor;
    	if(isAdd) {//负数结果
    		int count=0;
    		boolean back=false;
    		do {
    			if(back) {//符号和开始不同， 折半后递减  
    				divisor >>=1;
        			count >>=1;	
        			dividend -=divisor;
        			ans -=count;
    			}else {//符号相同，继续
    				if(count==0) {
    					count=-1;
        			}else {
        				divisor <<=1;
            			count <<=1;
        			}
    				dividend +=divisor;
        			ans +=count;
        			if(ans>0)return Integer.MAX_VALUE;
    			}
    			if(dividend==0)break;
    			if(dividend+oldDivisor==0) {ans--; 
    			if(ans>0)return Integer.MAX_VALUE;
    			break;}
    			back=dividend>0!=isPositive;//判断符号是否改变
    		}while(!(!back && dividend+oldDivisor>0!=isPositive));
    		//最后向前的一次，不够减一个除数，退出
    		
    	}else {
    		int count=0;
    		boolean back=false;
    		do {
    			if(back) {//符号和开始不同， 折半后递减  
    				divisor >>=1;
        			count >>=1;	
        			dividend +=divisor;
        			ans -=count;
    			}else {//符号相同，继续
    				if(count==0) {
    					count=1;
        			}else {
        				divisor <<=1;
            			count <<=1;
        			}
    				dividend -=divisor;
        			ans +=count;
        			if(ans<0)return Integer.MAX_VALUE;
    			}
    			if(dividend==0)break;
    			if(dividend-oldDivisor==0) {
    				ans++;
    				if(ans<0)return Integer.MAX_VALUE;
    				break;}
    			back=dividend>0!=isPositive;//判断符号是否改变
    		}while(!(!back && dividend-oldDivisor>0!=isPositive));
    		//最后向前的一次，不够减一个除数，退出
    	}
//    	if(ans>Integer.MAX_VALUE)return Integer.MAX_VALUE;
    	return ans;
    }
}
