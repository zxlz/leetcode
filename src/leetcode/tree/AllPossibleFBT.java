package leetcode.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 894. 所有可能的满二叉树
 * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
 *
 * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
 *
 * 答案中每个树的每个结点都必须有 node.val=0。
 *
 * 你可以按任何顺序返回树的最终列表。
 *
 *
 *
 * 示例：
 *
 * 输入：7
 * 输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * 1 <= N <= 20
 */
public class AllPossibleFBT {
    List[] cache = new List[21];
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> list = new LinkedList();
        if(cache[N]==null){
            if(N==1){
                list.add(new TreeNode(0));
            }else if((N&1)==1){
                for (int leftCh = 0; leftCh < N; leftCh++) {//找出左子树数量和右子树数量的所有情况
                    int rightCh=N-leftCh-1;
                    for(TreeNode lt:allPossibleFBT(leftCh)){
                        for (TreeNode rt:allPossibleFBT(rightCh)){
                            TreeNode root =new TreeNode(0);
                            root.left=lt;
                            root.right=rt;
                            list.add(root);
                        }
                    }
                }
            }
            cache[N]=list;
        }else{
            return cache[N];
        }
        return list;
    }
}
