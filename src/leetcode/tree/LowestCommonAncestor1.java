package leetcode.tree;

/**
 * 二叉搜索树的最近公共祖先
给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]

示例 1:

输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6 
解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * @author zxl
 *
 */
public class LowestCommonAncestor1 {
	private static final TreeNode none=new TreeNode(0);
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root.val>p.val && root.val>q.val) {
    		lowestCommonAncestor(root.left, p, q);
    	}else if(root.val<p.val && root.val<q.val) {
    		lowestCommonAncestor(root.right, p, q);
    	}
    	return root;
//		return find(root,p,q);
    }

    //2 1 3      3 1
	private TreeNode find(TreeNode root, TreeNode p, TreeNode q) {

		if(root==p || root==q || root==null ) return root;
		if(p==none && q==none)return null;
		TreeNode l=null;TreeNode r=null;
		//p在右边  q在左边
		if( root.val>p.val) {//p在左边
			if(root.val>q.val) {//q在左边
				l=find(root.left, p, q);
			}else {
				l=find(root.left, p, none);
				r=find(root.right, none, q);
			}
			 
		}else  {//p在右边
			if(root.val>q.val) {//q在左边
				l=find(root.left, none, q);
				l=find(root.right, p,none);
			}else {
				r=find(root.right,p, q);
			}
		}
		
		if((l==null || l==none) && (r==null || r==none)) {
			return null;
		}else if(l==null||l==none) {
			return r;
		}else if(r==null||r==none){
			return l;
		}else {
			return root;
		}
	}
}
