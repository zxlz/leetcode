package leetcode.string;

import org.junit.Test;

public class Convert {
	@Test
	public void main() {
//		convert("PAYPALISHIRING", 3);
		convert("ab", 1);
		System.out.println();
	}
	/**"PAYPALISHIRING"
	 * 
	 * p	a   h   n
	 * a p  l s i i g
	 * y	i   r
	 * 
	 *  0   4   8     12
	 *  1 3 5 7 9  11 13
	 *  2   6   10
	 *  
0    6     12
1  5 7  11 13
2 4  8 10  14
3    9     15

k(0-2) k(2*4-2)+0
k(0-2) k(2*4-2)+1 k(2*4-2)+1-2
k(0-2) k(2*4-2)+2 k(2*4-2)+2-4
k(0-2) k(2*4-2)+3 
	 * @param s
	 * @param numRows
	 * @return
	 */
    public String convert(String s, int numRows) {
    	if(numRows==1)return s;
    	char[] arr=s.toCharArray();
    	int offset=2*numRows-2;
    	char[] res=new char[arr.length];
    	int oldIndex=0;
    	int next=0;
    	int k=0;
    	int curRow=0;
    	boolean isInner=false;//是行内位置
    	while(next<res.length) {
    		if(isInner) {
    			oldIndex=k*offset-curRow;
    		}else {				
    			oldIndex=k*offset+curRow;
    			k++;
			}
    		 if(curRow!=0 && curRow!=numRows-1 )isInner=!isInner;
    		 if(oldIndex<arr.length) {
    			 res[next++]=arr[oldIndex];
    			 
    		 }else {
    			 k=0;
    			 curRow++;
    			 isInner=false;//开始都不是行内
    		 }
    	}
        return String.valueOf(res);
    }
}
