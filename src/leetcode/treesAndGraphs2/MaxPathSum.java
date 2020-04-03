package leetcode.treesAndGraphs2;

import leetcode.tree.TreeNode;

/**
 * 二叉树中的最大路径和
给定一个非空二叉树，返回其最大路径和。

本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

示例 1:

输入: [1,2,3]

       1
      / \
     2   3

输出: 6
示例 2:

输入: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

输出: 42
 * @author zxl
 *
 */
public class MaxPathSum {
	int max=0;
    public int maxPathSum(TreeNode root) {
    	max=root.val;
    	dfs(root);
    	return max;
    }

	private int dfs(TreeNode root) {

		if(root==null)return 0;
    	int l=dfs(root.left);
    	int r=dfs(root.right);
    	int res=root.val;
    	//左右路径取大的且大于0的
    	if(l>0 && r>0) {
    		if(l>r) {
    			res +=l;
    			max=Math.max(res+r,max);
    		}else {
    			res +=r;
    			max=Math.max(res+l,max);
    		}
    		return res;
    	}else if(l>0) {
    		res += l;
    	}else if(r>0) {
    		res +=r;
    	}
    	if(max<res)max=res;
		return res;
	}
}
