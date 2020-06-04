package leetcode.string;

import java.util.Arrays;

import org.junit.Test;

/**
 * 二进制求和
给定两个二进制字符串，返回他们的和（用二进制表示）。

输入为非空字符串且只包含数字 1 和 0。

示例 1:

输入: a = "11", b = "1"
输出: "100"
 * @author zxl
 *
 */
public class AddBinary {
	@Test
	public void main() {
		System.out.println(addBinary("11","1"));
	}
    public String addBinary(String a, String b) {
    	String min;
    	String max;
    	if(a.length()>b.length()) {
    		max=a;
    		min=b;
    	}else {
    		max=b;
    		min=a;
    	}
    	char[] res = new char[max.length() +1];
    	for(int i=max.length()-1, j=min.length()-1;i>=0;i--,j--) {
    		int temp=max.charAt(i)-'0';
    		if(j>=0) {
    			temp +=min.charAt(j)-'0';
    		}
    			 if(temp==1) {
    				if(res[i+1]=='1') {
    					res[i+1]='0';res[i]='1';
    				}else {
    					res[i+1]='1';
    				}
    			} else if(temp==0){
    				if(res[i+1]=='\u0000')res[i+1]='0';
    			}else  {
    				if(res[i+1]=='\u0000')res[i+1]='0';
    				res[i]='1';
    			}
    		
    	}
    	if(res[0]=='\u0000')res=Arrays.copyOfRange(res, 1, res.length);
		return String.valueOf(res);
		
    }
}
