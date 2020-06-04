package leetcode.Math;

/**
 * 罗马数字转整数 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 
 * 字符 数值 I 1 V 5 X 10 L 50 C 100 D 500 M 1000
 * 通常情况下，罗马数字中  小的数字在大的数字的右边。   但也存在特例
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 
 * @author zxl
 *
 */
public class RomanToInt {
	public int romanToInt(String s) {
    	int res = 0;
    	int[] tab = new int[90];
    	tab['I']=1;
    	tab['V']=5;
    	tab['X']=10;
    	tab['L']=50;
    	tab['C']=100;
    	tab['D']=500;
    	tab['M']=1000;
    	for(int i=0;i<s.length();i++) {
    		
    		if(i!=s.length()-1&&tab[s.charAt(i)]<tab[s.charAt(i+1)]) {
    			res -=tab[s.charAt(i)];
    		}else {
    			res +=tab[s.charAt(i)];
    		}
    	}
		return res;

    }
}
