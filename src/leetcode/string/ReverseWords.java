package leetcode.string;

import org.junit.Test;

/**
 * 双指针技巧系列
 * 
 * 翻转字符串里的单词
给定一个字符串，逐个翻转字符串中的每个单词。

 
˙
示例 1：

输入: "the sky is blue"
输出: "blue is sky the"
示例 2：

输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * @author zxl
 *
 */
public class ReverseWords {
	@Test
	public void main() {
		System.out.println(reverseWords1("Let's take LeetCode contest")); 
	}
	/**
	 *  hello   aa  hello
	* head1 tail1  head2 tail2
	 * @param s
	 * @return
	 */
    public String reverseWords(String s) {
    	if(s==null || "".equals(s))return s;
    	char[] sArr=s.toCharArray();
    	char[] res=new char[sArr.length];
    	int head=sArr.length-1;
    	int tail=sArr.length-1;
    	int i=0;
    	sign:
    	while(head>=0){
    		//空串 往左移
    		while( sArr[tail]==' ') {
    			head--;
    			tail--;
    			if(head<0) {
    				break sign;
    			}
    			
    			
    		}
    		//字符 往左移
    		while(  sArr[head]!=' ') {
    			head--;
    			if(head<0) {
    				break ;
    			}
    		}
    		System.arraycopy(sArr, head+1, res,i, tail-head);
    		i +=tail-head;
    		if(i<res.length ) {//不是最后一个子串，加空格
    			res[i]=' ';
    			
        		head--;
        		tail=head;
    		}
    		i++;
    	}
    	if(res[0]=='\u0000')return "";
		return new String(res, 0, i-1);
    }
    /**
     * 反转字符串中的单词 III
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例 1:

输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc" 
注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
     * @param s
     * @return
     */
    public String reverseWords1(String s) {
    	if(s==null || "".equals(s))return s;
    	byte[] bytes=s.getBytes();
    	int head=0;
    	int tail=0;
    	while(head<bytes.length) {
    		//head移到空格位，或者最后一位
    		while(bytes[head]!=32 ) {
    			head++;
    			if(head>=bytes.length) {
    				
    				break;
    			}
    		}
    		head--;//回到最后一个字符
    		
    		for(int h=head,t=tail;h>t;h--,t++) {
    			byte temp=bytes[h];
    			bytes[h]=bytes[t];
    			bytes[t]=temp;
    		}
    		if(head>=bytes.length) {
				break;
			}
    		head +=2;
    		tail=head;
    		
    	}
    	
		return new String(bytes);

    }
}
