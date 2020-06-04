package leetcode.trie;

class Trie {
	private class TrieNode{
		private boolean isEnd;
		private TrieNode[] next;
		public TrieNode() {
			next=new TrieNode[26];
		}
	}
	
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
    	cur.isEnd=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode cur=root;
    	for (int i = 0; i < word.length(); i++) {
			int ch=word.charAt(i)-'a';
			if((cur=cur.next[ch])==null)return false;
		}
    	return cur.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode cur=root;
    	for (int i = 0; i < prefix.length(); i++) {
			int ch=prefix.charAt(i)-'a';
			if((cur=cur.next[ch])==null)return false;
		}
    	return true;
    }
}
