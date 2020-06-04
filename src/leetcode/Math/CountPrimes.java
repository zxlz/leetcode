package leetcode.Math;

import org.junit.Test;

/**
 * 计数质数
统计所有小于非负整数 n 的质数的数量。
 * @author zxl
 *
 */
public class CountPrimes {
	@Test
	public void main() {
		//System.out.println(65537*65537);
		System.out.println(countPrimes(499979));
	}
    public int countPrimes(int n) {
    	
    	if(n<=1)return 0;
    	if(n==2)return 0;
    	if(n==3)return 1;
        if(n==4 || n==5)return 2;
        n--;
    	boolean[] notPrimes=new boolean[n];
    	notPrimes[0]=true;
    	int temp;
    	//1,2（2，3）位置的都是质数
    	for(int num=2;num<=Math.sqrt(n);num++) {
    		if(!notPrimes[num-1]) {
    			temp=num*num;
//    			int j=num;
    			
    			while(temp<=n && temp>0) {
    				
    				if(temp<=n && temp>0) {
    					
    					notPrimes[ temp-1]=true;
//    					System.out.println(num+":"+j+":"+temp);
    				}
//    				j++;
    				
    				temp += num;    				
    			}
    		}
    	}
    	
    	System.out.println(notPrimes[708]);
    	System.out.println(notPrimes[709]);
    	System.out.println(notPrimes[710]);
    	int res=0;
    	for(boolean b:notPrimes) {
    		if(!b) {
    			res++;
    		}
    	}
    	
		return res;

    }
}
