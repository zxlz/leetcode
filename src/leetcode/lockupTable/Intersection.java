package leetcode.lockupTable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
    	Set<Integer> set =new HashSet<Integer>();
    	int[] longNums=nums1;
    	int[] shortNums=nums2;
    	
    	if(nums2.length>nums1.length) {
    		longNums=nums2;
    		shortNums=nums1;
    	}
    	int[] temp=new int[shortNums.length];
    	
    	for(int i:shortNums) {
    		set.add(i);
    	}
    	int count=0;
    	for (int i = 0; i < longNums.length; i++) {
			if(set.contains(longNums[i])) {
				set.remove(longNums[i]);
				temp[count++]=longNums[i];	
			}
		}
    	int[] res=new int[count];
    	System.arraycopy(temp, 0, res, 0, count);
		return res;

    }
}
