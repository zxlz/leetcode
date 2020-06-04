package leetcode.arg;

import org.junit.Test;

import java.util.ArrayDeque;

public class Find132pattern {
    @Test
    public void main() {
//        System.out.println(find132pattern(new int[]{1,2,3,4,5,6,5}));
        System.out.println(find132pattern(new int[]{-2, 1, 2, -2, 1, 2}));

    }

    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        ArrayDeque<Integer> stack = new ArrayDeque();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        for (int i : min) {
            System.out.println(i);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] == min[i]) continue;
            while (!stack.isEmpty() && stack.peek() <= min[i]) {

                stack.poll();

            }
            if (!stack.isEmpty() && stack.peek() < nums[i]) {
                return true;
            } else {
                stack.push(nums[i]);
            }
        }
        return false;
    }
}
