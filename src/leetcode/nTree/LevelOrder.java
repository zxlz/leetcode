package leetcode.nTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N叉树的层序遍历
给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * @author zxl
 *
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
    	if(root==null)return new LinkedList<List<Integer>>();
    	Queue<Node> queue = new LinkedList<Node>();
    	List<List<Integer>> res= new LinkedList<List<Integer>>();
    	queue.offer(root);
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		List<Integer> list = new LinkedList<Integer>();
    		res.add(list);
    		while(size-->0) {
    			Node node= queue.poll();
    			if(node!=null) {
    				list.add(node.val);
        			List<Node> ch = node.children;
        			if(ch!=null){
        				for(int i=0;i<ch.size();i++) {
        					queue.offer(ch.get(i));
        				}
        			}
    			}
    		}
    	}
    	return res;
        
    }
}
