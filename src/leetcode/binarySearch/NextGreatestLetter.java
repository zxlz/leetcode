package leetcode.binarySearch;

/**
 *   寻找比目标字母大的最小字母
给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。

数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。

示例:

输入:
letters = ["c", "f", "j"]
target = "a"
输出: "c"

 * @author zxl
 *
 */
public class NextGreatestLetter {
	// a b d  e  f  g  i  l o  p  x
    public char nextGreatestLetter(char[] letters, char target) {
    	
    	int left=0;
    	int right=letters.length-1;
    	while(left<=right) {
    		int mid = left + (right-left)/2;
    		if(letters[mid]>target) {
    			if(mid>0&&letters[mid-1]>target) {
    				right=mid-1;
    			}
    			return letters[mid];
    		}else {
    			left=mid+1;
    		}
    	}
		return letters[0];

    }
}
