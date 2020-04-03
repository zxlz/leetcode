package leetcode;

import org.junit.Test;

public class QuickSort {
    @Test
    public void main() {
        int[] arr=new int[] {6,1,2,6,9,3,4,5,6,8};
        quickSort(arr);
        System.out.println(arr);
    }
    // 
    //[6, 1, 2, 5, 4, 3, 6, 9, 6, 8]
    // 0              5
    //[3, 1, 2, 5, 4, 6, 6, 9, 6, 8]
    // 0           4
    //[2, 1, 3, 5, 4, 6, 6, 9, 6, 8]
    // 0  1
    //[1, 2, 3, 5, 4, 6, 6, 9, 6, 8]
    /*          3  4
    //[1, 2, 3, 4, 5, 6, 6, 9, 6, 8]
     *                      7     9  
     *[1, 2, 3, 4, 5, 6, 6, 9, 6, 8]
     * 
     * @param a
     * @param leftBorder
     * @param rightBorder
     */

      //双指针移动，不过，和归并排序不同的是，从一头一尾开始，假设第一个是分区点。x=a[i],两个指针
      //分别向中间移动。
      //他来回移动数据，为什么不会覆盖掉一些数据
      //因为先扣掉第一个位置。然后后面的交换，不断向前面的坑里填。左右交替比较交换。
      //到最后i和j相等之后，用扣掉的元素替换掉重复的元素
          public static void quick_sort1(int a[], int leftBorder, int rightBorder)
          {
              if (leftBorder < rightBorder)
              {
                  int i,j,x;

                  i = leftBorder;
                  j = rightBorder;
                  x = a[i];
                  while (i < j)
                  {
                      while(i < j && a[j] > x)
                          j--; // 从右向左找第一个小于等于x的数
                      if(i < j)//放到左边，坐标右移
                          a[i++] = a[j];
                      while(i < j && a[i] < x)
                          i++; // 从左向右找第一个大于等于x的数
                      if(i < j)//放到右边
                          a[j--] = a[i];
                  }
                  a[i] = x;
                  quick_sort1(a, leftBorder, i-1); /* 递归调用 */
                  quick_sort1(a, i+1, rightBorder); /* 递归调用 */
              }
          }
          
    public  void quickSort(int[] arr) {
        
//        quick_sort(arr, 0, arr.length - 1);
        quick_sort1(arr, 0, arr.length - 1);
    }
 
    void quick_sort(int arr[], int a, int b)
    {
        if (a >= b)
            return;
        int p = partition(arr, a, b);
        quick_sort(arr, a, p - 1);
        quick_sort(arr, p + 1, b);//这里一定是p+1，将中心点排除在外，不然会在区间里有重复元素的时候陷入死循环！！！！
    }

    int partition(int arr[], int a, int b)
    {
        int i = a, j;
        int p = arr[b];//记录中心点
        for (j = a; j < b; j++)
        {
            if (arr[j] < p)//找到比中心点小的元素就交换
            {
                swap(arr,i, j);
                i++;
            }
        }
        swap(arr,i, b);//将中心点交换到中间
        return i;//返回中心点下标
    }

    private void swap(int[] arr, int i, int j) {

        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}
