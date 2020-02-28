package leetcode.queueStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 克隆图
给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。

图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。

class Node {
    public int val;
    public List<Node> neighbors;
}
节点数介于 1 到 100 之间。
每个节点值都是唯一的。
无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
图是连通图，你可以从给定节点访问到所有节点。

 * @author zxl
 *
 */
public class CloneGraph {
	Node[] cache=new Node[100];
    public Node cloneGraph(Node node) {
    	if(node==null)return null;
    	if(cache[node.val]!=null) {
    		return cache[node.val];
    	}
    	Node newNode =new Node(node.val);
    	cache[node.val]=newNode;
    	List<Node> list=node.neighbors;
    	List<Node> newList=new ArrayList<Node>(node.neighbors.size());
    	for(Node n:list) {
    		newList.add(cloneGraph(n));
    	}
    	newNode.neighbors=newList;
    	
        return newNode;
    }
    
}
