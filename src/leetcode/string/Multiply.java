package leetcode.string;

import java.util.Arrays;

import org.junit.Test;

/**
 * 字符串相乘
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"
说明：

num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * @author zxl
 *
 */
public class Multiply {
    @Test
    public void main() {
        
        System.out.println(multiply("123","456"));
    }
    public String multiply(String num1, String num2) {
        

        char[] arr1=num1.toCharArray();
        char[] arr2=num2.toCharArray();
        /**
         *    xxx
         *  xxxxx  
         *  01 0123 0123
         *  
         *  56088
         *  0 1  2  3  4  5
         *          4  5  6
         *          1  2  3
         *             1  8
         *          1  2
         *          6
         *          1  5
         */
        
        int[] res= new int[arr1.length+arr2.length];
        for (int i = arr2.length-1; i >=0; i--) {
            int number1=arr2[i]-'0';
            for (int j = arr1.length-1; j >=0; j--) {
                int number2=arr1[j]-'0';
                int sum = res[i+j+1] + number1*number2;
//                System.out.println(sum+" = "+res[i+j+1]+" + "+number1*number2);
//                res[i+j+1]= (sum%10);
                res[i+j+1]= sum;
//                System.out.println("res["+(i+j+1)+"]="+sum%10);
//                res[i+j] += (sum/10);
//                System.out.println("res["+(i+j)+"]="+sum/10);
            }
        }
        for (int i = res.length-1; i >0; i--) {
            if(res[i]>9) {
                res[i-1]+=res[i]/10;
                res[i] %=10;
            }
        }
        int i=0;
        while(i<res.length&&res[i]==0) {
            i++;
        }
        StringBuilder b = new StringBuilder();
        for (; i<res.length; i++) {
            b.append(res[i]);
        }
//       return new String(res,i,res.length-1)+"1";
       return b.length()==0?"0":b.toString();
    }
}
