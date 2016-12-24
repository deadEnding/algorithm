package leetcode.L456_132Pattern;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 1:14 PM 12/24/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean find132pattern(int[] nums) {
        int s3 = Integer.MIN_VALUE;
        LinkedList<Integer> stack = new LinkedList<>();
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

    public static void main(String[] args) {
        int[] nums = {1,0,1,-4,-3};
        System.out.println(new Solution().find132pattern(nums));
    }
}
