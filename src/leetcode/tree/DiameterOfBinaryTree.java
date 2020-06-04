package leetcode.tree;

/**
 * 543. 二叉树的直径
给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
这条路径可能穿过也可能不穿过根结点。

示例 :
给定二叉树

          1
         / \
        2   3
       / \     
      4   5    
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * @author zxl
 *
 */
public class DiameterOfBinaryTree {
	int res= 0;
    public int diameterOfBinaryTree(TreeNode root) {
    	dfs(root);
    	return res;
    }
	private int dfs(TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null) return 0;
		int l=dfs(root.left);
		int r=dfs(root.right);
		if(res<l+r)res=l+r;
		return Math.max(l, r)+1;
	}
}
