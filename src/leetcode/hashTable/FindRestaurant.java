package leetcode.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 两个列表的最小索引总和
假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。

你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。

示例 1:

输入:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
输出: ["Shogun"]
解释: 他们唯一共同喜爱的餐厅是“Shogun”。

两个列表的长度范围都在 [1, 1000]内。
两个列表中的字符串的长度将在[1，30]的范围内。
下标从0开始，到列表的长度减1。
两个列表都没有重复的元素。


 * @author zxl
 *
 */
public class FindRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
    	String[] shortArr=list1;
    	String[] longArr=list2;
    	List<String> minSameStr = new ArrayList<String>();
    	//int sameStrIndex = 0;
    	int minDiff=-1;
    	if(list1.length>list2.length) {
    		longArr=list1;shortArr=list2;
    	}
    	
    	HashMap<String,Integer> map =new HashMap<String, Integer>();
    	for (int i = 0; i < shortArr.length; i++) {
			map.put(shortArr[i],i);
		}
    	for (int i = 0; i < longArr.length; i++) {
    		Integer sIndex=null;
			if((sIndex=map.get(longArr[i]))!=null) {//存在重复
				int diff=sIndex+i;
				if(minDiff==-1 || diff<minDiff) {//第一次或者 有diff更小的
					minDiff=diff;
					minSameStr.clear();
					minSameStr.add(longArr[i]);
				}else if(diff==minDiff){
					minSameStr.add(longArr[i]);//加入尾部，sameindex++
				}
				
			}
		}
    	if(minDiff==-1)return null;
    	
    	
    	
		return minSameStr.toArray(new String[minSameStr.size()]);

    }
}
