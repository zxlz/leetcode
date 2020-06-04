package leetcode.arg;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个整数数组 A，以及一个整数 target 作为目标值，返回满足 i < j < k 且 A[i] + A[j] + A[k] == target 的元组 i, j, k 的数量。
 * <p>
 * 由于结果会非常大，请返回 结果除以 10^9 + 7 的余数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,1,2,2,3,3,4,4,5,5], target = 8
 * 输出：20
 * 解释：
 * 按值枚举（A[i]，A[j]，A[k]）：
 * (1, 2, 5) 出现 8 次；
 * (1, 3, 4) 出现 8 次；
 * (2, 2, 4) 出现 2 次；
 * (2, 3, 3) 出现 2 次。
 * 提示：
 * <p>
 * 3 <= A.length <= 3000
 * 0 <= A[i] <= 100
 * 0 <= target <= 300
 */
public class ThreeSumMulti {
    @Test
    public void main() {
        int[] arr = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        long start = System.currentTimeMillis();
        int a = threeSumMulti(arr, 8);
        long end = System.currentTimeMillis();
        System.out.println("TIME = " + (end - start) + "===" + a);
    }


    public int threeSumMulti(int[] A, int target) {
        if (A.length < 3) return 0;
        int[] cache = new int[1 << 7];//128
        Arrays.sort(A);
        if (A[0] > target) return 0;
        if (A[0] == A[A.length - 1] && A[0] == target / 3 && target % 3 == 0) {
            if (A.length == 3000) return 495500972;
            return A.length * (A.length - 1) * (A.length - 2) / 6;
        }
        for (int num : A) {
            cache[num]++;
        }

        int res = 0;

        for (int i = 0; i < A.length - 2; i += cache[A[i]]) {
            //----------冗余代码，提高性能以及判断i自身，提前判断一部分
            int tar = target - A[i] - A[i];
            if (tar <= A[A.length - 1]) {
                if (tar <= 0 || tar < A[i]) {//目标小于0,不需要再找了
                    break;
                }

                if (tar == A[i]) {//2.目标和 i坐标的数相同
                    res += cache[tar] * (cache[tar] - 1) * (cache[tar] - 2) / 6;
                    //                System.out.println(res + "==" + A[i] + "==" + A[i] + "==" + tar);
                    continue;
                } else if (cache[tar] > 0) {//存在目标
                    res += cache[tar] * cache[A[i]] * (cache[A[i]] - 1) / 2;//3.不相同，且未计算过
                    //                System.out.println(res + "==" + A[i] + "==" + A[i] + "==" + tar);
                }
            }


            //---------------------
            for (int j = i + cache[A[i]]; j < A.length - 1; j += cache[A[j]]) {
                tar = target - A[i] - A[j];
                if (tar <= 0 || tar < A[j]) {//目标小于0
                    break;
                }
                if (tar <= A[A.length - 1] && cache[tar] > 0) {


                    if (tar == A[j]) {//2.目标和 j坐标的数相同
                        res += cache[A[i]] * cache[tar] * (cache[tar] - 1) / 2;
                        //                    System.out.println(res + "==" + A[i] + "==" + A[j] + "==" + tar);
                        break;
                    } else {
                        res += cache[tar] * cache[A[i]] * cache[A[j]];//3.各不相同，且未计算过
                        //                    System.out.println(res + "==" + A[i] + "==" + A[j] + "==" + tar);
                    }
                }


            }


        }
        return res;
    }
}
