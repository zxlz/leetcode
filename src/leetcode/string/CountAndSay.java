package leetcode.string;

import org.junit.Test;

/**
 * 外观数列
「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。

注意：整数序列中的每一项将表示为一个字符串。
 * @author zxl
 *
 */
public class CountAndSay {
	@Test
	public void main() {
		System.out.println(countAndSay(50));
	}
	 public String countAndSay(int n) {
		
		String str="1";
		//0 数字 1 数量      
		int[] tab =new int[2];
		for(int i=2;i<=n;i++) {
			str=count(str,tab);
			System.out.println(i+":"+str);
		}
		 return str; 
	    }
	 public String count(String str,int[] tab) {
		 tab[0]=-1;tab[1]=0;
		 StringBuilder s=new StringBuilder();
		 for(int i=0;i<str.length();i++) {
		 	 if(tab[0]==-1) {
		 		 tab[0]=str.charAt(i)-48;
				 tab[1] += 1;
			 }else if(tab[0]==str.charAt(i)-48) {
				 tab[1] +=1;
			 }else {
				 s.append(tab[1]+""+tab[0]);
				 i--;
				 tab[0]=-1;
				 tab[1]=0;
			 }
				 
		 }
		 s.append(tab[1]+""+tab[0]);
		 
		return s.toString(); 
	 }
}
