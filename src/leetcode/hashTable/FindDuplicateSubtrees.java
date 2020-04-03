package leetcode.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import leetcode.tree.TreeNode;

/**
 *  寻找重复的子树
给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。

两棵树重复是指它们具有相同的结构以及相同的结点值。

示例 1：

        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
下面是两个重复的子树：

      2
     /
    4
和

    4
因此，你需要以列表的形式返回上述重复子树的根结点。
 * @author zxl
 *
 */
public class FindDuplicateSubtrees {
//	HashMap<String, Integer> map=new HashMap<String, Integer>();
//	List<TreeNode> res=new ArrayList<TreeNode>();
//    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//    	
//    	dfs(root);
//    	return res;
//    }
//
//	private String dfs(TreeNode root) {
//
//		if(root==null) return "#";
//			String temp=root.val+dfs(root.left)+dfs(root.right);
//		Integer i=map.get(temp);
//		if(i==null) {
//			map.put(temp, ++i);
//		}else if( i==1) {
//			res.add(root);
//			map.put(temp, ++i);
//		}
//		return temp;
//	}
	
	Map<Integer, Integer> map = new HashMap<>();
    List<TreeNode> rr = new LinkedList<>();

    int lfs(TreeNode r) {
        if (r == null)
            return 3524335;
        int t = r.val, l = lfs(r.left), ri = lfs(r.right);
        t = ((23^l)*3423443 + (33^ri))*3423443 + t;
        if (map.containsKey(t)) {
            if (map.get(t) == 1){
                rr.add(r);
                map.put(t, map.get(t) + 1);
            }
        } else {
            map.put(t, 1);
        }
        return t;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        lfs(root);
        return rr;
    }
    
}
