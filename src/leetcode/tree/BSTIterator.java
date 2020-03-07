package leetcode.tree;

import java.util.Stack;
public class BSTIterator {
	Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
    	stack= new Stack<TreeNode>();
    	findLeft(root);
    }
    
    private void findLeft(TreeNode root) {
		// TODO Auto-generated method stub
    	while(root!=null) {
    		stack.push(root);
    		root=root.left;
    	}
	}
//	//左根右
//    private void ldr(TreeNode root) {
//		// TODO Auto-generated method stub
//    	if(root==null)return;
//    	ldr(root.left);
//    	queue.offer(root.val);
//    	ldr(root.right);
//	}
	/** @return the next smallest number */
    public int next() {
    	TreeNode node=stack.pop();
    	if(node.right!=null) {
    		findLeft(node.right);
    	}
    	return node.val;
    }
    /**
     * Returns the successor of the specified Entry, or null if no such.
     */
    //这是treeMap的取next，用的parent引用，这里没有parent引用，
    //所以用莫里斯遍历法 ，用stackb保存一侧的顺序，这样就有了父节点的引用，只有O(h)的空间大小。
//    static TreeNode successor(TreeNode t) {
//        if (t == null)
//            return null;
//        else if (t.right != null) {
//        	TreeNode p = t.right;
//            while (p.left != null)
//                p = p.left;
//            return p;
//        } else {
//        	TreeNode p = t.parent;
//        	TreeNode ch = t;
//            while (p != null && ch == p.right) {
//                ch = p;
//                p = p.parent;
//            }
//            return p;
//        }
//    }
//
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	return !stack.isEmpty();
    }
}
