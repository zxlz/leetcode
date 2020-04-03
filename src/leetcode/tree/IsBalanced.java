package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 平衡二叉树
给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

示例 1:

给定二叉树 [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7
返回 true 。
 * @author zxl
 *
 */
public class IsBalanced {
	 public boolean isBalanced(TreeNode root) {
		 return findLevel(root)!=0;
	 }
	
	private int findLevel(TreeNode root) {

			if(root==null)return 1;
			int l=findLevel(root.left);
			if(l==0)return 0;
			int r=findLevel(root.right);
			if(r==0)return 0;
			if(l-r>1 || l-r<-1) {
				return 0;
			}
			return Math.max(l, r)+1;
		
	}

	//完全平衡
    public boolean isBalanced1(TreeNode root) {
    	if(root==null)return true;
    	Queue<TreeNode> queue=new LinkedList<TreeNode>();
    	queue.offer(root);
    	boolean isLeaf=false;
    	boolean checkLast=false;
    	while(!queue.isEmpty()) {
    		int size=queue.size();
    		while(size--!=0) {
    			TreeNode node= queue.poll();
    			if(node.left!=null) {
    				if(checkLast)return false;
    				queue.add(node.left);
				}else {
					isLeaf=true;
				}
				if(node.right!=null) {
					if(checkLast)return false;
					queue.add(node.right);
				}else {
					isLeaf=true;
				}
    		}
    		if(isLeaf)checkLast=true;
    	}
    	return true;
    }
}
