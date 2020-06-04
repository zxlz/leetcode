package leetcode.lockupTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字母异位词分组
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。
 * @author zxl
 *
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

    	        if (strs.length == 0)
    	            return new ArrayList();
    	        Map<String,List> map = new HashMap<>();
    	        for (String s : strs) {
    	            char[] chs = s.toCharArray();
    	            Arrays.sort(chs);
    	            String temp = String.valueOf(chs);
    	            if (!map.containsKey(temp))
    	                map.put(temp,new ArrayList());
    	            map.get(temp).add(s);
    	        }
    	        return new ArrayList(map.values());
    	
    }
}
