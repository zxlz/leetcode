package leetcode.others1;

import org.junit.Test;
import sun.nio.cs.ext.MacThai;

/**
 *
 * 1～n整数中1出现的次数
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：6
 *
 *
 * 限制：
 *
 * 1 <= n < 2^31
 *
 * 5014
 *
 *    1   个
 *    2   h=501
 *    9   (h+1)*1  502   |0-501
 *
 *   1   十  (个位4>1)
 *   2   h=50
 *   9   (h+1)*10-10-(4+1) 51*10-5 |0-49*10+5010-5014 -1  // -1是除去个位已算的1
 *
 *  1    百  (十位1==1)
 *  2    h=5
 *  9    (h+1)*100-100-         |0-5*100
 *
 *       千
 *       h=0
 *       0+h*1000
 *
 *       cur=0,count = high*i;
 *       cur=1,count=high*i+low+1;
 *       cur>1,count=high*i+i
 *
 */
public class CountDigitOne {
    @Test
    public void main() {
        System.out.println(countDigitOne(1));
    }
    public int countDigitOne(int n) {
        int count = 0;
        long i = 1;//指向遍历的位数，如i=1即个位，i=10即十位，...，因为n可以有31位，所以10^31用long存储
        while(n/i!=0){

            long high = n/(10*i);//将当前位之前的所有高位都存在high中
            long cur = (n/i)%10;//将当前位记录在cur中，即我们每次都需要统计当前位上1出现的次数
            long low = n-(n/i)*i;
            if(cur == 0){
                count += high * i;
            } else if(cur == 1){
                count += high * i + low + 1;
            } else {
                count += high * i + i;
            }
            i = i * 10;//准备遍历下一位
        }
        return count;
    }
}
