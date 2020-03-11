package leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @author zxl
 *
 */
public class LetterCombinations {
	List<String> res=new LinkedList<String>();
	char[][] table=new char[][]{{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'}
	,{'j','k','l'},{'m','n','o'},{'p','q','r','s'}
	,{'t','u','v'},{'w','x','y','z'}};
	char[] cs ;
	char[] numbers;
	 public List<String> letterCombinations(String digits) {
	    	if("".equals(digits))return new LinkedList<String>();	
	    		numbers= digits.toCharArray();
	    		cs=new char[numbers.length];
	    		dfs(0);
	    		
	    		return res;
	    }
	 private void dfs( int nbi) {
		if(nbi>=cs.length) {
			res.add(new String(cs));
			return;
		}
		 // TODO Auto-generated method stub
		for(char c:table[numbers[nbi]-'0']) {
			cs[nbi]=c;
			dfs(nbi+1);
		}
	}
	//迭代
    public List<String> letterCombinations1(String digits) {
    	if("".equals(digits))return new LinkedList<String>();
    	char[][] table=new char[][]{{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'}
    						,{'j','k','l'},{'m','n','o'},{'p','q','r','s'}
    						,{'t','u','v'},{'w','x','y','z'}};
    		
    		char[] numbers= digits.toCharArray();
    		List<String> res=new LinkedList<String>();
    		res.add("");
    			for (int i = 0; i < numbers.length; i++) {//循环数字
    				char[] chars=table[numbers[i]-'0'];//该数字需要循环的char
    				List<String> nextLayer=new LinkedList<String>();
    				for (int j = 0; j < chars.length; j++) {//加入下个位置每个可能的char
						for(String s:res) {
							nextLayer.add(s+chars[j]);
						}
					}
    				res=nextLayer;
    			}
    		
    		
    		return res;
    }
}
