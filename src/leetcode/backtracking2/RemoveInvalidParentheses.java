package leetcode.backtracking2;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Remove Invalid Parentheses
删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。

说明: 输入可能包含了除 ( 和 ) 以外的字符。

示例 1:

输入: "()())()"
输出: ["()()()", "(())()"]
示例 2:
left = 0, right = 1
输入: "(a)())()"
输出: ["(a)()()", "(a())()"]
示例 3:

输入: ")("
输出: [""]
 * @author zxl
 *0 1 2 3 4 5 6 7
  ( ) ) ) ( ( ( )  
i = 0, left = 1, right = 0
i = 1, left = 0, right = 0
i = 2, left = 0, right = 1
i = 3, left = 0, right = 2
i = 4, left = 1, right = 2
i = 5, left = 2, right = 2
i = 6, left = 3, right = 2
i = 7, left = 2, right = 2
 */
public class RemoveInvalidParentheses {
	@Test
	public void main() {
		removeInvalidParentheses("()())()");
		System.out.println();
	}
	List<String> res= new LinkedList<String>();
    public List<String> removeInvalidParentheses(String s) {
    	int errL=0,errR=0;//多余的左括号和右括号
    	for (int i = 0; i < s.length(); i++) {
			char c=s.charAt(i);
			if(c=='(') {
				errL++;
			}else if(c==')') {
				if(errL>0)errL--;
				else errR++;
			}
		}
    	//err右括号在左括号前面，先删右括号，再删左括号
    	dfs(0,errL,errR,s);
		return res;
    }
	private void dfs(int start,int errL, int errR, String s) {
		if(errL==0 && errR==0) {
			if (isvalid(s)) {
				res.add(s);
            }
			return;
		}
		
		//

		for (int i = start; i < s.length(); i++) {
			if(i!=start && s.charAt(i)==s.charAt(i-1))continue;
			if(s.charAt(i)==')'&&errR>0){//先右括号再左括号
				dfs(i,errL,errR-1,s.substring(0, i)+s.substring(i+1, s.length()));
			}else if(s.charAt(i)=='('&&errL>0){
				dfs(i,errL-1,errR,s.substring(0, i)+s.substring(i+1, s.length()));
			}
		}
	}
	boolean isvalid(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else if (c == ')') {
                cnt--;
                if (cnt < 0) return false;
            }
        }
        return cnt == 0;
    }
}
