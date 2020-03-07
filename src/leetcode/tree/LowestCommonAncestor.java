package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  二叉树的最近公共祖先
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉树中。

 * @author zxl
 *
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	
    	TreeNode res=find(root,p,q);
    	return res;
    }
	private TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
		if(root==p || root == q || root==null)return root;
		TreeNode l=find(root.left,p,q);
		TreeNode r=find(root.right,p,q);
		if(l!=null && r!=null) {
			return root;
		}else if(l==null && r==null) {
			return null;
		}else if(l==null) {
			return r;
		}else {
			return l;
		}
		
	}
}
