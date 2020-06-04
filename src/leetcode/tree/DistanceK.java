package leetcode.tree;

import java.util.LinkedList;
import java.util.List;

public class DistanceK {
    List<Integer> res;
    TreeNode target;
    int k;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k1) {
        // System.out.println(target.val+"--"+k1);
        res=new LinkedList<>();
        this.target=target;
        this.k=k1;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode tree) {
        if(tree==null){
            return -1;
        }else if(tree==target){
            findUnderK(tree,k);
            return 1;
        }else{
            int leftLen = dfs(tree.left);//左子树target距离
            int rightLen = dfs(tree.right);//右子树target距离
            if(leftLen!=-1){
                if(leftLen==k)res.add(tree.val);
                findUnderK(tree.right,k-leftLen-1);
                return leftLen+1;
            }else if(rightLen!=-1){
                if(rightLen==k)res.add(tree.val);
                findUnderK(tree.left,k-rightLen-1);
                return rightLen+1;
            }else {
                return -1;
            }
        }
    }

    private void findUnderK(TreeNode node, int dist) {

        if(node==null || dist<0){

        }else if(dist==0){
            res.add(node.val);
        }else{
            findUnderK(node.left,dist-1);
            findUnderK(node.right,dist-1);
        }
    }
}
