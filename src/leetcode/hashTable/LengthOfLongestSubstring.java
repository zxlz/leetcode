package leetcode.hashTable;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * @author zxl
 *
 */
public class LengthOfLongestSubstring {
	 public int lengthOfLongestSubstring(String s) {
		 if(s == "") return 0;
	        char[] c = s.toCharArray();
	        int diffIndex = 0, maxDiff = 0;
	        for(int i = 0; i < c.length; i++){
	            for(int j = diffIndex; j < i; j++){//每次从上一次相同点前开始
	                if(c[i] == c[j]){
	                    diffIndex = j + 1;
	                    break;
	                }
	            }
	            maxDiff=Math.max((i - diffIndex + 1), maxDiff);
	        }
	        return maxDiff;

	    }
    public int lengthOfLongestSubstring1(String s) {
    	if(s.length()<2)return s.length();
    	int fast=1;
    	int slow=0;
    	int maxDiff=0;
    	char[] str=s.toCharArray();
    	HashMap<Character,Integer> map=new HashMap<Character, Integer>();
    	map.put(str[0],0);
    	for (; fast < str.length; fast++) {
    		Integer p;
			if((p=map.get(str[fast]))!=null) {
				maxDiff=Math.max(maxDiff, fast-slow);
				//slow移到p的位置，map里包括p之前的remove，  或者全清 p之后的重新加到包括新fast
				map.clear();
				slow=p+1;
				for(int j=p+1;j<=fast;j++)map.put(str[j],j);
				
			}else {
				map.put(str[fast],fast);
			}
		}
    	maxDiff=Math.max(maxDiff, fast-slow);
		return maxDiff;

    }
    
}
