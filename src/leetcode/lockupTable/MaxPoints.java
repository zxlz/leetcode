package leetcode.lockupTable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

/**
 * 直线上最多的点数
给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。

示例 1:

输入: [[1,1],[2,2],[3,3]]
输出: 3
解释:
^
|
|        o
|     o
|  o  
+------------->
0  1  2  3  4
 * @author zxl
 *
 */
public class MaxPoints {
	public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
	public String getSign(int a, int b) {
		if (a <= 0 && b <= 0 || a >= 0 && b >= 0)
		    return "+";
		else 
		    return "-";
		}
    public int maxPoints(int[][] points) {
    	if(points.length<2)return 0;
    	if(points.length==2)return 2;
//    	HashMap<String, Set<Integer>> map = new HashMap<String, Set<Integer>>();
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	//存已访问的直线的点和数量，
    	 int res=2;
    	 int xcount=0;
    	 int ycount=0;
    	 int max=0;
    	 int allPoints=0;
    	for (int i = 0; i < points.length-2; i++) {
    		
    		for (int j = i+1; j < points.length; j++) {
    			
    			
    			int a=points[i][1]-points[j][1];
    			int b=points[i][0]-points[j][0];
    			if(b==0) {
        			if(a==0) {
        				allPoints++;
        				continue;
        			}else {
        				if(++xcount>max)max=xcount;
        			}
        		}else if(a==0) {
        			if(++ycount>max)max=ycount;
        		}
    			
    			int gcd=gcd(a, b);
    			
    			String str=getSign(a,b)+a/gcd+"-"+b/gcd;
    			
    			map.put(str,map.getOrDefault(str, 1)+1);
    			if(map.get(str)>max)max=map.get(str);
			}
    		if(max+allPoints>res)res=max+allPoints;
    		map.clear();
    		xcount=1;
    		ycount=1;
    		max=0;
		}
    	return res;

    }
    public int maxPoints1(int[][] points) {

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Math.abs(o1[0]-o1[1]) - Math.abs(o2[0]-o2[1]);
            }
        });

        if( null == points && points.length == 0) return 0;

        if(points.length <3) return points.length;

        long x = 0;
        long y = 0;

        long dx = 0;
        long dy = 0;

        int cnt = 0;

        int res = 0;

        for(int i=1; i<points.length; i++){

            cnt = 0;

            x = points[i][0];
            y = points[i][1];

            dx = x-points[i-1][0];
            dy = y-points[i-1][1];


            if(dx == 0 && dy == 0){
                for(int j=0; j<points.length; j++){
                    if(points[j][0] == x && points[j][1] == y) cnt++;
                }
            }else{

                for(int j=0; j<points.length; j++){
                    if(dy*(points[j][0]-x) == dx*(points[j][1]-y)) cnt++;
                }

            }

            res = Math.max(cnt, res);

        }

        return res;

    }
}
