package leetcode.tree;

import java.util.LinkedList;

/**
 * 验证二叉搜索树
给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * @author zxl
 *
 */
public class IsValidBST {
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
	public boolean isValidBST(TreeNode root,long minValue,long maxValue) {
		if(root==null) {
			return true;
		}
		boolean l;
		boolean  r;
		if(root.left==null || (root.left.val<root.val && root.left.val>minValue) ) {
			l= isValidBST(root.left,minValue,root.val);
		}else {
			return false;
		}
		
		if(root.right==null || (root.right.val>root.val && root.right.val<maxValue)) {
			r= isValidBST(root.right,root.val,maxValue);
		}else {
			return false;
		}
		return l&& r;
    }
}
