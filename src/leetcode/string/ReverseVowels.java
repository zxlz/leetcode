package leetcode.string;

/**
 * 双索引技巧
 * 
 * 反转字符串中的元音字母
编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * @author zxl
 *
 */
public class ReverseVowels {
    public String reverseVowels(String s) {
    	int first=0;
    	int last=s.length()-1;
    	boolean[] check=new boolean[128];
    	check['a']=true;check['A']=true;
    	check['e']=true;check['E']=true;
    	check['i']=true;check['I']=true;
    	check['o']=true;check['O']=true;
    	check['u']=true;check['U']=true;
    	char pre;
    	char aft;
    	char[] str=s.toCharArray();
    	while(first<last) {
    		pre=str[first];
    		aft=str[last];
    		if(!check[pre]) {//改成while
    			first++;
    			continue;
    		}
    		if(!check[aft]) {
    			last--;
    			continue;
    		}
    		str[first]=aft;
    		str[last]=pre;
    		first++;
    		last--;
    	}
		return String.valueOf(str);

    }
}
