package leetcode.tree;

import java.util.HashMap;

/**
 * 从前序与中序遍历序列构造二叉树
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7] 根左右
中序遍历 inorder = [9,3,15,20,7] 左根右
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 * @author zxl
 *
 */
public class BuildTreeByPreIn {
	HashMap<Integer,Integer> hashMap= new HashMap<Integer, Integer>();
	 public TreeNode buildTree(int[] preorder, int[] inorder) {
		 for(int i = 0; i < inorder.length; i++){
	            hashMap.put(inorder[i],i);
	        } 
//	    	TreeNode root=new TreeNode(postorder[postorder.length-1]);
	    	TreeNode root=buildTree(inorder,0,inorder.length-1,preorder,0,preorder.length-1);
	    	
			return root;
	    }

	private TreeNode buildTree(int[] inorder, int l, int r, int[] preorder,int l1, int r1) {
		if(l>r || l1>r1)return null;

		TreeNode res=new TreeNode(preorder[l1]);
		/**
		 * 中序遍历 inorder =  [9,3,15,20,7] 左根右
		 * 前序遍历 preorder = [3,9,20,15,7] 根左右
		  
		 */
//		int inorderIndex=findIndex(inorder,res.val,l,r);
		int inorderIndex=hashMap.get(res.val);
		//r-inorderIndex+1根和右的长度
		//r1-(r-inorderIndex+1);
		res.right=buildTree(inorder, inorderIndex+1, r, preorder, r1-(r-inorderIndex)+1,r1);//递归右子树。  
		res.left=buildTree(inorder, l, inorderIndex-1, preorder,l1+1, r1-(r-inorderIndex));//递归左子树。   
		return res;
	}
	//根据值找index
	private int findIndex(int[] inorder, int val, int l, int r) {

		for (int i = l; i < r+1; i++) {
			if(inorder[i]==val)return i;
		}
		return -1;
	}
}
