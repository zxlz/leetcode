package leetcode.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * Fizz Buzz
写一个程序，输出从 1 到 n 数字的字符串表示。

1. 如果 n 是3的倍数，输出“Fizz”；

2. 如果 n 是5的倍数，输出“Buzz”；

3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * @author zxl
 *
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
    	boolean[] tableFizz=new boolean[n];
    	boolean[] tableBuzz=new boolean[n];
    	String FizzBuzz="FizzBuzz";
    	String Fizz="Fizz";
    	String Buzz="Buzz";
    	for(int i=2;i<n;i +=3) {
    		tableFizz[i]=true;
    	}
    	for(int i=4;i<n;i +=5) {
    		tableBuzz[i]=true;
    	}
    	List<String> res=new ArrayList<String>(n);
    	for(int i=0;i<n;i++) {
    		res.add(tableFizz[n-1]&&tableBuzz[n-1]?FizzBuzz:
    							tableFizz[n-1]?Fizz:tableBuzz[n-1]?Buzz:Integer.toString(n));
    	}
    	
		return res;

    }
}
