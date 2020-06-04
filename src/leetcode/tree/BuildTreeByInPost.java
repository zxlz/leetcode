package leetcode.tree;

import java.util.HashMap;

/**
 * 从中序与后序遍历序列构造二叉树
根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

中序遍历 inorder = [1，9,3,15,20,7]    左根右
后序遍历 postorder = [1，9,15,7,20,3]  左右跟
返回如下的二叉树：

    3
   / \
  9  20
    /  \
1   15   7
 * @author zxl
 *
 */
public class BuildTreeByInPost {
	HashMap<Integer,Integer> hashMap= new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	for(int i = 0; i < inorder.length; i++){
            hashMap.put(inorder[i],i);
        } 
//    	TreeNode root=new TreeNode(postorder[postorder.length-1]);
    	TreeNode root=buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    	
		return root;

    }

	private TreeNode buildTree(int[] inorder, int l, int r, int[] postorder,int l1, int r1) {
		if(l>r || r1<0)return null;
		// TODO Auto-generated method stub
		TreeNode res=new TreeNode(postorder[r1]);
//		int inorderIndex=findIndex(inorder,res.val,l,r);
		int inorderIndex=hashMap.get(res.val);
		//r-inorderIndex+1根和右的长度
		//r1-(r-inorderIndex+1);
		//
		//后序遍历最后一个必然是根节点
		res.right=buildTree(inorder, inorderIndex+1, r, postorder, r1-(r-inorderIndex+1)+1,r1-1);//递归右子树。  前序的跟 右部分，h后序的除最后一个
		res.left=buildTree(inorder, l, inorderIndex-1, postorder,l1, r1-(r-inorderIndex+1));//递归左子树。   前序的g跟 左部分  h后序的
		return res;
	}
	//根据值找index
	private int findIndex(int[] inorder, int val, int l, int r) {
		// TODO Auto-generated method stub
		for (int i = l; i < r+1; i++) {
			if(inorder[i]==val)return i;
		}
		return -1;
	}
}
