package leetcode.tree;

import java.util.Stack;

/**
 * 二叉搜索树中第K小的元素
给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

说明：
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 1
 * @author zxl
 *左根右
 */
public class KthSmallest {
	
    public int kthSmallest(TreeNode root, int k) {
    	int[] maxHeap=new int[k];
    	int next=0;
    	int len=k;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode node =root;
    	while((!stack.isEmpty() || node!=null) && next<len) {
    		if(node !=null) {
    			 node= stack.push(node);
        		 node=node.left;
    		}else {
    			node=stack.pop();
    			maxHeap[next++]=node.val;
    			node=node.right;
    		}
    		
    	}
    	return maxHeap[next-1];
    }
    
}
