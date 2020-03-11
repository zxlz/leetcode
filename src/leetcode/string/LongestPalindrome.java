package leetcode.string;

import org.junit.Test;

/**
 * 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
 * @author zxl
 *
 */
public class LongestPalindrome {
	@Test
	public void main() {
		longestPalindrome("babad");
	}
    public String longestPalindrome(String s) {
    	if("".equals(s))return "";
    	char[] arr=s.toCharArray();
    	int left=0;
    	int right=0;
    	for (int i = 0; i < arr.length; i++) {
    		if(arr.length-i<(right-left)>>1) {
    			break;
    		}
			int l=i;
			int r=i;
			for(int templ=i, tempr=i;--templ>=0&&++tempr<arr.length&& arr[templ]==arr[tempr];) {
				l=templ;r=tempr;
			}
			if(r-l>right-left) {right=r;left=l;}
			for(int templ=i+1, tempr=i;--templ>=0&&++tempr<arr.length&& arr[templ]==arr[tempr];) {
				l=templ;r=tempr;
			}
			if(r-l>right-left) {right=r;left=l;}
		}
//    	return String.copyValueOf(arr, left, right-left+1);
    	return s.substring(left, right);
    }
}
