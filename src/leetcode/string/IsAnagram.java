package leetcode.string;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
 * @author zxl
 *
 */
public class IsAnagram {
	
	 public boolean isAnagram(String s, String t) {
		 if(s.length()==t.length()) {
			 char[] chars1 = s.toCharArray();
			 char[] chars2 = t.toCharArray();
		        int base = 97;
		        int[] table = new int[26];
		        int[] checktable = new int[26];
		        for (int i = 0; i < chars1.length; i++) {
		        	table[chars1[i]-base] +=1; 
		        	table[chars2[i]-base] -=1; 
		        } 
//		        for (int i = 0; i < table.length; i++) {
//		        	if(table[i]!=0) return false;
//		        }
		        return Arrays.equals(checktable, table);
		 };
		 
	        
		return false;
	        
	 }

}
