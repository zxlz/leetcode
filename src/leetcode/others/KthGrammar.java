package leetcode.others;

public class KthGrammar {
    public int kthGrammar(int N, int K) {
        if(K==1) return 0;
        if((K&1)==1){//是奇数
            K++;
            return kthGrammar(0,K>>1);
        }
        return kthGrammar(0,K>>1)^1;
        /**
         *    8>>4>>2>>1
         *    1  0  1  0
         *10
         *      5   2   
         *      
         */
//        Integer.bitCount(K - 1) % 2;
       
    }
}
