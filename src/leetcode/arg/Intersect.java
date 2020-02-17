package leetcode.arg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Intersect {
	/**
	 * 有序数组，直接移动两个数组的指针比较
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
      Arrays.sort(nums2);
      int o=0;
      int t=0;
      int flag=0;
      while (o<nums1.length&&t<nums2.length){
          if (nums1[o]<nums2[t]){
              o++;
          }else if (nums1[o]>nums2[t]){
              t++;
          }else {
              nums1[flag++]=nums1[o];
              o++;
              t++;
          }
      }
      int[] ints = new int[flag];
      for (int i = 0; i < ints.length; i++) {
          ints[i]=nums1[i];
      }
      return ints;
  }
	/**
	 * 无序数组，使用map，key存数，value存次数
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums1.length;i++) {
        	Integer val=map.get(nums1[i]);
        	map.put(nums1[i], (val==null)?1:++val);
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i=0,val;i<nums2.length;i++) {
        	if(map.containsKey(nums2[i]) && (val=map.get(nums2[i]))>0) {
        		al.add(nums2[i]);
        		map.put(nums2[i], --val);
        	}
        }
        
        int[] in = new int[al.size()];
        int e=0;
		for(int i:al)
			in[e++] = i;
		return in;
        
    }
}
