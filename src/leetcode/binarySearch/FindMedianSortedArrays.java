package leetcode.binarySearch;

import org.junit.Test;

/**
 * 寻找两个有序数组的中位数
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

1 2 3  6 7

4 5 8 9 10
 			   left_part          |        right_part
num1[0], num1[1], ..., num1[i-1]  |  num1[i], num1[i+1], ..., num1[num1.length-1]
num2[0], num2[1], ..., num2[j-1]  |  num2[j], num2[j+1], ..., num2[num2.length-1]
1 2
    3 4
1 2 3   |  6 7

  4 5   |  8 9 10
则中位数是 (2 + 3)/2 = 2.5

中值点  i+j=总长一半
num2[j-1]<num1[i]
num1[i-1]<num2[j]

长的一段肯定至少有1结果
 * @author zxl
 *
 */
public class FindMedianSortedArrays {
	@Test
	public void main() {
		//findMedianSortedArrays(new int[] {1,3},new int[] {2});
//		System.out.println(findMedianSortedArrays(new int[] {1,2},new int[] {3,4}));
//		System.out.println(findMedianSortedArrays(new int[] {0,0},new int[] {0,0}));
		System.out.println(findMedianSortedArrays(new int[] {},new int[] {1}));
//		System.out.println(findMedianSortedArrays(new int[] {3,4},new int[] {1,2}));
//		System.out.println(findMedianSortedArrays(new int[] {1},new int[] {}));
//		System.out.println(findMedianSortedArrays(new int[] {100001},new int[] {100000}));
//		System.out.println(findMedianSortedArrays(new int[] {},new int[] {2,3}));
//		System.out.println(findMedianSortedArrays(new int[] {3},new int[] {-2,-1}));
//		System.out.println(findMedianSortedArrays(new int[] {},new int[] {1,2,3,4}));
		// 1 2 3 4 5  6 7 
		//         0  9 100 101 102
		// 1 2 3 4 5   6 7
		//		   0   9 100 101
		// 1  2
		//    3  4
		// 1 3
		//   2
		//
		
	}
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	if(nums1.length>nums2.length) {//nums1换为短的
    		int[] temp=nums1;
    		nums1=nums2;
    		nums2=temp;
    	}
    	if(nums2.length==0)return 0;
    	boolean isOdd=((nums1.length+nums2.length)&1)==1;
    	
    	int left1=0;
    	int right1=nums1.length-1;
    	int halfLen=(nums1.length+nums2.length+1)/2;
    	int mid=left1+(right1-left1)/2;
    	int mid2;
     	while(left1<=right1) {
//    		 mid=left1+(right1-left1)/2;
     		mid=(left1+right1)/2;
    		 mid2=halfLen-mid;
//    		 mid2--;
    		// 0 1
//    		 
    		//偶数，
    		if( (mid<=left1 || nums1[mid-1]<=nums2[mid2]) &&
    				(mid>=right1 || nums2[mid2-1]<=nums1[mid])  ){
    			 int maxLeft = 0;
                 if (mid == 0) { maxLeft = nums2[mid2-1]; }
                 else if (mid2 == 0) { maxLeft =nums1[mid-1]; }
                 else { maxLeft = Math.max(nums2[mid2-1], nums1[mid-1]); }
                 if (isOdd ) { return maxLeft; }

                 int minRight = 0;
                 if (mid == nums1.length) { minRight = nums2[mid2];}
                 else if (mid2 == nums2.length) { minRight = nums1[mid]; }
                 else { minRight = Math.min(nums2[mid2], nums1[mid]); }

                 return (maxLeft + minRight) / 2.0;

    		}else if(mid > left1 && nums1[mid-1]>nums2[mid2]){
    			right1=mid-1;
    		}else{
    			left1=mid+1;
    		}
    	}
    	if(isOdd) {
    		return nums1[mid];
    	}else {
    		return (nums1[mid]+nums1[mid+1])/2.0;
    	}
		
    	
    }

}
