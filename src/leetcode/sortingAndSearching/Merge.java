package leetcode.sortingAndSearching;

import org.junit.Test;

/**
 * 合并两个有序数组
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
 * @author zxl
 *
 */
public class Merge {
	@Test
	public void main() {
//		int[] nums1= {1,2,3,0,0,0};
//		int[] nums2= {2,5,6};
		int[] nums1= {2,0};
		int[] nums2= {1};
		merge(nums1,1,nums2,1);
	}
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] res = new int[m+n];
		int a=0;
		int b=0;
		int i=0;
		while(a<m || b<n) {
			if(a>=m) {
				System.arraycopy( nums2, b,res, i, nums2.length-b);
                break;
			}
			if(b>=n) {
				System.arraycopy(nums1, a,res, i,  m-a);
                 break;
			}
			if(nums1[a]<nums2[b]) {
				res[i++]=nums1[a++];
			}else {
				res[i++]=nums2[b++];
			}
		}
		System.arraycopy(res, 0,nums1,0,m+n);
    }
	/**
	 * 尾插法
由于 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素，
所以从 k=m+n-1 开始，分别遍历 nums1[m...0] 和 nums2[n...0] 中选取值大的。

	 */
	 public void merge1(int[] nums1, int m, int[] nums2, int n) {
	        int a = m - 1;
	        int b = n - 1;
	        int i = m + n - 1;
	        while(a >= 0 && b >= 0) {
	            nums1[i--] = nums1[a] > nums2[b] ? nums1[a--] : nums2[b--];
	        }
	
	        System.arraycopy(nums2, 0, nums1, 0, b + 1);
	    }

}
