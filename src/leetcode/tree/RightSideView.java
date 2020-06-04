package leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 199. 二叉树的右视图
给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例:

输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 * @author zxl
 *
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> res= new LinkedList<Integer>();
        if(root==null)return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res.add(queue.peek().val);
            while(size-->0) {
                TreeNode e = queue.poll();
                if(e.right!=null)queue.offer(e.right);
                if(e.left!=null)queue.offer(e.left);
            }
        }
        return res;
    }
}
