package leetcode.lockupTable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.junit.Test;

/**
 * 四数相加 II
给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。

为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。

例如:

输入:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

输出:
2

解释:
两个元组如下:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
-1 -1
-1  1
-1  1
-1  1
0 0 1 1
0 1 0 1
0 1 1 0
1 ...
 * @author zxl
 *
 */
public class FourSumCount {
	@Test
	public void main() throws Exception {
		Properties pro = new Properties();
		FileInputStream in = new FileInputStream("/Users/zxl/Documents/GitHub/leetcode/src/leetcode/arg.properties");
		
		pro.load(in);
		              
		              String A = pro.getProperty("A");
		              String B = pro.getProperty("B");
		              String C = pro.getProperty("C");
		              String D = pro.getProperty("D");
		int[] a =  Arrays.stream(A.split(",")).mapToInt(Integer::valueOf).toArray();
		int[] b =  Arrays.stream(B.split(",")).mapToInt(Integer::valueOf).toArray();
		int[] c =  Arrays.stream(C.split(",")).mapToInt(Integer::valueOf).toArray();
		int[] d =  Arrays.stream(D.split(",")).mapToInt(Integer::valueOf).toArray();
		fourSumCount2(a,b, c,d);
		//fourSumCount(new int[] {0,-1,1},new int[] {0,-1,1}, new int[] {0,0,1},new int[] {1,-1,1});
	}
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    	int len=A.length;
    	if(len==0)return 0;
    	Arrays.sort(A);
    	Arrays.sort(B);
    	Arrays.sort(C);
    	Arrays.sort(D);
    	int maxCD=C[len-1]+D[len-1];
    	int maxBCD=B[len-1]+maxCD;
    	int minCD=C[0]+D[0];
    	int minBCD=B[0]+minCD;
    	int res=0;
    	int max= A[len-1]+maxBCD;
    	if(max<0)return 0;
    	int min= A[0]+B[0]+C[0]+D[0];
		if(min>0)return 0;
    	for (int i = 0; i < len; i++) {
    		//System.out.println(i+"AAAAAAAAAAAAAAAAAAAAAAAAAAAA"+res);
    		//本轮最小的大于0退出 
    		//   最大的小于0，下一轮
    		int min1= A[i]+minBCD;
    		if(min1>0)break;
    		int max1=A[i]+maxBCD;
    		if(max1<0)continue;
    		
       		int countB=0;
			for (int j = 0; j < len; j++) {
				//System.out.println(j+"BBBBBBBBBBBBBBBB"+countB);
				int curAB=A[i]+B[j];
				int min2= curAB+minCD;
	    		if(min2>0)break;
	    		int max2=curAB+maxCD;
	    		if(max2<0)continue;
	    		int countC=0;
				for (int m = 0,n=len-1; m < len && n>-1; ) {
					//System.out.println(m+"CCCCCCCCC"+countC);
					int curABC=curAB+C[m];
//					int min3= curABC+D[0];
//		    		if(min3>0)break;
//		    		int max3=curABC+D[n];
//		    		if(max3<0) {
//		    			m++;continue;
//		    		}
//		    		int countD=0;
		    		if(D[n]==-curABC) {
		    			int x=1;
						while( n>0 && D[n]==D[n-1]) { n--;x++;}
						while( m<len-1 && C[m]==C[m+1]){ m++;countC+=x;}
						countC+=x;
						n--;
						m++;
					}else if(D[n]>-curABC){
						n--;
					}else {
						m++;
					}
				} 
				while( j<len-1 && B[j]==B[j+1])  { j++;countB+=countC;}
				countB+=countC;
			}
			 while( i<len-1 && A[i]==A[i+1])  { i++;res+=countB;}
			 res+=countB;
		}
    	return res;
    	
    }
    public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map=new java.util.HashMap<>();
        for(int i=0;i<C.length;i++){
            for(int j=0;j<D.length;j++){
                map.put(C[i]+D[j],map.getOrDefault(C[i]+D[j],0)+1);
            }
        }
        int n=0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                int t=A[i]+B[j];
                t=-t;
                n+=map.getOrDefault(t,0);
            }
        }
        return n;
    }
    
    //============================================================
    public class ListNode2 {

        private int value;
        private int visit;
        private ListNode2 next;

        public ListNode2(int value) {
            this.value = value;
        }

        public ListNode2 insert (ListNode2 head, int value){
            ListNode2 tmp = new ListNode2(value);
            tmp.next = head;
            return tmp;
        }

    }

    public class HashMap {

        private int max = 0x7ffff;//2^20 -1 
        private ListNode2[] myHash = new ListNode2[max];

        public int getKey(int value){
            return value > 0 ? value % max : -(value % max);//524287个槽
        }

        public void insert (int value){
            int key = getKey(value);
            if (myHash[key] == null){
                myHash[key] = new ListNode2(value);
                myHash[key].visit = 1;
                return;
            }
            ListNode2 head = myHash[key];
            while(head != null){
                if (head.value == value){
                    head.visit ++;
                    return;
                }
                head = head.next;
            }
            myHash[key] = myHash[key].insert(myHash[key], value);
            myHash[key].visit = 1;
        }

        public int find (int value){
            int count = 0, key = getKey(value);
            ListNode2 head = myHash[key];
            while(head != null){
                if (head.value == value) {
                    return head.visit;
                }
                head = head.next;
            }
            return count;
        }

    }

    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        HashMap map = new HashMap();
        int count = 0, i, j, sum;
        for (i = 0; i < C.length; i ++) {
            for (j = 0; j < D.length; j ++) {
                map.insert(C[i] + D[j]);
            }
        }
        for (i = 0; i < A.length;  i ++) {
            sum = 0 - A[i];
            for (j = 0; j < B.length; j ++) {
                count += map.find(sum - B[j]);
            }
        }
        return count;
    }
    
    
}
