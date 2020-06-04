package leetcode.binarySearch;

public class MySqrt {
    public int mySqrt(int x) {
    	int left = 0, right = (x >>1) + 1;
		while (left <= right) {
			long mid =  (left + right) >>> 1;
			if (mid * mid == x) {
				return (int) mid;
			} else if (mid * mid < x) {
				left = (int) (mid + 1);
			} else {
				right = (int) (mid - 1);
			}
		}
		return -1;
    }
}
