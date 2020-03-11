package leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的锯齿形层次遍历
给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：

[
  [3],
  [20,9],
  [15,7]
]
 * @author zxl
 *
 */
public class ZigzagLevelOrder {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if(root==null)return new LinkedList<List<Integer>>();
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		queue.offer(root);
		boolean inverse= false;
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new LinkedList<Integer>();
			while(size--!=0) {
				TreeNode node= queue.poll();
				if(inverse) {
					list.add(0, node.val);
					//stack.push(node);
				}else {
					list.add(node.val);
				}
				if(node.left!=null)queue.offer(node.left);
				if(node.right!=null)queue.offer(node.right);
			}
//			if(inverse) {
//				
//				while(!stack.isEmpty()) {
//					list.add(stack.pop().val);
//				}
//				
//			}
			res.add(list);
			inverse=!inverse;
		}
		return res;
	}
}
