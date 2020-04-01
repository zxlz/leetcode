package leetcode.others1;

import org.junit.Test;

/**
 * 第k个排列
给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

说明：

给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
示例 1:

输入: n = 3, k = 3
输出: "213"

  /1、逆康托
 * 2、回溯
 * @author zxl
 *
 */
public class GetPermutation {
    @Test
    public void main() {
        
        long start = System.currentTimeMillis();
//        int i=1;
//        while(i<1210) {
//            System.out.println(i);
//            System.out.println(getPermutation(9, i++));
//        }
        System.out.println(getPermutation(4, 3));
        

        long end = System.currentTimeMillis();
        System.out.println("TIME = " + (end - start));
    }
    public String getPermutation(int n, int k) {
        char[] base = new char[] {'1','2','3','4','5','6','7','8','9'};
       if(k==1) {
           return new String(base, 0, n);
       }
        
        char[] res= new char[n];
        int next=0;
        int[] temp = new int[n];
        boolean[] visited = new boolean[n];
        temp[next]=1;
        while(k>temp[next]) {
            next++;
            temp[next]=(next+1)*temp[next-1];
            
        }
        int i=0;
        
            while(i<n-next-1) {
                visited[i]=true;
                res[i]=base[i++];
            }
        
       
       
        if(k==temp[next]) {
            while(i<res.length) {
                res[i++]=base[--n];
            }
            return new String(res);
        }
       // 1   2  3 4 5 x=36
       // 120 24 6 2 1 
       //  5  x 
        k--;
       
        while(i<res.length) {
            next--;
            int underIndex=0;
            if(next>=0) {
                 underIndex=k/temp[next];//
                k=k%temp[next];
            }
            
            
            int t=0;
            while(  underIndex>0 || visited[t]) {
                if(!visited[t]) {
                    underIndex--;
//                    if(t==res.length-1)break;
                }
                t++;
            }
            visited[t]=true;//t+1这个数字已使用
            res[i++]=base[t];
        }
        return String.valueOf(res);
    }
}
