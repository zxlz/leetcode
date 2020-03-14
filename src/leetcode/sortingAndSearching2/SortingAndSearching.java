package leetcode.sortingAndSearching2;

import java.util.Arrays;

/**
 * 摆动排序 II
给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。

示例 1:

输入: nums = [1, 5, 1, 1, 6, 4]
输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
示例 2:

输入: nums = [1, 3, 2, 2, 3, 1]
输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
说明:
你可以假设所有输入都会得到有效的结果。

进阶:
你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 * @author zxl
 *
 */
public class SortingAndSearching {
    public void wiggleSort(int[] nums) {
    	 //快排，错位放置
    	int length = nums.length;
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int j = (length-1)/2;
        int k = length-1 ;
        for (int i = 0;i < length;i++) {
            if (i%2 == 0) {
                nums[i] = temp[j--];
            } else {
                nums[i] = temp[k--];
            }
        }
    }

//    1.找到中位数，
//    2.利用3-way-partition算法 o(n)
//    	将中位数放在数组中部，
//      	同时将小于中位数的数放在左侧，
//      	大于中位数的数放在右侧
//    int i = 0, j = 0, k = nums.size() - 1;
//            while(j < k){
//                if(nums[j] > mid){
//                    swap(nums[j], nums[k]);
//                    --k;
//                }
//                else if(nums[j] < mid){
//                    swap(nums[j], nums[i]);
//                    ++i;
//                    ++j;
//                }
//                else{
//                    ++j;
//                }
//            }


   
}
