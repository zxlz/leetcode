package leetcode.Math1;

import org.junit.Test;

/**
 * Excel表列序号
给定一个Excel表格中的列名称，返回其相应的列序号。

例如，

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
 * @author zxl
 *
 */
public class TitleToNumber {
	@Test
	public void main() {
		titleToNumber("AAA");
	}
    public int titleToNumber(String s) {
    	char[] ch = s.toCharArray();
        int ans = 0;
        for(int i= 0;i<ch.length;i++){
            ans = ans*26+(ch[i]-'A'+1);
        }
        return ans;
//    	int[] tab=new int[26];
//    	for (int i = 0; i < tab.length; i++) {
//			tab[i]=i+1;
//		}
//    	int ans=0;
//    	int base=1;
//    	for (int i = s.length()-1; i >=0; i--) {
//    		if(i<s.length()-1) {
//    			base *=26;
//    			ans+=tab[s.charAt(i)-'A']*base;
//    		}else {
//    			ans+=tab[s.charAt(i)-'A'];
//    		}
//		}
//		return ans;

    }
}
