package leetcode.binarySearch;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 找到 K 个最接近的元素
给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。
返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。

示例 1:

输入: [1,2,3,4,5], k=4, x=3
输出: [1,2,3,4]
 * @author zxl
 *
 */
public class FindClosestElements {
	@Test
	public void main() {
		findClosestElements(new int[] {1,2,3,4,5,6,7,8,9}, 4, 10);
	}
	/**
	 *  找start，mid和mid+k是候选的结果
	 * ，要是x到left的差值比right大，那么mid和mid左边排除，
	 *   要是x到left的差值比right小，那么mid右边排除
	 * 
	 * @param arr
	 * @param k
	 * @param x
	 * @return
	 */
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int start = 0, end = arr.length-k;
        while(start<end){
            int mid = start + (end-start)/2;
            if(Math.abs(arr[mid]-x)>Math.abs(arr[mid+k]-x)){ 
                start = mid+1;
            } else {
                end = mid;
            }
        }
        for(int i=start; i<start+k; i++){
            res.add(arr[i]);
        }
        return res;
	}
}
