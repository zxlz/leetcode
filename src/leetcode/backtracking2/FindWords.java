package leetcode.backtracking2;

import java.util.LinkedList;
import java.util.List;


/**
 * 单词搜索 II
给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。

示例:

输入: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

输出: ["eat","oath"]
说明:
你可以假设所有输入都由小写字母 a-z 组成。

提示:

你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？
散列表是否可行？为什么？
 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 * @author zxl
 *
 */
public class FindWords {
	int rows;
	int cols;
	List<String> res= new LinkedList<String>();
    public List<String> findWords(char[][] board, String[] words) {
    	Trie trie=new Trie();
    	for (String word : words) {
			trie.insert(word);
		}
    	
    	rows=board.length;
    	cols=board[0].length;
    	boolean[][] visited = new boolean[rows][cols];
    	for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				find(i,j,trie.root,board,visited);//从i,j开始找，是否在字典树中可以找到新单词 
			}
		}
    	return res;
    }
    private void find(int i, int j, TrieNode trieNode, char[][] board, boolean[][] visited) {

    	if(i<0 || i>=rows || j<0 || j>=cols || visited[i][j] )return;//找到边界或者重复，返回
    	int ch=board[i][j]-'a';
			if((trieNode=trieNode.next[ch])==null)return;//没有找到，返回
			if(trieNode.isEnd) {
				//找到了一个单词。改为false; 不要别的路径找到。
				res.add(trieNode.val);
				trieNode.isEnd=false;
			}
			visited[i][j]=true;//一次路径中不能重复用board的一个位置
			find(i-1,j,trieNode,board,visited);
			find(i+1,j,trieNode,board,visited);
			find(i,j-1,trieNode,board,visited);
			find(i,j+1,trieNode,board,visited);
			visited[i][j]=false;//找完了释放锁
	}
    private class TrieNode{
    	private String val;//字典树子串结尾单词加上完整的子串，dfs时找到单词后使用
		private boolean isEnd;
		private TrieNode[] next;
		public TrieNode() {
			next=new TrieNode[26];
		}
	}
	class Trie {
        /** Initialize your data structure here. */
        public Trie() {
        	root=new TrieNode();
        }
        private TrieNode root;
        /** Inserts a word into the trie. */
        public void insert(String word) {
        	TrieNode cur=root;
        	for (int i = 0; i < word.length(); i++) {
    			int ch=word.charAt(i)-'a';
    			if(cur.next[ch]==null) {
    				cur.next[ch]=new TrieNode();
    			}
    			cur=cur.next[ch];
    		}
        	cur.val=word;
        	cur.isEnd=true;
        }
        
        /** Returns if the word is in the trie. */
//        public boolean search(String word) {
//        	TrieNode cur=root;
//        	for (int i = 0; i < word.length(); i++) {
//    			int ch=word.charAt(i)-'a';
//    			if((cur=cur.next[ch])==null)return false;
//    		}
//        	return cur.isEnd;
//        }
        
        /** Returns if there is any word in the trie that starts with the given prefix. */
//        public boolean startsWith(String prefix) {
//        	TrieNode cur=root;
//        	for (int i = 0; i < prefix.length(); i++) {
//    			int ch=prefix.charAt(i)-'a';
//    			if((cur=cur.next[ch])==null)return false;
//    		}
//        	return true;
//        }
    }
}
