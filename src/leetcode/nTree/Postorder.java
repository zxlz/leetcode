package leetcode.nTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * N-ary Tree Postorder Traversal
给定一个 N 叉树，返回其节点值的后序遍历。
 * @author zxl
 *
 */
public class Postorder {
    public List<Integer> postorder(Node root) {
        if(root==null)return new LinkedList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        Stack<Node> rstack = new Stack<Node>();
        List<Integer> res = new LinkedList<Integer>();
        stack.add(root);
        while(!stack.isEmpty()) {
        	Node node = stack.pop();
        	if(node!=null) {
        		rstack.add(node);
        		List<Node> list = node.children;
        		if(list!=null) {
        			for(int i =list.size()-1;i>=0;i--) {
        				stack.add(list.get(i));
        			}
        		}
        	}
        }
        
        while(!rstack.isEmpty()) {
        	res.add(rstack.pop().val);
        }
        return res;
    }
}
