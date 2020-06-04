package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GetAllElements {
    //方法1：tree合并后中序遍历
    //方法2：中序遍历后合并
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> tree1 = new ArrayList<>();
        List<Integer> tree2 = new ArrayList<>();

        List<Integer> res = new ArrayList<>(tree1.size()+tree2.size());
        inOrderRecur(tree1, root1);
        inOrderRecur(tree2, root2);
        int i1=0,i2=0;
        while (i1<tree1.size() && i2<tree2.size()){
            if( tree1.get(i1)<tree2.get(i2)){
                res.add(tree1.get(i1));
                i1++;
            }else{
                res.add(tree2.get(i2));
                i2++;
            }
        }
        while(i1<tree1.size() ){
            res.add(tree1.get(i1));
            i1++;
        }
        while(i2<tree2.size() ){
            res.add(tree2.get(i2));
            i2++;
        }
        return res;
    }

    private void inOrderRecur(List<Integer> tree1, TreeNode root) {
        if (root == null) return;
        inOrderRecur(tree1, root.left);
        tree1.add(root.val);
        inOrderRecur(tree1, root.right);
    }
}
