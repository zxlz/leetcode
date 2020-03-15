package leetcode.Math1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 最大数
给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

示例 1:

输入: [10,2]
输出: 210
示例 2:

输入: [3,30,34,5,9]
输出: 9534330
说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * @author zxl
 *
 */
public class LargestNumber {
	//
    public String largestNumber(int[] nums) {
     	String res=Arrays.stream(nums).mapToObj(String::valueOf).sorted(new Comparator<String>() {
			@Override
			public int compare(String o1,String o2) {
				return (o1+o2).compareTo(o2+o1);
			}
		}).collect(Collectors.joining());
		return res.startsWith("0")?"0":res;
    }
}
