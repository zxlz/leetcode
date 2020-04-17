package leetcode.grap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 1192. 查找集群内的「关键连接」
 * 力扣数据中心有 n 台服务器，分别按从 0 到 n-1 的方式进行了编号。
 *
 * 它们之间以「服务器到服务器」点对点的形式相互连接组成了一个内部集群，其中连接 connections 是无向的。
 *
 * 从形式上讲，connections[i] = [a, b] 表示服务器 a 和 b 之间形成连接。任何服务器都可以直接或者间接地通过网络到达任何其他服务器。
 *
 * 「关键连接」是在该集群中的重要连接，也就是说，假如我们将它移除，便会导致某些服务器无法访问其他服务器。
 *
 * 请你以任意顺序返回该集群内的所有 「关键连接」。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * 输出：[[1,3]]
 * 解释：[[3,1]] 也是正确的。
 *
 *
 * 提示：
 *
 * 1 <= n <= 10^5
 * n-1 <= connections.length <= 10^5
 * connections[i][0] != connections[i][1]
 * 不存在重复的连接
 */
public class CriticalConnections {
    @Test
    public void main() {

        List<List<Integer>> grap= new ArrayList<>();
        grap.add(Arrays.asList(0,1));
        grap.add(Arrays.asList(1,2));
        grap.add(Arrays.asList(2,0));
        grap.add(Arrays.asList(1,3));
        System.out.println(criticalConnections(4,grap));

    }
    /**
     * 1.构建邻接表
     * 2.找环
     * 3。无环的边就是结果。
     * 
     * 
     * tarjan算法 修改
     */
    int[] dfn;
    int[] low;
    List<Integer>[] grap;
    List<List<Integer>> res;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        grap = new List[n];
        for (int i = 0; i < n; i++) {
            grap[i]=new ArrayList<>();
        }

        for (int i = 0; i < connections.size(); i++) {//构建邻接图
            int u=connections.get(i).get(0);
            int v=connections.get(i).get(1);

//            List<Integer> listU=grap[u];
//            List<Integer> listV=grap[v];
//            if(listU==null){
//                listU=new ArrayList<>();
//                grap[u]=listU;
//            }
//            if(listV==null){
//                listV=new ArrayList<>();
//                grap[v]=listV;
//            }
            grap[u].add(v);
            grap[v].add(u);
        }
        dfn = new int[n];
        low = new int[n];
         res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(dfn[i]==0){//如果没访问过，
//                Stack<Integer> stack = new Stack<>();
                boolean[] visited = new boolean[n];
                targin(i,0,-1,visited);
            }
        }
        return res;
    }

    private void targin(int i, int dep, int p, boolean[] visited) {
//        stack.push(i);
        visited[i]=true;
        dfn[i]=low[i]=++dep;
        for (int j = 0; j < grap[i].size(); j++) {//边i的邻边
            int v = grap[i].get(j);
            if(v==p)continue;
            if(dfn[v]==0){//如果没访问过，访问
                targin(v,dep,i, visited);
                low[i]=Math.min(low[i],low[v]);
//            }else if(stack.contains(v)){//如果访问过，且在本次线路父路径上
            }else if(visited[v]){//如果访问过，且在本次线路父路径上
                low[i]=Math.min(low[i],dfn[v]);
            }//否则low和dfn就是默认值，
        }
        if(dfn[i]==low[i]){//是强连通
//            int cur;
//            do//去掉所有环中的边
//            {
//                cur=stack.pop();
//            }while(i!=cur);

            if(p!=-1){//有取前一个的话，存入结果。
                res.add(Arrays.asList(i,p));
            }

        }
    }
}
