package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历
给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [3,2,1]
 * @author zxl
 *
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> res=new ArrayList<Integer>();
//    	postorder(res,root);
//    	return res;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	Stack<TreeNode> rStack = new Stack<TreeNode>();
    	
    	stack.push(root);
    	while (!stack.isEmpty()) {
			root=stack.pop();
			if(root!=null) {
					rStack.push(root);//后续遍历，根节点要最后，所以需要另一个栈放到栈底
					stack.push(root.left);
					stack.push(root.right);
					
			}
		}
    	while (!rStack.isEmpty()) {
			res.add(rStack.pop().val);
		}
    	return res;
    }

	private void postorder(List<Integer> res, TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null)return;
		postorder(res, root.left);
		postorder(res, root.right);
		res.add(root.val);
		
	}
}
