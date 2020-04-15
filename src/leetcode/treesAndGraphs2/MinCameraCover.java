package leetcode.treesAndGraphs2;

import leetcode.tree.TreeNode;

/**
 * 968. 监控二叉树
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 *
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 *
 * 计算监控树的所有节点所需的最小摄像头数量。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[0,0,null,0,0]
 * 输出：1
 * 解释：如图所示，一台摄像头足以监控所有节点。
 * 提示：
 *
 * 给定树的节点数的范围是 [1, 1000]。
 * 每个节点的值都是 0。
 */
public class MinCameraCover {
    //0没有监控到，1安装了摄像头，2 已经被监视了
    int res=0;
    public int minCameraCover(TreeNode root) {
        if(posOrder(root)==0){
            res++;
        };
        return res;
    }
    //0没有监控到，1安装了摄像头，2 已经被监视了,不需要再被监视
    private int posOrder(TreeNode node) {
        int left=2;
        if(node.left!=null){
            left=posOrder(node.left);
        }
        int right=2;
        if(node.right!=null){
            right=posOrder(node.right);
        }
        if(left==0||right==0){//左右子树有一个没被监视，则本node要一个摄像头
            res++;
            return 1;
        }else if(left==1||right==1){//左右子树有一个为1(有摄像头)，则本node监视了
            return 2;
        } else {//左右子树都被监视了，返回0，没被监室
            return 0;
        }

    }
}
