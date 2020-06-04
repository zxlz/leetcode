package leetcode.dynamicProgramming2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * 单词拆分 II
给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。

说明：

分隔时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
输出:
[
  "cats and dog",
  "cat sand dog"
]
示例 2：

输入:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
输出:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
解释: 注意你可以重复使用字典中的单词。
示例 3：

输入:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
输出:
[]
 * @author zxl
 *
 */
public class WordBreak2 {
	@Test
	public void main() {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("aa");
		list.add("aaa");
		list.add("aaaa");
		list.add("aaaaa");
		list.add("aaaaaa");
		list.add("aaaaaaa");
		list.add("aaaaaaaa");
		list.add("aaaaaaaaa");
		list.add("aaaaaaaaaa");
//List<String> list1= wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" 
//				,list);
List<String> list1= wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" 
		,list);
		System.out.println(list1.size());
	}
	HashMap<Integer,List<String>> cache= new HashMap<Integer, List<String>>();
    public List<String> wordBreak(String s, List<String> wordDict) {
    	return dfs(s, new HashSet(wordDict),0);
    }

	private List<String> dfs(String s, HashSet<String> hashSet, int start) {

		
		List<String> list=cache.get(start);
		if(list!=null)return list;
		list = new LinkedList<String>();
		if(start==s.length()) {
			list.add("");return list;
		};
		for(int i=start+1;i<=s.length();i++) {
			String str= s.substring(start,i);
			if(hashSet.contains(str) ) {
				List<String> chList= dfs(s,hashSet,i);
				for(String ch:chList) {
					list.add(str+(ch.equals("")?"":(" "+ch)));
				}
			}
		}
		cache.put(start, list);
		return list;
	}
}
