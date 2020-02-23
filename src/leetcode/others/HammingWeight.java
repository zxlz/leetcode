package leetcode.others;

/**
 * 位1的个数
编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * @author zxl
 *
 */
public class HammingWeight {
    public int hammingWeight(int n) {
    	int count=0;
    	for(int i=0;i<32;i++) {
    		if(((1<<i)&n)!=0) {
    			count++;
    		}
    	}
		return count;
         
    }
	int hammingWeight2(int n) {
		int count = 0;
		while (n != 0) {
			n = n & (n - 1);
			count++;
		}
		return count;
	}


}
