package leetcode.trie;

import org.junit.Test;
/**
 * 820. 单词的压缩编码
给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。

例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。

对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。

那么成功对给定单词列表进行编码的最小字符串长度是多少呢？

 

示例：

输入: words = ["time", "me", "bell"]
输出: 10
说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 

提示：

1 <= words.length <= 2000
1 <= words[i].length <= 7
每个单词都是小写字母 。
 * @author zxl
 *
 */
public class MinimumLengthEncoding {
    @Test
    public void main() {
        minimumLengthEncoding(new String[] {"time", "atime", "btime"});
//        minimumLengthEncoding(new String[] {"time", "me", "bell"});
        //e m i t   5
        //e m i t  a 6
        // e  m i t b
        System.out.println();
    }
    
    class TrieNode{
        boolean isEnd;
        int count=0;
        TrieNode[] next;
        public TrieNode(int c) {
            next=new TrieNode[26];
            count=c;
        }
    }
    public int inverseInsert(String word) {
        TrieNode cur=root;
        int canMergeCount=0;
        int isNew=0;
        for (int i = word.length()-1; i >=0; i--) {
            int ch=word.charAt(i)-'a';
            if(cur.next[ch]==null) {
                cur.next[ch]=new TrieNode(cur.count+1);
                if(cur.isEnd) {//如果经过了已计算，则要减去已计算的
                    canMergeCount+=cur.count+1;
                    cur.isEnd=false;
                }
                isNew=1;
            }
            cur=cur.next[ch];
        }
        
//        System.out.println(cur.count+"-"+canMergeCount+"+"+1);
        if(isNew==1) {
            cur.isEnd=true;
            return cur.count-canMergeCount+1;
        }else {
            return 0;
        }
    }
    private TrieNode root=new TrieNode(0);
    //建后缀树，同时统计，如果1.是新节点 则返回长度，并消掉子单词标记减去子单词的长，2.是已有路径上的子单词，则0返回
    public int minimumLengthEncoding(String[] words) {
        int res=0;
        for (int i = 0; i < words.length; i++) {
            res +=inverseInsert(words[i]);
//            System.out.println(res);
        }
        
        
        return res;
    }
}
