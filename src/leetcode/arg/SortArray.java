package leetcode.arg;

import java.util.Arrays;

import org.junit.Test;

public class SortArray {
    @Test
    public void main() {
        int[] arr=new int[] {6,1,2,6,9,3,4,5,6,8};
        long start = System.currentTimeMillis();

        
        sortArray(arr);
        long end = System.currentTimeMillis();
        System.out.println("TIME = " + (end - start));
        System.out.println(Arrays.stream(arr).iterator().next());
    }
    public int[] sortArray(int[] nums) {
//        quickSort(nums,0,nums.length-1);
        sort(nums,0,nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        
        int length = right - left + 1;
//        if(length<2)return;
        //arrays.sort里的object类型 对于小于7的也是插入，
        //但是大于7的是merge归并，需要额外空间数组system.arrayscopy;
        //
        if(length<47) {//小于47插入， server VM对此有优化
            for (int i = left, j = i; i < right; j = ++i) {
                int ai = nums[i + 1];
                while (ai < nums[j]) {
                    nums[j + 1] = nums[j];
                    if (j-- == left) {
                        break;
                    }
                }
                nums[j + 1] = ai;
            }
        }else {//大于47，快速 //arrays.sort里是根据五个均匀点是否是不同值选择 双轴快排和单轴三分快排
            int curLeft=left;
            int curRight=right;
            int base=nums[curLeft];
            
            while(curLeft<curRight) {
                while(curLeft<curRight && nums[curRight]>base) {
                    curRight--;
                }
                if(curLeft<curRight) {
                    nums[curLeft++]=nums[curRight];
                }
                while(curLeft<curRight && nums[curLeft]<base) {
                    curLeft++;
                }
                if(curLeft<curRight) {
                    nums[curRight--]=nums[curLeft];
                }
            }
            nums[curLeft]=base;
            quickSort(nums,left,curLeft-1);
            quickSort(nums,curLeft+1,right);
        }
        
       
        
    }
    private void sort(int[] nums, int left, int right) {
        int length = right - left + 1;
        if(length<47) {//小于47插入， server VM对此有优化
            for (int i = left, j = i; i < right; j = ++i) {
                int ai = nums[i + 1];
                while (ai < nums[j]) {
                    nums[j + 1] = nums[j];
                    if (j-- == left) {
                        break;
                    }
                }
                nums[j + 1] = ai;
            }
        }else {
            int less=left;
            int great=right;
            int pivot=nums[less];
            for (int k = less; k <= great; ++k) {
                if (nums[k] == pivot) {
                    continue;
                }
                int ak = nums[k];
                if (ak < pivot) { // Move a[k] to left part
                    nums[k] = nums[less];
                    nums[less] = ak;
                    ++less;
                } else { // a[k] > pivot - Move a[k] to right part
                    while (nums[great] > pivot) {
                        --great;
                    }
                    if (nums[great] < pivot) { // a[great] <= pivot
                        nums[k] = nums[less];
                        nums[less] = nums[great];
                        ++less;
                    } else { // a[great] == pivot 
                        nums[k] = pivot;
                    }
                    nums[great] = ak;
                    --great;
                }
            }
             
            sort(nums, left, less - 1);
            sort(nums, great + 1, right);
        }
        
    }
    
    
    /* 单轴3分片（荷兰国旗）
     * Partitioning degenerates to the traditional 3-way
     * (or "Dutch National Flag") schema:
     *
     *   left part    center part              right part
     * +-------------------------------------------------+
     * |  < pivot  |   == pivot   |     ?    |  > pivot  |
     * +-------------------------------------------------+
     *              ^              ^        ^
     *              |              |        |
     *             less            k      great
     *
     * Invariants:
     *
     *   all in (left, less)   < pivot
     *   all in [less, k)     == pivot
     *   all in (great, right) > pivot
     *
     * Pointer k is the first index of ?-part.
     
    for (int k = less; k <= great; ++k) {
        if (a[k] == pivot) {
            continue;
        }
        int ak = a[k];
        if (ak < pivot) { // Move a[k] to left part
            a[k] = a[less];
            a[less] = ak;
            ++less;
        } else { // a[k] > pivot - Move a[k] to right part
            while (a[great] > pivot) {
                --great;
            }
            if (a[great] < pivot) { // a[great] <= pivot
                a[k] = a[less];
                a[less] = a[great];
                ++less;
            } else { // a[great] == pivot
                
                 * Even though a[great] equals to pivot, the
                 * assignment a[k] = pivot may be incorrect,
                 * if a[great] and pivot are floating-point
                 * zeros of different signs. Therefore in float
                 * and double sorting methods we have to use
                 * more accurate assignment a[k] = a[great].
                 
                a[k] = pivot;
            }
            a[great] = ak;
            --great;
        }
    }

    
     * Sort left and right parts recursively.
     * All elements from center part are equal
     * and, therefore, already sorted.
     
    sort(a, left, less - 1, leftmost);
    sort(a, great + 1, right, false);
    */
    
    
  //平均n+k，最好n+k，最坏n+k，空间k，外排序，稳定   特定范围数据
    public int[] sortArray1(int[] nums) {
        if (nums.length == 0) return nums;
        int bias, min = nums[0],max = nums[0];
        //标记最大和最小的元素
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        //统计数组中各个值出现的次数
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i] + bias]++;
        }
        int index = 0, i = 0;
        while (index < nums.length) {
            if (bucket[i] != 0) {
                nums[index] = i - bias;
                bucket[i]--;
                index++;
            } else {
                i++;
            }
        }
        return nums;

    }
}
