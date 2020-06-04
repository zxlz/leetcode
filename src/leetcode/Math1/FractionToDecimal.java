package leetcode.Math1;

import java.util.HashMap;

import org.junit.Test;

/**
 * 分数到小数
给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。

如果小数部分为循环小数，则将循环的部分括在括号内。

示例 1:

输入: numerator = 1, denominator = 2
输出: "0.5"
示例 2:

输入: numerator = 2, denominator = 1
输出: "2"
示例 3:

输入: numerator = 2, denominator = 3
输出: "0.(6)"
 * @author zxl
 *
 */
public class FractionToDecimal {
	@Test
	public void main() {
		fractionToDecimal(-1,-2147483648);
	}
    public String fractionToDecimal(int numerator, int denominator) {
    	if(numerator==0)return "0";
    	
    	StringBuilder res = new StringBuilder();
    	if(numerator<0 ^denominator<0) {
    		res.append("-");
    	}
    long newNumerator=Math.abs(Long.valueOf(numerator));
    long newDenominator=Math.abs(Long.valueOf(denominator));
    	res.append(newNumerator/newDenominator);
    	long t=newNumerator%newDenominator;
    	if(t==0) {
    		return res.toString();
    	}
    	res.append('.');
    	HashMap<Long,Integer> visit=new HashMap<Long,Integer>();
    	while(t!=0) {
    		if(visit.containsKey(t)) {
    			res.insert(visit.get(t),"(");
    			res.append(')');
    			break;
    		}
    		visit.put(t, res.length());
    		t *=10;
    		res.append(t/ newDenominator);
    		t %=newDenominator;
//    		System.out.println((hashOf(t)&mask)+"--"+t);
    	}
 		return res.toString();
    }
   
}
