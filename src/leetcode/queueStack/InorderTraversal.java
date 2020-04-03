package leetcode.queueStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.tree.TreeNode;

/**
 * 二叉树的中序遍历
 * 
 * 左根右
 * @author zxl
 *
 */
public class InorderTraversal {
	List<Integer> list=new ArrayList<Integer>();
	//递归
    public List<Integer> inorderTraversal(TreeNode root) {
    	ldr(root);
		return list;
    }

	private void ldr(TreeNode root) {

		if(root!=null) {
			ldr(root.left);
			list.add(root.val);
			ldr(root.right);
		}
		
	}
	//非递归
	public List<Integer> inorderTraversal1(TreeNode root) {
    	Stack<TreeNode> stack=new Stack<TreeNode>();
    	
    	while(!stack.isEmpty() || !(root==null)) {
    		if(root==null) {
    			stack.push(root);
    			root=root.left;
    		}else {
    			root=stack.pop();
    			list.add(root.val);
    			root = root.right;
    		}
    	}
		return list;
    }
	
	
}
