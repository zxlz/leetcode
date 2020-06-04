package leetcode.nTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * N-ary Tree Preorder Traversal
给定一个 N 叉树，返回其节点值的前序遍历。

例如，给定一个 3叉树 :

 



 

返回其前序遍历: [1,3,5,6,2,4]。

 

说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * @author zxl
 *
 */
public class Preorder {
    public List<Integer> preorder(Node root) {
    	if(root==null)return new LinkedList<Integer>();
    	Stack<Node> stack = new Stack<Node>();
    	stack.push(root);
    	List<Integer> res=new LinkedList<Integer>();
    	res.add(root.val);
    	while(!stack.isEmpty()) {
    		
    			Node node=stack.pop();
    			if(node!=null) {
    				res.add(node.val);
        			if(!node.children.isEmpty() && node.children.size()>0) {
        				for(int i =node.children.size()-1;i>=0;i--) {
        					stack.add(node.children.get(i));
        				}
        			}
    			}
    			
    		
    	}
		return res;
        
    }
}
