package leetcode.others1;

/**
 * 两整数之和
不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。

示例 1:

输入: a = 1, b = 2
输出: 3
示例 2:

输入: a = -2, b = 3
输出: 1
 * @author zxl
 *
 */
public class GetSum {
    public int getSum(int a, int b) {
    	if(a==0)return b;
    	if(b==0)return a;
    	return getSum(a^b,(a&b)<<1);
    }
}
