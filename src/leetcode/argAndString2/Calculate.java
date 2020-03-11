package leetcode.argAndString2;

import java.util.Stack;

import org.junit.Test;

/**
 * 基本计算器 II 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。
 * 
 * 示例 1:
 * 
 * 输入: "3+2*2" 输出: 7
 * 
 * @author zxl
 *
 */
public class Calculate {
	@Test
	public void main() {
		calculate("2048");
	}
	public int calculate(String s) {
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	char[] arr=s.trim().toCharArray();
    	int t=0;
    	char op='+';
    	for (int i = 0; i < arr.length; i++) {
    		if(arr[i]==' ')continue; //去除空格
    			if(arr[i]>='0' ) {
        				t=t*10-'0'+arr[i];//数字        				i
    				if(i<arr.length-1)continue;
    			}	
			if (op == '+') {
				stack.push(t);
				
			} else if (op == '-') {
				stack.push(-t);
				
			} else if (op == '*') {
				stack.push(stack.pop() * t);
			} else {
				stack.push(stack.pop() / t);
			}
			op = arr[i];
			t = 0;
    	}	
    	int res=0;
    	while(!stack.isEmpty()) {
    		res +=stack.pop();
    	}
    	return res;
    }
}
