package leetcode.string;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
 * @author zxl
 *
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
    	int l=0;
    	int r=0;
    	int maxLen=0;
    	int tempLen=0;
    	char[] arr= s.toCharArray();
    	for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='(') {
				l++;
			}else {
				r++;
				tempLen +=2;
//				if(l>0) {
//					l--;
//					tempLen +=2;
//					
//				}else {//子串断开
//					if(maxLen<tempLen)maxLen=tempLen;
//					tempLen=0;
//				}
			}
			if(l==r) {
				if(maxLen<tempLen)maxLen=tempLen;
			}else if(r>l) {
				l=r=0;
				tempLen=0;
			}
		}
    	
    	for (int i = arr.length-1; i >=0; i--) {
			if(arr[i]=='(') {
				l++;
			}else {
				r++;
				tempLen +=2;
//				if(l>0) {
//					l--;
//					tempLen +=2;
//					
//				}else {//子串断开
//					if(maxLen<tempLen)maxLen=tempLen;
//					tempLen=0;
//				}
			}
			if(l==r) {
				if(maxLen<tempLen)maxLen=tempLen;
			}else if(l>r) {
				l=r=0;
				tempLen=0;
			}
		}
    	
		return maxLen;

    }
}
