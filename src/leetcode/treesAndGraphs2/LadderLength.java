package leetcode.treesAndGraphs2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

/**
 * 单词接龙 给定两个单词（beginWord 和 endWord）和一个字典， 找到从 beginWord 到 endWord
 * 的最短转换序列的长度。转换需遵循如下规则：
 * 
 * 每次转换只能改变一个字母。 转换过程中的中间单词必须是字典中的单词。 说明:
 * 
 * 如果不存在这样的转换序列，返回 0。 所有单词具有相同的长度。 所有单词只由小写字母组成。 字典中不存在重复的单词。 你可以假设 beginWord 和
 * endWord 是非空的，且二者不相同。 示例 1:
 * 
 * 输入: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log","cog"]
 * 
 * 输出: 5
 * 
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * 
 * @author zxl
 *
 */
public class LadderLength {
	@Test
	public void main() {
		LinkedList<String> list = new LinkedList<String>();
		list.add("hot");
		list.add("dog");
		ladderLength("hot", "dog", list);
	}
	public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) {
			return 0;
		}
		Queue<String> queue1 = new LinkedList<String>();
		Queue<String> queue2 = new LinkedList<String>();
		Set<String> visit1 = new HashSet<String>();
		Set<String> visit2 = new HashSet<String>();
		queue1.offer(beginWord);
		queue2.offer(endWord);
		visit1.add(beginWord);
		visit2.add(endWord);
		wordList.add(beginWord);
		Set<String> all = new HashSet<>(wordList);
		int layer = 0;

		while (!queue1.isEmpty() && !queue2.isEmpty()) {
			if(queue1.size() > queue2.size()){
                Queue<String> q = queue1;
                queue1 = queue2;
                queue2 = q;
                Set<String> set = visit1;	
                visit1 = visit2;
                visit2 = set;
            }
			
			int size1 = queue1.size();
			layer++;
			while (--size1 >= 0) {
				String tar = queue1.poll();
				char[] ch=tar.toCharArray();
				for (int i = 0; i < ch.length; i++) {
					char c=ch[i];
					for (char j = 'a'; j < 'z'; j++) {
						ch[i]=j;
						String temp=new String(ch);
						if(visit1.contains(temp))continue;
						if(visit2.contains(temp))return layer+1;
						if(all.contains(temp)) {
							queue1.offer(temp);
							visit1.add(temp);
						}
					}
					ch[i]=c;
				}
			}
		}
		return 0;
	}


	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) {
			return 0;
		}
		Queue<String> queue1 = new LinkedList<String>();
		Queue<String> queue2 = new LinkedList<String>();
		Set<String> visit1 = new HashSet<String>();
		Set<String> visit2 = new HashSet<String>();
		queue1.offer(beginWord);
		queue2.offer(endWord);
		visit1.add(beginWord);
		visit2.add(endWord);
		int layer = 0;

		while (!queue1.isEmpty() || !queue2.isEmpty()) {
			if(queue1.size() > queue2.size()){
                Queue<String> q = queue1;
                queue1 = queue2;
                queue2 = q;
                Set<String> set = visit1;	
                visit1 = visit2;
                visit2 = set;
            }
			
			int size1 = queue1.size();
			layer++;
			while (--size1 >= 0) {
				String tar = queue1.poll();
				for (String word : wordList) {
					if (visit1.contains(word))
						continue;
					if (canConver(word, tar)) {
						if (visit2.contains(word))
							return layer + 1;
						visit1.add(word);
						queue1.offer(word);

					}
				}
			}
		}
		return 0;
	}

	private boolean canConver(String s1, String s2) {
		// TODO Auto-generated method stub
		if (s1.length() != s2.length())
			return false;
		int c = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (++c > 1)
					return false;
			}
		}

		return true;
	}
}
