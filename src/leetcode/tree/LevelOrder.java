package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历
给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
 * @author zxl
 *
 */
public class LevelOrder {
	public List<List<Integer>> levelOrder(TreeNode root) {
		 
		if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>>  res = new ArrayList<>();
		Queue<TreeNode> que=new LinkedList<TreeNode>();
		que.add(root);
		while(!que.isEmpty()) {
			int count = que.size();
			
			List<Integer> list = new ArrayList<>();
			while(count>0) {
				TreeNode node=que.poll();
				list.add(node.val);
				if(node.left!=null) {
					que.add(node.left);
				}
				if(node.right!=null) {
					que.add(node.right);
				}
				count--;
			}
			res.add(list);
			
		}
		 
		return res;
        
    }
}
