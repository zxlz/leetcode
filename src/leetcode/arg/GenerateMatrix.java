package leetcode.arg;

import org.junit.Test;

/**
 * 螺旋矩阵 II
给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 * @author zxl
 *
 */
public class GenerateMatrix {
    @Test
    public void main() {
        generateMatrix(30);
        System.out.println();
    }
    public int[][] generateMatrix(int n) {
        if(n==1) return new int[][] {{1}};
        int[][] res= new int[n][n];
        int top=0,down=0,left = 0,right = 0,next=0;
        int i = 0,j=0;
        while(next<n*n) {
            while(j<(n-right)) {
                res[i][j]=++next;
                j++;
            }
            j--;
            top++;
            i++;//i=top
            while(i<(n-down)) {
                res[i][j]=++next;
                i++;
            }
            i--;
            right++;
            j--;
            while(j>=left) {
                res[i][j]=++next;
                j--;
            }
            j++;
            down++;
            i--;
            while(i>=top) {
                res[i][j]=++next;
                i--;
            }
            i++;
            left++;
            j++;
        }
        
        return res;
    }
}
