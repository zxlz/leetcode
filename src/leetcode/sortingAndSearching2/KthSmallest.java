package leetcode.sortingAndSearching2;

/**
 * Kth Smallest Element in a Sorted Matrix
给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
请注意，它是排序后的第k小元素，而不是第k个元素。

示例:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

返回 13。
说明:
你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。
 * @author zxl
 *
 */
public class KthSmallest {
	 public int kthSmallest(int[][] matrix, int k) {
	        if (matrix == null || k == 0) {
	            return -1;
	        }
	        int n = matrix.length, mid;
	        int left = matrix[0][0], right = matrix[n - 1][n - 1];
	        while (left < right) {
	            mid = left + (right - left) / 2;
	            if(count(matrix, mid) >= k) right = mid ;
	            else left = mid + 1;
	        }
	        return left;
	    }
	 private int count(int[][] matrix, int target) {
	        int x = 0, y = matrix[0].length -1;
	        int num = 0;
	        while(x < matrix.length && y >= 0) {
	            if(matrix[x][y] <= target) {
	                num += y + 1;
	                x++;
	            }else {
	                y--;
	            }
	        }
	        return num;
	    }
}
