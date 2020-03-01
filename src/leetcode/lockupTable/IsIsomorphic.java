package leetcode.lockupTable;

/**
 * 同构字符串
给定两个字符串 s 和 t，判断它们是否是同构的。

如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。

所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

示例 1:

输入: s = "egg", t = "add"
输出: true
示例 2:

输入: s = "foo", t = "bar"
输出: false
示例 3:

输入: s = "paper", t = "title"
输出: true
说明:
你可以假设 s 和 t 具有相同的长度。
 * @author zxl
 *
 */
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
    	//97-122
    	int[] sCheck = new int[128];
    	int[] tCheck = new int[128];
    	for(int i=0;i<s.length();i++) {
    		int schar=s.charAt(i);
    		int tchar=t.charAt(i);
    		if(sCheck[schar]==0) {//第一次出现
    		 	sCheck[schar]=i+1;//记录出现位置
    		 	if(tCheck[tchar]==0) {//t串也是第一次出现,也记录位置，否则false
    		 		tCheck[tchar]=i+1;
    		 	}else {
    		 		return false;
    		 	}
    		}else {
    			if(sCheck[schar]!=tCheck[tchar])return false;//如果重复的字符和另一个字符串位置不同，返回false
    		}
    	}
		return true;

    }
    
    
    public boolean isIsomorphic1(String s, String t) {
        char[] mapS = new char[128];
    boolean[] mapT = new boolean[128];
    
    char[] sArr = s.toCharArray(), tArr = t.toCharArray();
    for (int i = 0; i < sArr.length; i++) {
        if (mapS[sArr[i]] != '\0' || mapT[tArr[i]] == true) {
            if (mapS[sArr[i]] != tArr[i])
                return false;
        }
        else {
            mapS[sArr[i]] = tArr[i];
            mapT[tArr[i]] = true;
        }
    }
    return true;
}
}
