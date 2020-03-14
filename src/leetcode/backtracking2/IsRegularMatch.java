package leetcode.backtracking2;

public class IsRegularMatch {
	//动态规划自顶向下，或者说isMatch回溯加缓存
	Boolean[][] cache;
	public boolean isMatch(String s, String p) {
		if(p.isEmpty())return s.isEmpty();
		cache=new Boolean[s.length()+1][p.length()+1];
		return dp(s,p,0,0);
    }
	public boolean dp(String s, String p, int sIndex, int pIndex) {
		if(cache[sIndex][pIndex]!=null)return cache[sIndex][pIndex];
		
		boolean ans;
		if (pIndex == p.length()){
            ans = sIndex == s.length();
        } else{
        	boolean firstMatch=sIndex<s.length()&&(s.charAt(sIndex)==p.charAt(pIndex)||p.charAt(pIndex)=='.');
        	if(pIndex+1<p.length()&&p.charAt(pIndex+1)=='*') {
        		ans= dp(s,p,sIndex,pIndex+2)
        				|| firstMatch && dp(s, p,sIndex+1,pIndex);
        	}else {
        		ans= firstMatch && dp(s, p,sIndex+1,pIndex+1);
        	}
        }
    	
    	cache[sIndex][pIndex]=ans;
    	return ans;
	}
	//回溯
    public boolean isMatch1(String s, String p) {
    	if(p.isEmpty())return s.isEmpty();
    	boolean firstMatch=!s.isEmpty()&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.');
    	if(p.length()>=2&&p.charAt(1)=='*') {
    		return isMatch(s,p.substring(2))
    				|| firstMatch && isMatch(s.substring(1), p);
    	}else {
    		return firstMatch && isMatch(s.substring(1), p.substring(1));
    	}
    }
}
