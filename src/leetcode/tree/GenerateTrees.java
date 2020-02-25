package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

/**
 * 不同的二叉搜索树 II
给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。

示例:

输入: 3
输出:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
解释:
以上的输出对应以下 5 种不同结构的二叉搜索树：

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * @author zxl
 *
 */
public class GenerateTrees {
	@Test
	public void main() {
		generateTrees(3);
	}
    public List<TreeNode> generateTrees(int n) {
    	 
    	List<TreeNode> list= generate(1,n);
    	return list;

    }
 public List<TreeNode> generate(int start,int end) {
	 if(start==end) {
		 List<TreeNode> list = new ArrayList<>();
         TreeNode node = new TreeNode(start);
         list.add(node);
         return list;
	 }
	 List<TreeNode> res= new ArrayList<TreeNode>();
    	for(int i=start;i<=end;i++) {
    		List<TreeNode> left = new ArrayList<>();;
    		List<TreeNode> right = new ArrayList<>();;
    		if(start<i) {
    			left = generate(start,i-1);
    		};
    		if(end>i) {
    			right = generate(i+1,end);
    		};
    		
    		if(!left.isEmpty() && !right.isEmpty()) {
    			for (int j = 0; j < left.size(); j++) {
    				for (int j2 = 0; j2 < right.size(); j2++) {
    					TreeNode node = new TreeNode(i);
    					node.left=left.get(j);
    					node.right=right.get(j2);
    					res.add(node);
    				}
    			}
    		}
    		if(left.isEmpty() && !right.isEmpty()) {
    			for (int j2 = 0; j2 < right.size(); j2++) {
					TreeNode node = new TreeNode(i);
					node.right=right.get(j2);
					res.add(node);
				}
    		}
    		if(!left.isEmpty() && right.isEmpty()) {
    			for (int j = 0; j < left.size(); j++) {
    					TreeNode node = new TreeNode(i);
    					node.left=left.get(j);
    					res.add(node);
    			}
    		}
    	}
		return res;

    }
}
