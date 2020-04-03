package leetcode.backtracking2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 分割回文串
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

返回 s 所有可能的分割方案。

示例:

输入: "aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]
 * @author zxl
 *
 */
public class Partition {
	List<List<String>> res= new ArrayList<List<String>>();
	boolean[][] dp;
    public List<List<String>> partition(String s) {
    	char[] chars=s.toCharArray();
    	
    	// 预处理
        // 状态：dp[i][j] 表示 s[i][j] 是否是回文
        dp = new boolean[s.length()][s.length()];
        
        for (int right = 0; right < s.length(); right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }

    	//Stack<String> 是线程安全的，用deque非线程安全的更快
    	Deque<String> stack = new ArrayDeque<String>();
    	dfs(chars,0,s.length(),stack);
    	return res;
    }

	private void dfs(char[] chars, int left, int len, Deque<String> stack) {

		if(left==len) {
			res.add(new ArrayList<String>(stack));return;
		}
		for (int i = left; i < len; i++) {
//			 if (!checkPalindrome(chars, left, i)) {
			if (!dp[left][i]) {
	                continue;
	            }
			 stack.offerLast(new String(chars, left, i+1-left));
			 dfs(chars,i+1,len,stack);
			 stack.pollLast();
		}
	}

	private boolean checkPalindrome(char[] chars, int left, int right) {

		while(left<right) {
			if(chars[left]!=chars[right]) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
