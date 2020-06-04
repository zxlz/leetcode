package leetcode.queueStack;

import java.util.Stack;

import org.junit.Test;

/**
 * 字符串解码
给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

示例:

s = "3[a]2[bc]", 返回 "aaabcbc".
s = "3[a2[c]]", 返回 "accaccacc".
s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".

 * @author zxl
 *
 */
public class DecodeString {
	@Test
	public void main() {
		decodeString("3[a]2[bc]");
	}
    public String decodeString(String s) {
    	if(s==null || "".equals(s))return "";
    	StringBuilder res=new StringBuilder();
    	StringBuilder temp;
    	Stack<Character> stack = new Stack<Character>();
    	int i=s.length()-1;
    	stack.push(s.charAt(i--));
    	while(i>-1) {
    		if(s.charAt(i)=='[') {
    			int num=0;
    			int offset=1;
    			while(--i>-1 &&s.charAt(i)<58) {
    				
    				num += (s.charAt(i)-'0')*offset;
    				offset *= 10;
    				
    			};
    			temp=new StringBuilder();
    			while(stack.peek() != ']') {
    				temp.append(stack.pop());
    			}
    			stack.pop();//取出]
    			//把temp复制num份，加入stack;
    			char[] chars=new char[num*temp.length()];
    			for(int x=0;x<chars.length;x +=temp.length()) {
    				temp.getChars(0,temp.length(), chars, x);
    				
    			}
    			if(i==-1) {//如果遍历完了，直接返回
    				res.append(chars);
    				while(!stack.isEmpty()) {
    		    		res.append(stack.pop());
    		    	}
    				return res.toString();
    			}
    			for(int x=chars.length-1;x>=0;x--) {
    				stack.push(chars[x]);
    			}
    			
    		}else {
    			stack.push(s.charAt(i--));
    		}
    	}
    	while(!stack.isEmpty()) {
    		res.append(stack.pop());
    	}
		return res.toString();

    }
}
