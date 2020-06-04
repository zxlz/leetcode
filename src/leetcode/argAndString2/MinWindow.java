package leetcode.argAndString2;

import org.junit.Test;

/**
 * 最小覆盖子串
给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。

示例：

输入: S = "ADOBECODEBANC", T = "ABC"
输出: "BANC"
说明：

如果 S 中不存这样的子串，则返回空字符串 ""。
如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * @author zxl
 *
 */
public class MinWindow {
	@Test
	public void main() {
		minWindow("a","b");
	}
	/**
	 * 
	 * 初始，left指针和right指针都指向S的第一个元素.
	 * 
将 right 指针右移，扩张窗口，直到得到一个可行窗口，亦即包含T的全部字母的窗口。

得到可行的窗口后，将leftt指针逐个右移，若得到的窗口依然可行，则更新最小窗口大小。

若窗口不再可行，则跳转至 2。
	 * @param s
	 * @param t
	 * @return
	 */
    public String minWindow(String s, String t) {
    	
    	if(s.length()==0||t.length()==0)return "";
    	int[] check=new int[128];
    	boolean[] checkExist=new boolean[128];
    	int count=t.length();
    	for (int i = 0; i < t.length(); i++) {
    		check[t.charAt(i)]++;
    		checkExist[t.charAt(i)]=true;
		}
    	char[] schar=s.toCharArray();
    	int chLen=schar.length+1;
    	int start=0;
    	int left=0;
    	int right=0;
    	while (left<=right && right < schar.length || count==0) {
			if(count>0) {//缺数
				if(checkExist[schar[right]]) {//如果是子序数，则--
					if(--check[schar[right]]>=0)//不超过需要的数量，则count--
//					if(check[schar[right]]==0)check[schar[right]]=-1;//这个char找完，置为-1，
					count--;
				}
				right++;
			}else if(count==0){//有子序
				if(chLen>right-left) {
					chLen=right-left;
					start=left;
				}
				if(checkExist[schar[left]]) {//如果left移 丢失后影响子序的char数，则右边开始找
					if(++check[schar[left]]>0)count++;
				}
				left++;
			}
			
		}
    	if(chLen==schar.length+1)return "";
    	return String.valueOf(schar, start, chLen);
    	
    }
}
