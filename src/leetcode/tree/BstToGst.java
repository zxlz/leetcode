package leetcode.tree;

/**
 * 1038. 从二叉搜索树到更大和树
 * 给出二叉 搜索 树的根节点，该二叉树的节点值各不相同，修改二叉树，使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 */
public class BstToGst {
    public TreeNode bstToGst(TreeNode root) {

        reserveInorder(root,0);
        return root;
    }

    private int reserveInorder(TreeNode root,int p) {
        if(root==null)return p;
        int r=reserveInorder(root.right,0);
        root.val +=r;
        int l=reserveInorder(root.left,root.val);
        return l;
    }
}
