package leetcode.arg;

public class PlusOne {
	/**
	 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
	 * @param digits
	 * @return
	 */

	public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}
