package leetcode.treesAndGraphs2;

import java.util.LinkedList;
import java.util.Queue;

public class ClassSchedule2 {
	
	 public  int[] findOrder(int numCourses, int[][] prerequisites) {
	    	int[] indegrees = new int[numCourses];//记录每个课程的入度
	    	for (int[] is : prerequisites) {
				indegrees[is[0]]++;//初始化入度
			}
	    	int[] order = new int[numCourses];
	    	Queue<Integer> queue = new LinkedList<Integer>();
	    	for (int i = 0; i < numCourses; i++) {
				if(indegrees[i]==0) {
					queue.offer(i);//入度为0的入队列
				}
			}
	    	while(!queue.isEmpty()) {
	    		int tar=queue.poll();
	    		numCourses--;//入度为0的课程--
	    		order[order.length-1-numCourses]=tar;
	    		for (int i = 0; i < prerequisites.length; i++) {
					if(prerequisites[i][1]==tar && --indegrees[prerequisites[i][0]]==0) {
						queue.offer(prerequisites[i][0]);
					}
				}
	    	}
	    	return numCourses==0?order:new int[] {};
	    }
}
