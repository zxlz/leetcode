package leetcode.tree;

import java.util.TreeMap;

public class DeleteNode {
	/**
	 * 1. 如果节点没有子女，修改其父节点指针为NULL，删除即可
		2. 如果该节点有左孩子情况，修改其父亲节点的指针和其左孩子的parent指针即可
		3. 如果该节点有右孩子情况，修改其父亲节点的指针和其右孩子的parent指针即可
		4.如果同时有左右孩子的情况，情况比较复杂，一般有2种方法处理
		    1） 用节点右边孩子的最小值替换该节点，其他节点位置保持不变（本篇用这种方法）
		    2）用节点左边孩子的最大值替换该节点，其他节点位置保持不变

	 * @param root
	 * @param key
	 * @return
	 */
    public TreeNode deleteNode(TreeNode root, int key) {
    	TreeNode node=root;
    	TreeNode nodeP=null;
    	while(node!=null) {
    		if(node.val>key) {
    			nodeP=node;
    			node=node.left;
    		}else if(node.val<key) {
    			nodeP=node;
    			node=node.right;
    		}else {
    			break;
    		}
    		
    	}
    	if(node==null)return root;
    	// If strictly internal, copy successor's element to node and then make node
    	if (node.left != null && node.right != null) {
//    		node = successor(node);
    		 nodeP=node;
    		 TreeNode temp = node.right;
             while (temp.left != null) {
            	 nodeP=temp;
            	 temp = temp.left;
             }
             node.val=temp.val;//
             node=temp;
        } // p has 2 children
    	// Start fixup at replacement node, if it exists.
    	TreeNode replacement=(node.left!=null?node.left:node.right);
    	if(replacement!=null) {//
    		// Link replacement to parent
    		if(nodeP==null) 
    			return replacement;
    		else if(node==nodeP.left)
    			nodeP.left=replacement;
    		else
    			nodeP.right=replacement;
    	}else if(nodeP==null) {
    		return null;
    	}else {
                if (node == nodeP.left)
                	nodeP.left = null;
                else if (node == nodeP.right)
                	nodeP.right = null;
    	}
//    	if(node.left==null && node.right==null) {
//			if (nodeP == null) {
//				return null;
//			}
//    	}else if(node.left==null) {
//    		if (nodeP == null) {
//				return node.right;
//			} else if (isLeft) {
//				nodeP.left = node.right;
//			} else {
//				nodeP.right = node.right;
//			}
//    	}else if(node.right==null) {
//    		if (nodeP == null) {
//				return node.left;
//			} else if (isLeft) {
//				nodeP.left = node.left;
//			} else {
//				nodeP.right = node.left;
//			}
//    	}else {
//    		
//    	}
		return root;
    	
    }
    
    /**
     * 为什么treemap的删除是要找后继节点？？（可能为了保持平衡，右边没有时找parent上的后继节点，移到上面？）
     * Returns the successor of the specified Entry, or null if no such.
    
    static TreeNode successor(TreeNode t) {
        if (t == null)
            return null;
        else if (t.right != null) {
        	TreeNode p = t.right;
            while (p.left != null)
                p = p.left;
            return p;
        } else {
        	TreeNode p = t.parent;
        	TreeNode ch = t;
            while (p != null && ch == p.right) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }
   */
    /*
   *
     * 
     * 
     
     * Delete node p, and then rebalance the tree.
     
    private void deleteEntry(Entry<K,V> p) {
        modCount++;
        size--;

        // If strictly internal, copy successor's element to p and then make p
        // point to successor.
        if (p.left != null && p.right != null) {
            Entry<K,V> s = successor(p);
            p.key = s.key;
            p.value = s.value;
            p = s;
        } // p has 2 children

        // Start fixup at replacement node, if it exists.
         replacement 只有right 则换右
         			 只有left，则left
         			 都有，  right部分最大的node的right（可能null）
        Entry<K,V> replacement = (p.left != null ? p.left : p.right);

        if (replacement != null) {
            // Link replacement to parent
            replacement.parent = p.parent;
            if (p.parent == null)
                root = replacement;
            else if (p == p.parent.left)
                p.parent.left  = replacement;
            else
                p.parent.right = replacement;

            // Null out links so they are OK to use by fixAfterDeletion.
            p.left = p.right = p.parent = null;

            // Fix replacement
            if (p.color == BLACK)
                fixAfterDeletion(replacement);
        } else if (p.parent == null) { // return if we are the only node.
            root = null;
        } else { //  No children. Use self as phantom replacement and unlink.
            if (p.color == BLACK)
                fixAfterDeletion(p);

            if (p.parent != null) {
                if (p == p.parent.left)
                    p.parent.left = null;
                else if (p == p.parent.right)
                    p.parent.right = null;
                p.parent = null;
            }
        }
    }
     */
}
