package leetcode.backtracking;

import com.sun.tools.javadoc.Start;
import org.junit.Test;

import java.util.Arrays;

/**
 * 306. 累加数
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 *
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 *
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 *
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 *
 * 示例 1:
 *
 * 输入: "112358"
 * 输出: true
 * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 示例 2:
 *
 * 输入: "199100199"
 * 输出: true
 * 解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 * 进阶:
 * 你如何处理一个溢出的过大的整数输入?
 */
public class IsAdditiveNumber {
    @Test
    public void main() {
//        System.out.println(isAdditiveNumber("112358"));
//        System.out.println(isAdditiveNumber("123"));
//        System.out.println(isAdditiveNumber("199100 1199 2"));
        System.out.println(isAdditiveNumber("111122335588143"));

    }
    public boolean isAdditiveNumber(String num) {
        if(num.length()<3)return false;
        for (int i = 1; i < num.length()<<1; i++) {//第二个数的起始（包含）
            for (int j = i+1; j < num.length(); j++) {//第三个数的起始（包含）
                //todo 还可以剪枝
                System.out.println("开始："+0+"--"+i+"---"+j);
                if(dfs(num.toCharArray(),0,i,j))return true;
                System.out.println("失败");
            }
        }
        return false;
    }

    private boolean dfs(char[] chars, int start1, int start2, int start3) {

        //排除首位为0的格式不正确的数
        if(chars[start1]=='0' && start2-start1>1 || chars[start2]=='0' && start3-start2>1){
            return false;
        }
        long sum = 0;//前两个数字的和
        long ten = 1;//
        int end1= start2-1;
        int end2=start3-1;
//199100199
        while(end1>=start1 && end2>=start2){
            sum+= (chars[end1--]-'0'+chars[end2--]-'0')*ten;
            ten*=10;
        }
        while(end1>=start1){
            sum+= (chars[end1--]-'0')*ten;
            ten*=10;
        }
        while(end2>=start2){
            sum+= (chars[end2--]-'0')*ten;
            ten*=10;
        }
        // 199    9+3=12   t 10   2+1 =3  10
        // 1000  1000
        if(ten>sum){
            ten/=10;
        }
        System.out.println("sum:"+sum);
        int end3=start3;
        while(end3<chars.length && ten>=1){
            if(chars[end3]-'0'==sum/ten){
                sum %=ten;
                ten/=10;
                end3++;
            }else{
                return false;
            }
        }
        if(ten>=1)return false;
        System.out.println("继续："+start2+"--"+start3+"---"+end3);
        return end3==chars.length || dfs(chars,start2,start3,end3 );
    }
}
