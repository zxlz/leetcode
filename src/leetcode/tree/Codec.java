package leetcode.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

import org.junit.Test;

/**
 * 二叉树的序列化与反序列化
序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。

请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

示例: 

你可以将以下二叉树：

    1
   / \
  2   3
     / \
    4   5

序列化为 "[1,2,3,null,null,4,5]"
提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。

说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 * @author zxl
 *
 */
public class Codec {
	@Test
	public void main() {
		//serialize(null);
		deserialize(serialize(null));
	}
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
//    	TreeMap<K, V>
    	Queue<TreeNode> queue=new LinkedList<TreeNode>();
    	queue.offer(root);
    	StringBuilder s=new StringBuilder();
    	while(!queue.isEmpty()) {
    		int size=queue.size();
    		
    		while(size--!=0) {
    			TreeNode node=queue.poll();
    			if(node==null) {
    				s.append("null,");
    			}else {
    				s.append(node.val+",");
        			queue.offer(node.left);
        			queue.offer(node.right);
    			}
    		}
    	}
		return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	String[] str=data.split(",");
    	if(str.length==0 ||"null".equals(str[0])) {
    		return null;
    	}
//    	Queue<String> allqueue = new LinkedList<String>();
//    	for(String s:str) {
//    		allqueue.offer(s);
//    	}
    	int i=0;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	TreeNode root =new TreeNode(Integer.valueOf(str[i++])) ;
    	queue.offer(root);
    	while(!queue.isEmpty()) {
    		int size=queue.size();
    		while(size--!=0) {
    			//"[1,2,3,null,null,4,5]"
    			TreeNode node=queue.poll();
    			String temp;
    			if(!"null".equals(temp=str[i++])) {
    				node.left=new TreeNode(Integer.valueOf(temp));
            		queue.offer(node.left);
    			}
    			if(!"null".equals(temp=str[i++])) {
    				node.right=new TreeNode(Integer.valueOf(temp));
            		queue.offer(node.right);
    			}
    		}
    	
    	}
		return root;
    }
}
