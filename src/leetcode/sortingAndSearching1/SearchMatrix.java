package leetcode.sortingAndSearching1;

/**
 * 搜索二维矩阵 II
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：

每行的元素从左到右升序排列。
每列的元素从上到下升序排列。
示例:

现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]

]
给定 target = 5，返回 true。

给定 target = 20，返回 false。
1 2 3 4 5 6  7 8 9
 * @author zxl
 *
 */
public class SearchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        
        int x = 0;
        for (int i = 0; i < width && i < height; i++) {
            if (matrix[i][i] >= target) {
                break;
            }
            x++;
        }
        for (int i = 0; i <= x && i < height; i++) {
            for (int j = x; j < width; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] > target) {
                    break;
                }
            }
        }
        
        for (int i = x; i < height; i++) {
            for (int j = 0; j <= x && j < width; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] > target) {
                    break;
                }
            }
        }
        
        return false;
    }
	/**
	 * 因为矩阵的行和列是排序的（分别从左到右和从上到下），
	 * 所以在查看任何特定值时，我们可以修剪O(m)O(m)或O(n)O(n)元素。
	 * 
	 * 复杂度分析

时间复杂度：O(n+m)。
时间复杂度分析的关键是注意到在每次迭代（我们不返回 true）时，行或列都会精确地递减/递增一次。
由于行只能减少 m 次，而列只能增加 n 次，因此在导致 while 循环终止之前，循环不能运行超过 n+m 次。
因为所有其他的工作都是常数，所以总的时间复杂度在矩阵维数之和中是线性的。
空间复杂度：O(1)，因为这种方法只处理几个指针，所以它的内存占用是恒定的。

作者：LeetCode
链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/sou-suo-er-wei-ju-zhen-ii-by-leetcode-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return false;
        int i=0;
        int j=matrix[0].length-1;
        
        while(i<matrix.length&&j>=0){
            if(matrix[i][j]==target)
                return true;
            else if(matrix[i][j]>target)
                j--;
            else 
                i++;
            
        }
        return false;
        
    }
    public boolean searchMatrix1(int[][] matrix, int target) {
    	if(matrix.length==0)return false;
        int left=0;
        int right=matrix[0].length;
        for(int i=0;i<matrix.length;i++) {
        	if(matrix[i][matrix[0].length-1]<target ||
        			matrix[i][0]>target
        			)continue;
        	int mid=(left+right)>>1;
        	while(left<right) {
        		if(matrix[i][mid]>target) {
        			right=mid-1;
        		}else if(matrix[i][mid]<target){
        			left=mid+1;
        		}else {
        			return true;
        		}
        	}
        }
        return false;
    }
}
