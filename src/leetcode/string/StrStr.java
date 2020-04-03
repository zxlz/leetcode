package leetcode.string;

import org.junit.Test;

/**
 * 
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * @author zxl
 *
 */
public class StrStr {

	@Test
	public void main() {
	
		System.out.println(strStr("mississippi", "issip"));
		;
	}
	public int strStr(String haystack, String needle) {
		int index;
		if(needle==null || haystack==null||"".equals(needle)) {
			return 0;
		}
		int temp;
		for(int i=0;i<haystack.length();i++) {
			index=0;
			temp=0;
			 while(needle.charAt(index)==haystack.charAt(i) 
					 && (index!=0 || (index==0 && haystack.length()-i>=needle.length()))
					 
					 ) {
				 
				 //遍历完needle
				 if(index>=needle.length()-1) {
					 return i-needle.length()+1;
				 }
				 i++;
				 temp++;
				 index++;
			 }
			 i -=temp;
		}
		return -1;
        
    }
	public int strStr2(String haystack, String needle) {
		return haystack.indexOf(needle);
        
    }
	/**
	 *  return indexOf(value, 0, value.length, str.value, 0, str.value.length, fromIndex);
	 */
//	  static int indexOf(char[] source, int sourceOffset, int sourceCount,
//	            char[] target, int targetOffset, int targetCount,
//	            int fromIndex) {
//	        if (fromIndex >= sourceCount) {
//	            return (targetCount == 0 ? sourceCount : -1);
//	        }
//	        if (fromIndex < 0) {
//	            fromIndex = 0;
//	        }
//	        if (targetCount == 0) {
//	            return fromIndex;
//	        }
//
//	        char first = target[targetOffset];
//	        int max = sourceOffset + (sourceCount - targetCount);
//
//	        for (int i = sourceOffset + fromIndex; i <= max; i++) {
//	            /* Look for first character. */
//	            if (source[i] != first) {
//	                while (++i <= max && source[i] != first);
//	            }
//
//	            /* Found first character, now look at the rest of v2 */
//	            if (i <= max) {
//	                int j = i + 1;
//	                int end = j + targetCount - 1;
//	                for (int k = targetOffset + 1; j < end && source[j]
//	                        == target[k]; j++, k++);
//
//	                if (j == end) {
//	                    /* Found whole string. */
//	                    return i - sourceOffset;
//	                }
//	            }
//	        }
//	        return -1;
//	    }
}
