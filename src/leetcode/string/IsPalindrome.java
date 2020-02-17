package leetcode.string;
/**
 * 验证回文字符串
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
 * @author zxl
 *
 */
public class IsPalindrome {
	/**
	 * 48-57    :0-9
	 * 65-90:A-Z
	 * 97-122:a-z
	 * 
	 * @param s
	 * @return
	 */
	public boolean isPalindrome(String s) {
		
		int f=0;
		int l=s.length()-1;
		char pre ;
		char aft;
		while(f<l) {
			pre=s.charAt(f);
			aft=s.charAt(l);
			if(pre>96&&pre<123)pre -= 32;
			if(pre<48 || pre>90 || (pre>57&&pre<65)) {
				f++;
				continue;
			}
			if(aft>96&&aft<123)aft -= 32;
			if(aft<48 || aft>90 || (aft>57&&aft<65)) {
				l--;
				continue;
			}
			if(pre!=aft) {
				return false;
			}
			f++;
			l--;
			
		};
		return true;
	}
}
