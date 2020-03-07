package leetcode.nTree;

import java.util.List;

/**
 * Maximum Depth of N-ary Tree
给定一个 N 叉树，找到其最大深度。

最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。


说明:

树的深度不会超过 1000。
树的节点总不会超过 5000。
 * @author zxl
 *
 */
public class MaxDepth {
    public int maxDepth(Node root) {
    	if(root==null)return 0;
    	List<Node> ch =root.children;
    	int layer = 0;
    	for(int i=0 ;i<ch.size();i++) {
    		int t=maxDepth(ch.get(i));
    		if(layer<t)layer=t;
    	}
    	return layer+1;
    }
    
}
