package leetcode.others2;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 887. 鸡蛋掉落
 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。

 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。

 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。

 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。

 你的目标是确切地知道 F 的值是多少。

 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？



 示例 1：

 输入：K = 1, N = 2
 输出：2
 解释：
 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 如果它没碎，那么我们肯定知道 F = 2 。
 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 示例 2：

 输入：K = 2, N = 6
 输出：3
 示例 3：

 输入：K = 3, N = 14
 输出：4


 提示：

 1 <= K <= 100
 1 <= N <= 10000
 *
 */
public class SuperEggDrop {
    @Test
    public void main() {

        System.out.println(superEggDrop(4,10000));
        System.out.println(superEggDrop(2,2));
    }
    /**
     *
     * 第一个鸡蛋从x层扔： Mx=max(dp[x,k-1]+dp[n-x,k])
     * 枚举所有第一个鸡蛋的可能 x=1，2，3。。。n   确定 F 的值的最小移动次数就是 min（M1,M2,M3 .... MN）
     * */
    public int superEggDrop(int K, int N) {
        cache=new Integer[K+1][N+1];
        return dp(K, N);
    }
    Integer[][] cache;
    //把查找部分改为二分
    private int dp(int eggNum, int  floor) {

        if(cache[eggNum][floor]==null) {
            if (eggNum == 1 || floor == 1 || floor==0) {//如果1个鸡蛋或者一层，结果是层数
                cache[eggNum][floor]=floor;
                return floor;
            }
            int left = 1;
            int right = floor;
            int res = 0;
            while (left +1< right) {
                int mid = (left + right) / 2;
//                System.out.println(mid);
                int  t1 = dp(eggNum - 1, mid - 1);
                int t2 = dp(eggNum, floor - mid);
                if (t1 < t2) {
                    left = mid;
                } else if (t1 > t2) {
                    right = mid;
                } else {

                    left=right=mid;
//                    cache[eggNum][floor] = t1 + 1;
                    break;
                }
            }
            cache[eggNum][floor] = 1 + Math.min(Math.max(dp(eggNum-1, left-1), dp(eggNum, floor-left)),
                    Math.max(dp(eggNum-1, right-1), dp(eggNum, floor-right)));;
//            cache[eggNum][floor] = res;
        }
            return cache[eggNum][floor];

    }
//    暴力
//    private int dp2(int eggNum, int  floor) {
//        if(eggNum>floor){
//            cache[eggNum][floor]=floor;
//        }
//        if(cache[eggNum][floor]==0 && (eggNum!=0 || floor!=0)){
//            if(eggNum==1 || floor==1 || floor==0){//如果1个鸡蛋或者一层，结果是层数
//                return floor;
//            }
//            int min = Integer.MAX_VALUE;
//            for (int curFloor = 1; curFloor <= floor; curFloor++) {
//
//                int maxi=Math.max(dp(eggNum-1,curFloor-1),dp(eggNum,floor-curFloor))+1;
////                System.out.println("i="+curFloor+"eggNum="+eggNum+"maxi=:"+maxi);
//                if(maxi<min)min=maxi;
//            }
////            System.out.println("eggNum="+eggNum+"  floor="+floor+"  res="+min);
//            cache[eggNum][floor]=min;
//            return min;
//        }else{
//            return cache[eggNum][floor];
//        }
//    }
}
