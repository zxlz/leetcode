package leetcode.tree;

import sun.management.snmp.jvmmib.JvmMemMgrPoolRelTableMeta;

/**
 * 二叉树剪枝
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 *
 * 返回移除了所有不包含 1 的子树的原二叉树。
 */
public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        if(root==null)return null;

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.left==null && root.right==null && root.val==0)return null;
        return root;
    }

}
