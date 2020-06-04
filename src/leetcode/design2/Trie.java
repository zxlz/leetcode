package leetcode.design2;

/**
 * 实现 Trie (前缀树)
实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

示例:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");   
trie.search("app");     // 返回 true
说明:

你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。
 * @author zxl
 *
 */
public class Trie {
	private TrieNode root;
	class TrieNode {
		boolean isEnd;
		TrieNode[] next=new TrieNode[26];
	}
	/** Initialize your data structure here. */
    public Trie() {
    	root=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode cur=root;
    	for(int i=0;i<word.length();i++) {
    		int c=word.charAt(i)-'a';
    		if(cur.next[c]==null) {
    			cur.next[c]=new TrieNode();
    		};
    		cur=cur.next[c];
    	}
    	cur.isEnd=true;
    }
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode cur=root;
    	for(int i=0;i<word.length();i++) {
    		int c=word.charAt(i)-'a';
    		if(cur.next[c]==null) {
    			return false;
    		};
    		cur=cur.next[c];
    	}
    	return cur.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode cur=root;
    	for(int i=0;i<prefix.length();i++) {
    		int c=prefix.charAt(i)-'a';
    		if(cur.next[c]==null) {
    			return false;
    		};
    		cur=cur.next[c];
    	}
    	return true;
    }
}
