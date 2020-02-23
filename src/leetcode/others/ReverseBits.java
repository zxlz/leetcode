package leetcode.others;

import org.junit.Test;

/**
 * 颠倒二进制位
颠倒给定的 32 位无符号整数的二进制位。
 * @author zxl
 *
 */
public class ReverseBits {
	@Test
	public void main() {
		 reverseBits(43261596);
	}
    public int reverseBits(int n) {
    	int res=0;
    	for(int i=0;i<32;i++) {
            res=res<<1;
			res=(res+(n&1));
            n=n>>1;
     	}
		return res;
        
    }
}
