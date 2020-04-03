package leetcode.tree;
/**
 * 对称二叉树
给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
 * @author zxl
 *
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
    	
		return checkSymmetric(root.left,root.right);
        
    }

	private boolean checkSymmetric(TreeNode left, TreeNode right) {

		if(left==null )return right==null;
		if(right==null)return false;
		
		return checkSymmetric(left.left,right.right) && checkSymmetric(left.right,right.left);
	}
}
