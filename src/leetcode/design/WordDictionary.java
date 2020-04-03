package leetcode.design;

import org.junit.Test;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 * <p>
 * 示例:
 * <p>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 说明:
 * <p>
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 */
public class WordDictionary {
    @Test
    public void main() {
        WordDictionary wordDictionary = new WordDictionary();
        //[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
//        System.out.println(wordDictionary.search("pad"));
//        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }
    private class Trie {
        boolean isEnd;
        Trie[] next;
//        int nextCount=0;
        Trie() {
            next = new Trie[26];
        }
    }

    private void addWord(char[] chars) {
        Trie cur = root;
        for (int i = 0; i < chars.length; i++) {
            int x=chars[i]-'a';
            while (cur.next[x]==null) {
//                cur.nextCount++;//计数+1；
                cur.next[x]=new Trie();
            }
            cur=cur.next[x];
        }
        cur.isEnd=true;
    }
    private boolean search(char[] chars,int start,Trie cur){
        sign:
        for (int i = start; i < chars.length; i++) {
            if(chars[i]=='.'){//模糊
//                int c=cur.nextCount;//next数量
//                for (int j = 0; j < 26 && c>0; j++) {
                for (int j = 0; j < 26 ; j++) {
                    if(cur.next[j]!=null){//成功找到点
//                        c--;
                        if(search(chars,i+1,cur.next[j]))return true;//找点的后续，如果成功，返回true;
                    }
                }
                return false;
            }else{//精确
                int x=chars[i]-'a';
                while(cur.next[x]==null){
                    return false;
                }
                cur=cur.next[x];
            }
        }

        return cur.isEnd;

    }

    private Trie root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new Trie();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        addWord(word.toCharArray());
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        return search(chars,0,root);
    }

}
