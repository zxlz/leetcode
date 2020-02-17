package leetcode.string;

import org.junit.Test;

/**
 * 字符串转换整数 (atoi)
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：

假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
32 空格
45 -
48-57 0-9
 * @author zxl
 *
 */
public class MyAtoi {
	
	@Test
	public void main() {
		myAtoi("   -42");
	}
	 public int myAtoi(String str) {
		 int x=0;
		 int max=Integer.MAX_VALUE/10;
		 int min=Integer.MIN_VALUE/10;
		 Boolean negative=null;
		 for(int i =0;i<str.length();i++) {
			 char a=str.charAt(i);
			 if(negative==null&&a==32) {
				 continue;
			 }
			 if(negative==null&& a==45) {
				 negative=true;
				 continue;
			 }
			 if(negative==null&& a=='+') {
				 negative=false;
				 continue;
			 }
			 if(a>47 && a<58) {
				 int m=(a-'0');
				 if(x>max||(x==max&&m>7)) {
					 return Integer.MAX_VALUE;
				 }
				 if(x<min||(x==min&&m>8)) {
					 return Integer.MIN_VALUE;
				 }
				 if(negative==null)negative=false;
				 if(negative) {
					 x =x*10-m; 
				 }else {
					 x =x*10+m;
				 }
				 continue;
			 }
			 if(x==0) {
				 return 0;
			 }else {
				 return x;
			 }
		 }
		return x;
	        
	    }
}
