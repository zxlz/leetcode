package leetcode.others2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

/**
 * 679. 24 点游戏
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 *
 * 示例 1:
 *
 * 输入: [4, 1, 8, 7]
 * 输出: True
 * 解释: (8-4) * (7-1) = 24
 * 示例 2:
 *
 * 输入: [1, 2, 1, 2]
 * 输出: False
 * 注意:
 *
 * 除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
 * 每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1 是不允许的。
 * 你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。
 */
public class JudgePoint24 {
    @Test
    public  void main() {
        int i=0;
        Random random = new Random();
        int[] arr = new int[4];
        while(i++<10){
            int a =random.nextInt(10);
            int b =random.nextInt(10);
            int c =random.nextInt(10);
            int d =random.nextInt(10);

            arr[0]=a;
            arr[1]=b;
            arr[2]=c;
            arr[3]=d;

            long start = System.currentTimeMillis();

            judgePoint24(arr);

            long end = System.currentTimeMillis();
            if(end-start>2){
            System.out.println(arr[0]+"-"+arr[1]+"-"+arr[2]+"-"+arr[3]);
            System.out.println("TIME = "+(end-start));

            }
        }
//        System.out.println(judgePoint24(new int[]{1,2,3,4}));
    }
    public boolean judgePoint24(int[] nums) {
        ArrayList<Double> arrayList = new ArrayList<>();
        for (int num : nums) {
            arrayList.add((double) num);
        }
        return slove(arrayList);
    }

    private boolean slove(ArrayList<Double> arrayList) {
        if(arrayList.size()==0)return false;
        if(arrayList.size()==1)return Math.abs(arrayList.get(0)-24)<1e-6;
        for (int i = 0; i < arrayList.size(); i++) {

            for (int j = 0; j < arrayList.size() ; j++) {
                if(i!=j){
                    ArrayList<Double> arrayList2 = new ArrayList<>();
                    for (int k = 0; k < arrayList.size(); k++){
                        if (k != i && k != j) {
                            arrayList2.add(arrayList.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        if(k<2 && i>j)continue;
                        if(k==0)arrayList2.add(arrayList.get(i)+arrayList.get(j));
                        if(k==1)arrayList2.add(arrayList.get(i)*arrayList.get(j));
                        if(k==2)arrayList2.add(arrayList.get(i)-arrayList.get(j));
                        if(k==3  ){
                            if(arrayList.get(j)!=0){
                                arrayList2.add(arrayList.get(i)/arrayList.get(j));
                            }else{
                                continue;
                            }
                        }
//                        System.out.println(arrayList2);
                        if(slove(arrayList2)){
                            return true;
                        }
                        arrayList2.remove(arrayList2.size()-1);
                    }
                }
            }
//            arrayList2.clear();
        }

        return false;
    }
}
