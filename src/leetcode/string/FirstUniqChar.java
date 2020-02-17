package leetcode.string;

import java.util.HashSet;
import java.util.Set;
/**
 * 字符串中的第一个唯一字符
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
s = "leetcode"
返回 0.

注意事项：您可以假定该字符串只包含小写字母。
 * @author zxl
 *
 */
public class FirstUniqChar {
	public int firstUniqChar(String s) {
		char[] chars = s.toCharArray();
        int base = 97;
        int[] loc = new int[26];
        for (char c:chars) loc[c - base] += 1;
        for (int i = 0; i < chars.length; i++) {
            if(loc[chars[i]-base]==1) return i;
        }
		return 0;
        
    }
	
	 public int firstUniqChar1(String s) {
	        int res = s.length();
	        for (int i = 'a'; i <= 'z'; i++) {
	            int firstIndex = s.indexOf((char)i);
	            if (firstIndex == -1) continue;
	            int lastIndex = s.lastIndexOf((char)i);
	            if (firstIndex == lastIndex) {//两次索引值相同则证明该字母只出现一次
	                res = Math.min(firstIndex, res);//res 为只出现一次的字母中索引值最小的
	            }
	        }
	        return res == s.length() ? -1 : res;
	    }
}
