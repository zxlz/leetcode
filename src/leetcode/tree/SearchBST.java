package leetcode.tree;


/**
 * Search in a Binary Search Tree
给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * @author zxl
 *
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
    	if(root==null)return null;
    	if(root.val>val) {
    		return searchBST(root.left,val);
    	}else if(root.val<val) {
    		return searchBST(root.right,val);
    	}
    	
		return root;

    }
    /**
     *  final Entry<K,V> getEntry(Object key) {
        // Offload comparator-based version for sake of performance
        if (comparator != null)
            return getEntryUsingComparator(key);
        if (key == null)
            throw new NullPointerException();
        @SuppressWarnings("unchecked")
            Comparable<? super K> k = (Comparable<? super K>) key;
        Entry<K,V> p = root;
        while (p != null) {
            int cmp = k.compareTo(p.key);
            if (cmp < 0)
                p = p.left;
            else if (cmp > 0)
                p = p.right;
            else
                return p;
        }
        return null;
    }
     */
}
