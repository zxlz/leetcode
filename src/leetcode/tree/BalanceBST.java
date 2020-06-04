package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 1382. 将二叉搜索树变平衡
 * 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
 *
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
 *
 * 如果有多种构造方法，请你返回任意一种。
 */
public class BalanceBST {
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        inorderTraversal(root,list);

        return buildAVLTree(list,0,list.size()-1);
    }

    private TreeNode buildAVLTree(List<TreeNode> list, int start, int end) {
        if(start<=end){
            int mid = (end+start)/2;
            TreeNode node = list.get(mid);
            node.left=buildAVLTree(list,start,mid-1);
            node.right=buildAVLTree(list,mid+1,end);
            return node;
        }
        return null;
    }

    private void inorderTraversal(TreeNode root,List list) {
        if(root==null)return;
        inorderTraversal(root.left,list);
        list.add(root);
        inorderTraversal(root.right,list);
    }
}
