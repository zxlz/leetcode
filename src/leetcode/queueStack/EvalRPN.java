package leetcode.queueStack;

import java.util.Stack;

import org.junit.Test;

/**
 * 逆波兰表达式求值
根据逆波兰表示法，求表达式的值。

有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

说明：

整数除法只保留整数部分。
给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
示例 1：

输入: ["2", "1", "+", "3", "*"]
输出: 9
解释: ((2 + 1) * 3) = 9

 * @author zxl
 *
 */
public class EvalRPN {
	@Test
	public void main() {
		evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
	}
	/**
	 * 从未尾入栈，直到连续两个数字，出栈计算再入栈
	 * @param tokens
	 * @return
	 */
    public int evalRPN(String[] tokens) {
    	Stack<String> stack=new Stack<String>();
    	if(tokens==null ||tokens.length<3)return Integer.parseInt(tokens[0]);
    	//
    	for(int i=tokens.length-1;i>=0;i--) {
    		
    		if(!stack.isEmpty()&& stack.peek().charAt(stack.peek().length()-1)>47 && tokens[i].charAt(tokens[i].length()-1)>47) {
    			int a=Integer.parseInt(tokens[i], 10) ;
    			do{
        				int b=	Integer.parseInt(stack.pop(), 10);
        				String symbol=stack.pop();
        				switch (symbol) {
    					case "+":
    						a +=b;
    						break;
    					case "-":
    						a -=b;
    						break;
    					case "*":
    						a *=b;
    						break;
    					case "/":
    						a /=b;
    						break;
    					}
        				
        			
    			}while (!stack.isEmpty() &&stack.peek().charAt(stack.peek().length()-1)>47 );
    			stack.push( Integer.toString(a));
    		}else {
    			stack.push(tokens[i]);
    		}
    		
    	}
    	
		return Integer.parseInt(stack.pop(), 10);
    }
}
