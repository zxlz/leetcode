package leetcode.others;

/**
 * 汉明距离
两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * @author zxl
 *
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
    	int n=x^y;
    	int count=0;
    	for(int i=0;i<32;i++) {
    		if(((1<<i)&n)!=0) {
    			count++;
    		}
    	}
		return count;
    }
}
