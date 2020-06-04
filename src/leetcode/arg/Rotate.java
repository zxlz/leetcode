package leetcode.arg;

public class Rotate {
		/**
		 * 给定一个 n × n 的二维矩阵表示一个图像。将图像顺时针旋转 90 度。
		 * @param nums
		 * @param i
		 * @param j
		 * @param m
		 * @param n
		 * 
		 *  观察规律有：
		 * 	按照主对角线，将对称元素交换
			按照列，将对称列元素全部交换
		 */

	   public void rotate(int[][] matrix) {
		   /**    j
		    *   0 1 2 3 4
		    * 0 .
		i   * 1 0 .
		    * 2 0 1 . * *
		    * 3 0 1 2 . *
		    * 4 0 1 2 3 .
		    */
	        for(int i=0;i<matrix.length;i++){
	            for(int j=0;j<i;j++){
	                swap(matrix,i,j,j,i);
	            }
	        }
	        for(int j=0;j<matrix[0].length/2;j++){
	            for(int i=0;i<matrix.length;i++){
	                swap(matrix,i,j,i,matrix.length-1-j);
	            }
	        }
	    }
	    public void swap(int[][] nums,int i,int j,int m,int n){
	        int temp = nums[i][j];
	        nums[i][j] = nums[m][n];
	        nums[m][n] = temp;
	    }

}
