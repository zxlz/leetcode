package leetcode.dynamicProgramming2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

/**
 * 单词拆分
给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。
示例 3：

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
 * @author zxl
 *
 */
public class WordBreak {
	@Test
	public void main() {
		List<String> list = new ArrayList<String>();
		list.add("leet");
		list.add("code");
		wordBreak("leetcode",list);
		System.out.println();
	}
    public boolean wordBreak(String s, List<String> wordDict) {
    	boolean[] failCache= new boolean[s.length()];
    	return dfs(s, new HashSet(wordDict),0,failCache);
		
    }

	private boolean dfs(String s, HashSet<String> hashSet, int start, boolean[] failCache) {

		if(start==s.length())return true;
		if(failCache[start])return false;
		for(int i=start+1;i<=s.length();i++) {
			if(hashSet.contains(s.substring(start, i)) && dfs(s,hashSet,i,failCache)) {
				return true;
			}
		}
		failCache[start]=true;
		return false;
	}
}
