package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
	List<Integer> list=new ArrayList<Integer>();
	 public List<Integer> inorderTraversal(TreeNode root) {
        //递归版
		// ldr(root);
		// return list;
   Stack<TreeNode> stack=new Stack<TreeNode>();
   	
   	while(!stack.isEmpty() || (root!=null)) {
   		if(root!=null) {
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

//	private void ldr(TreeNode root) {
//
//		if(root!=null) {
//			ldr(root.left);
//			list.add(root.val);
//			ldr(root.right);
//		}
		
//	}
}
