package leetcode.backtracking2;

import static org.junit.Assume.assumeNoException;

import org.junit.Test;

/**
 * 通配符匹配
给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。

'?' 可以匹配任何单个字符。
'*' 可以匹配任意字符串（包括空字符串）。
两个字符串完全匹配才算匹配成功。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "*"
输出: true
解释: '*' 可以匹配任意字符串。
 * @author zxl
 *
 */
public class IsMatch {
	@Test
	public void main() {
		
//		System.out.println(isMatch("aab", "c*a*b"));
		System.out.println(isMatch1("adcebbbbccbbbba", "a*bbbb*a"));
	}
	
	public boolean isMatch1(String s, String p) {
		int i = 0, j = 0, iStar = -1, jStar = -1, m = s.length(), n = p.length();
		char[] sArr=s.toCharArray(),pArr=p.toCharArray();
        while (i < m) {
            if (j < n && (sArr[i] == pArr[j] || pArr[j] == '?')) {
                ++i; ++j;//i，j向后瞬移
            } else if (j < n && pArr[j] == '*') {//记录如果之后序列匹配不成功时， i和j需要回溯到的位置
                iStar = i;//记录星号
                jStar = j++;//记录星号 并且j移到下一位 准备下个循环s[i]和p[j]的匹配
            } else if (iStar >= 0) {//发现字符不匹配且没有星号出现 但是istar>0 说明可能是*匹配的字符数量不对 这时回溯
                i = ++iStar;//i回溯到istar+1 
                j = jStar + 1;//j回溯到jstar+1 
            } else return false;
        }
        while (j < n && pArr[j] == '*') ++j;//去除多余星号
        return j == n;

    }
	
	boolean[][] visited;
    public boolean isMatch(String s, String p) {
    	visited=new boolean[s.length()][p.length()];
    	return find(s.toCharArray(),s.length()-1,p.toCharArray(),p.length()-1);
    	
//		return false;

    }

	private boolean find(char[] sArray, int sIndex, char[] pArray, int pIndex) {
		// TODO Auto-generated method stub
		
		if(sIndex>=0 && pIndex>=0) {
			if(visited[sIndex][pIndex])return false;
			visited[sIndex][pIndex]=true;
			if(pArray[pIndex]=='*') {//如果是*,匹配后一个
				do{
					if(pIndex--==0)return true;//后一个没有了，则成功
					while(pArray[pIndex]=='?') {//p的后一个是？，s也后移且必须后移，否则失败
						if(sIndex--==-1)return false;//s没有了，则失败
						if(pIndex--==0)return true;
					}
				}while(pArray[pIndex]=='*');

				//p和s都移到了下个比较位
				while (sIndex >=0) {//循环进入合理的分支
					if(sArray[sIndex]==pArray[pIndex]) {
						if(find(sArray, sIndex-1, pArray, pIndex-1))return true;
					}
					 --sIndex;	
				}
				return false;
			}else if(pArray[pIndex]=='?') {
				return find(sArray, sIndex-1, pArray, pIndex-1);//都后移一位比较
			}else {
				if(sArray[sIndex]!=pArray[pIndex])return false;
				return find(sArray, sIndex-1, pArray, pIndex-1);
			}
		}else {
			if(sIndex==-1&&pIndex==-1) {
				return true;
			}else {
				if(pIndex>=0) {
					while(pIndex>=0) {
						if(pArray[pIndex--]!='*')
						return false;
					}
					return true;
				}
				
				return false;
			}
				
		}
	}
}
