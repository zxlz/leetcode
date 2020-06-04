package leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 生成括号
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 * @author zxl
 *左 右
 *左 右
 *左 右
 *左 右
 *左 右
 *
 *lnum  rnum
 *
 *lnum<5
 *lnum>rnum
 */
public class GenerateParenthesis {
	List<String> res=new LinkedList<String>();
    public List<String> generateParenthesis(int n) {
    	int max=n;
    	find(new char[n<<1],0,0,max,0);
		return res;
    }
	//left 已经使用左括号数左括号小于max，可以一直加
    //right 已经使用右括号数右括号必须小于左括号数
	private void find(char[] cs, int left, int right, int max, int index) {

		if(left==max&&right==max) {
			res.add(new String(cs));
			return;
		}
		//加左括号
		if(left<max) {
			cs[index]='(';
			find(cs, left+1, right, max, index+1);
		}
		if(right<left) {
			cs[index]=')';
			find(cs, left, right+1, max, index+1);
		}
		return;
	}
	/**
	 *  ( ( ( ) ) )
	 *  ( ( ) ( ) )
	 *  ( ( ) ) ( )
	 *  ( ) ( ( ) )
	 *  ( ) ( ) ( )
	 *  
	 */
    
}
