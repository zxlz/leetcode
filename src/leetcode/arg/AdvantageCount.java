package leetcode.arg;

import com.sun.javafx.tools.packager.MakeAllParams;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xerces.internal.util.EntityResolverWrapper;

import leetcode.QuickSort;
import org.junit.Test;

import java.util.*;
import java.util.zip.Inflater;

/**
 * 870. 优势洗牌
 * 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
 *
 * 返回 A 的任意排列，使其相对于 B 的优势最大化。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [2,7,11,15], B = [1,10,4,11]
 * 输出：[2,11,7,15]
 * 示例 2：
 *
 * 输入：A = [12,24,8,32], B = [13,25,32,11]
 * 输出：[24,32,8,12]
 *
 *
 * 提示：
 *
 * 1 <= A.length = B.length <= 10000
 * 0 <= A[i] <= 10^9
 * 0 <= B[i] <= 10^9
 */
public class AdvantageCount {

    @Test
    public void main() {
//        int[] A=new int[]{2,0,4,1,2};
//        int[] B = new int[]{1,3,0,0,2};
        int[] A=new int[]{718967141,189971378,341560426,23521218,339517772};
        int[] B = new int[]{967482459,978798455,744530040,3454610,940238504};

        System.out.println();
        int[] r=advantageCount(A,B);
        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i]);
        }
    }

    class Pair {
        int value;
        int index;
        Pair(int i,int v){
            value=v;
            index=i;
        }

    }
    //排序，用pair存原坐标，然后生成结果
    public int[] advantageCount1(int[] A, int[] B) {

        Arrays.sort(A);
        Pair[]  sortB= new Pair[B.length];
        for (int i = 0; i < B.length; i++) {
            sortB[i]=new Pair(i,B[i]);
        }

        Arrays.sort(sortB,(Pair o1, Pair o2) ->o1.value-o2.value );

        int[] res = new int[A.length];

        boolean[] used = new boolean[A.length];

        int aIndex=0;
        int aMax=A[A.length-1];
        int next = 0;
        for (; next < res.length && aMax>sortB[next].value && !used[A.length-1]; next++) {//存在优势值
            //在A中找出第一个大于B[i]的，
            while (A[aIndex]<=sortB[next].value){
                aIndex++;
            }
            used[aIndex]=true;
            //res 转成真实坐标存入
            res[sortB[next].index]=A[aIndex++];
        }
        int i=0;
        //next之后的都比a大，随便填入
        while(next<res.length){//把劣势的 填到结果中
            while(used[i]){//找到未使用的
                i++;
            }
            res[sortB[next++].index]=A[i++];
        }
        return res;
    }

    //改进，B用索引双路快排,
    public int[] advantageCount(int[] A, int[] B) {
        int[] index=new int[B.length];
        for (int i = 0; i < index.length; i++) {
            index[i]=i;
        }
        Arrays.sort(A);
        quickSort(index,B,0,B.length-1);

         int[] res = new int[A.length];

        boolean[] used = new boolean[A.length];

        int aIndex=0;
        int aMax=A[A.length-1];
        int next = 0;
        for (; next < res.length && aMax>B[index[next]] && !used[A.length-1]; next++) {//存在优势值
            //在A中找出第一个大于B[i]的，
            while (A[aIndex]<=B[index[next]]){
                aIndex++;
            }
            used[aIndex]=true;
            //res 转成真实坐标存入
            res[index[next]]=A[aIndex++];
        }
        int i=0;
        //next之后的都比a大，随便填入
        while(next<res.length){//把劣势的 填到结果中
            while(used[i]){//找到未使用的
                i++;
            }
            res[index[next++]]=A[i++];
        }
        return res;
    }




    /**
     *       0,1,2-n
     * @param index 索引数组，存排序结果
     * @param fixed     排序值所在数组，不可更改
     * @param left
     * @param right
     */
    private void quickSort(int[] index, int[] fixed, int left, int right) {
        if(right-left<7){
            for (int i = left, j = i; i < right; j = ++i) {
                int ai = index[i+1];
                while (fixed[ai] < fixed[index[j]]) {
                    index[j + 1] = index[j];
                    if (j-- == left) {
                        break;
                    }
                }
                index[j + 1] = ai;
            }
            return;
        }
        if(left<right){
            int l=left;
            int r=right;
            int x=index[left];
//            int x=fixed[index[left]];
            while(l<r){
                while(l<r && fixed[index[r]]>fixed[x]){
                    r--;
                };
                if(l<r){//该<=x的值，放到左边
                    index[l++]=index[r];
                }
                while (l<r && fixed[index[l]]<fixed[x]){
                    l++;
                }
                if(l<r){//
                    index[r--]=index[l];
                }
            }
            index[l]=x;
            quickSort(index, fixed,left,l-1);
            quickSort(index,fixed,l+1,right);
        }
    }

}
