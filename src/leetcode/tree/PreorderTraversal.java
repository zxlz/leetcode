package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
给定一个二叉树，返回它的 前序 遍历。

 示例:

输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [1,2,3]
 * @author zxl
 *
 */
public class PreorderTraversal {
	//递归
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> res=new ArrayList<Integer>();
    		pre(res,root);
    		return res;
    }

	private void pre(List<Integer> res, TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null)return;
		res.add(root.val);
		pre(res,root.left);
		pre(res,root.right);
		
	}
	//迭代
	public List<Integer> inorderTraversal1(TreeNode root) {
		List<Integer> res=new ArrayList<Integer>();
   Stack<TreeNode> stack=new Stack<TreeNode>();
   stack.push(root);
   	while(!stack.isEmpty() ) {
   		root=stack.pop();
   		
   		if(root!=null) {
   			res.add(root.val);
   			stack.push(root.right);
   			stack.push(root.left);
   			
   		}	
   	}
		return res;
   }
}
