package leetcode.lockupTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 根据字符出现频率排序
给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * @author zxl
 *
 */
public class FrequencySort {
	public String frequencySort(String s) {
    	int[] charnums=new int[128];
    	for (int i = 0; i < s.length(); i++) {
			charnums[s.charAt(i)] +=1;
		}
    	int tempChar = -1;
        StringBuilder res = new StringBuilder();
        while ((tempChar = getChar(charnums)) > 0) {
            while (charnums[tempChar]-- > 0) {
                res.append((char) tempChar);
            }
        }
        return res.toString();
    }
    
    private int getChar(int[] counting) {
        int idx = -1, max = 0;
        for (int i = 0; i < 128; i++) {
            if (counting[i] > max) {
                max = counting[idx = i];
            }
        }
        return idx;
    }
    public String frequencySort1(String s) {

    	
    	Map<Character, Integer> map=new HashMap<Character, Integer>();
    	
    	for (int i = 0; i < s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i),map.get(s.charAt(i))+1);
			}else {
				map.put(s.charAt(i),1);
			}
		}
    	 //这里将map.entrySet()转换成list

        List<Entry<Character, Integer>> list = new ArrayList<Entry<Character, Integer>>(map.entrySet());

        //然后通过比较器来实现排序

        Collections.sort(list,new Comparator<Entry<Character, Integer>>() {
            public int compare(Entry<Character, Integer> o1,

                    Entry<Character, Integer> o2) {

                return o2.getValue().compareTo(o1.getValue());
            }
        });
        StringBuilder res = new StringBuilder();
           for (Map.Entry<Character, Integer> entry : list) {
               for (int i = 0; i < entry.getValue(); i++) {
                   res.append(entry.getKey());
               }
           }
           return res.toString();
    }
    
}
