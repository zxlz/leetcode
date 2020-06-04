package leetcode.grap;

import org.junit.Test;

import java.util.*;

/**
 * 815. 公交路线
 * 我们有一系列公交路线。每一条路线 routes[i] 上都有一辆公交车在上面循环行驶。例如，有一条路线 routes[0] = [1, 5, 7]，表示第一辆 (下标为0) 公交车会一直按照 1->5->7->1->5->7->1->... 的车站路线行驶。
 *
 * 假设我们从 S 车站开始（初始时不在公交车上），要去往 T 站。 期间仅可乘坐公交车，求出最少乘坐的公交车数量。返回 -1 表示不可能到达终点车站。
 *
 * 示例:
 * 输入:
 * routes = [[1, 2, 7], [3, 6, 7]]
 * S = 1
 * T = 6
 * 输出: 2
 * 解释:
 * 最优策略是先乘坐第一辆公交车到达车站 7, 然后换乘第二辆公交车到车站 6。
 * 说明:
 *
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 500.
 * 0 <= routes[i][j] < 10 ^ 6.
 */
public class NumBusesToDestination {
    @Test
    public void main() {
        int[][] a=new int[][]{{10,13,22,28,32,35,43},
                {2,11,15,25,27},
                {6,13,18,25,42},
                {5,6,20,27,37,47},
                {7,11,19,23,35},
                {7,11,17,25,31,43,46,48},
                {1,4,10,16,25,26,46},
                {7,11},
                {3,9,19,20,21,24,32,45,46,49},
                {11,41}};
        System.out.println(numBusesToDestination(a,37,43));
    }
    /**
     * [[10,13,22,28,32,35,43],        0E
     * [2,11,15,25,27],
     * [6,13,18,25,42],
     * [5,6,20,27,37,47],   3S
     * [7,11,19,23,35],
     * [7,11,17,25,31,43,46,48],      5E
     * [1,4,10,16,25,26,46],
     * [7,11],
     * [3,9,19,20,21,24,32,45,46,49],  8
     * [11,41]]
     * 37
     * 43
     * 输出
     * -1
     * stdout
     * 0end
     * 5end
     * 8
     * 预期结果
     * 3
     * @param routes
     * @param S
     * @param T
     * @return
     */
    public int numBusesToDestination(int[][] routes, int S, int T) {
        //一条公交路线作为一个点， 两个路线有交集车站即存在边， 结果是找图中的S到T最短路径, bfs，   找交集点可排序双指针,或hash
        if(S==T)return 0;
        //
        List<List> grap = new ArrayList<>();
        for (int i = 0; i <routes.length ; i++) {
            Arrays.sort(routes[i]);//排序.方便判断否有边
            grap.add(new ArrayList());//初始化图中的点
        }

        Queue<Integer> queue = new LinkedList<>();

        Set<Integer> visited=new HashSet<>();
        Set<Integer> ends=new HashSet<>();
        //构建邻接图关系  ,同时找出起点和终点。
        for (int i = 0; i < routes.length; i++) {
            boolean isStart=Arrays.binarySearch(routes[i],S)>=0;
            boolean isEnd=Arrays.binarySearch(routes[i],T)>=0;
            //判断是否是起点或终点。
            if(isStart && isEnd)return 1;
            if(isStart){
                visited.add(i);
                queue.offer(i);
            }
            if (isEnd){
//                System.out.println(i+"end");
                ends.add(i);
            }
            //构造点i的边
            for (int j = i + 1; j < routes.length; j++) {
                if (canLink(routes[i], routes[j])) {
                    grap.get(i).add(j);
                    grap.get(j).add(i);
                }
            }
        }

        int dep=0;
        //对grap从starts的点开始进行bfs，每层判断到终点没
        while (!queue.isEmpty()){
            int size=queue.size();
            dep++;
            while(size-->0) {
                int cur = queue.poll();//取出一个点判断。
                List<Integer> curLink = grap.get(cur);
                //如果不是终点，且没访问过，加入queue下一层
                for (int i = 0; i < curLink.size(); i++) {

                    int x = curLink.get(i);
//                    System.out.println(x);
                    if (ends.contains(x)) {//如果结束点包含，返回路径长度
                        return dep + 1;
                    }

                    if (visited.add(x)) {//如果添加成功，放入下一层
//                        System.out.println(x+"NEXT");
                        queue.offer(x);
                    }
                }

            }
        }
        return -1;
    }

    private boolean canLink(int[] arr1, int[] arr2) {
        int i1 = 0,i2=0;
        while(i1<arr1.length && i2<arr2.length){
            if(arr1[i1]<arr2[i2]){
                i1++;
            }else if (arr1[i1]>arr2[i2]){
                i2++;
            }else{
                return true;
            }
        }
        return false;
    }
}
