package leetcode.others;

import java.util.Stack;

import org.junit.Test;

/**
 * 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
 * @author zxl
 *
 *
 */
public class BracketIsValid {
	@Test
	public void main() {
		isValid("((");
	}
	
    public boolean isValid(String s) {
    	if(s==null||"".equals(s))return true;
    	if((s.length()&1)==1)return false;//奇数不是
    	//用数组当栈更快  //栈超过一半 返回假
    	Stack<Character> stack=new Stack<Character>();
    	byte[] check = new byte[126];
    	check['(']=')'; 
    	//check[')']=-1;
    	check['{']='}'; 
    	//check['}']=-2;
    	check['[']=']';
    	//check[']']=-3;
    	
    	
    	for(int i=0;i<s.length();i ++) {
    		if(check[s.charAt(i)]==0 ) {
    			if(stack.isEmpty())return false;
                if (stack.pop() != s.charAt(i)){
                    return false;
                }
    		}else  {
    			stack.push( (char) check[s.charAt(i)]);
    		}
    	}
    	
    	return stack.isEmpty();

    }
}
