package leetcode.treesAndGraphs2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 课程表
现在你总共有 n 门课需要选，记为 0 到 n-1。

在选修某些课程之前需要一些先修课程。 
例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？

示例 1:

输入: 2, [[1,0]] 
输出: true
解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
示例 2:

输入: 2, [[1,0],[0,1]]
输出: false
解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
说明:

输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。
提示:

这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
拓扑排序也可以通过 BFS 完成。
 * @author zxl
 *
 */
public class ClassSchedule {
	//dfs
	public boolean canFinish1(int numCourses, int[][] prerequisites) {
        int[][] adjacency = new int[numCourses][numCourses];
        int[] flags = new int[numCourses];
        for(int[] cp : prerequisites)
            adjacency[cp[1]][cp[0]] = 1;
        for(int i = 0; i < numCourses; i++){
            if(!dfs(adjacency, flags, i)) return false;
        }
        return true;
    }
	// 0 <-1    1 3  3  1
	// 1->0  3->1  1->3
    private boolean dfs(int[][] adjacency, int[] flags, int i) {
        if(flags[i] == 1) return false;
        if(flags[i] == -1) return true;
        flags[i] = 1;
        for(int j = 0; j < adjacency.length; j++) {
            if(adjacency[i][j] == 1 && !dfs(adjacency, flags, j)) return false;
        }
        flags[i] = -1;
        return true;
    }
	//bfs
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	int[] indegrees = new int[numCourses];//记录每个课程的入度
    	for (int[] is : prerequisites) {
			indegrees[is[0]]++;//初始化入度
		}
    	Queue<Integer> queue = new LinkedList<Integer>();
    	for (int i = 0; i < numCourses; i++) {
			if(indegrees[i]==0)queue.offer(i);//入度为0的入队列
		}
    	while(!queue.isEmpty()) {
    		int tar=queue.poll();
    		numCourses--;//入度为0的课程--
    		for (int i = 0; i < prerequisites.length; i++) {
				if(prerequisites[i][1]==tar && --indegrees[prerequisites[i][0]]==0) {
					queue.offer(prerequisites[i][0]);
				}
			}
    	}
    	return numCourses==0;
    }
}
