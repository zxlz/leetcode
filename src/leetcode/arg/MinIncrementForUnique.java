package leetcode.arg;

import java.util.Arrays;

/**
 * 945. 使数组唯一的最小增量
给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。

返回使 A 中的每个值都是唯一的最少操作次数。

示例 1:

输入：[1,2,2]
输出：1
解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
示例 2:

输入：[3,2,1,2,1,7]
输出：6
解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
提示：

0 <= A.length <= 40000
0 <= A[i] < 40000
 * @author zxl
 *
 */
public class MinIncrementForUnique {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int res= 0;
        for (int i =1; i < A.length; i++) {
			while(A[i]<=A[i-1]) {
				A[i]++;
				res++;
			}
		}
        return res;
        
    }
    public int minIncrementForUnique1(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int[] status =  new int[50000];
        int counts = 0;

        for(int num : A) {
            status[num]++;
        }

        for(int i = 0; i < 50000; i++) {
            if(status[i] > 1) {
                int expect = status[i] - 1;
                counts += expect;
                status[i + 1] += expect;
                status[i] = 1;
            }
        }

        return counts;
    }
}
