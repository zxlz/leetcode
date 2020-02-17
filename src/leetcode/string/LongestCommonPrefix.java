package leetcode.string;

/**
 * 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。
 * @author zxl
 *
 */
public class LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
		if(strs==null || strs.length<1) {
			return "";
		}
		String result=strs[0];
		for(int i=1;i<strs.length;i++) {
			if(strs[i].length()<result.length()) {
				result=strs[i];
			}
		}
		for(int i=0;i<strs.length;i++) {
			while(!strs[i].startsWith(result)) {
				result=result.substring(0, result.length()-1);
			}
			if(result.length()==0) {
				return "";
			}
		}
		return result;
        
    }
}
