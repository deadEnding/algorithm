package leetcode.again.L456_132Pattern;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 11:06 AM 3/2/17
 * @version: 1.0
 * @description:
 */



public class Solution {
    public boolean find132pattern(int[] nums) {
        LinkedList<Integer> stack = new LinkedList<>();
        int s3 = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < s3) {
                return true;
            }

            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                s3 = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}

