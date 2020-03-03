package leetcode.hashTable;

/**
 *  宝石与石头
 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。

示例 1:

输入: J = "aA", S = "aAAbbbb"
输出: 3
 * @author zxl
 *
 */
public class NumJewelsInStones {
    public int numJewelsInStones(String J, String S) {
    	boolean[] isJewel = new boolean[1<<7];
    	for (int i = 0; i < J.length(); i++) {
			isJewel[J.charAt(i)]=true;
		}
    	int count=0;
    	for (char s:S.toCharArray()) {
    		if(isJewel[s])count++;
		}
    	
		return count;

    }
}
