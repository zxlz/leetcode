package leetcode.tree;
/**
 * 
 *  将有序数组转换为二叉搜索树
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
 * @author zxl
 *
 */

public class SortedArrayToBST {
	/**
	 * 取中，建节点，左侧继续，右侧继续
	 * @param nums
	 * @return
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		return toBST(nums,0,nums.length-1);
    }

	public TreeNode toBST(int[] nums, int left, int right) {

		if(left > right) return null;
        int center = (right+left)>>1;
		TreeNode root=new TreeNode(nums[center]);
			root.left=toBST(nums,left,center-1);
			root.right=toBST(nums,center+1,right);
			return root;
        
     
	}
}
