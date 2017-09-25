package leetcode.L503_NextGreaterElementII;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 4:15 PM 28/03/2017
 */


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        final int n = nums.length;
        LinkedList<Integer> stack = new LinkedList<>();

        int[] nexts = new int[n];
        Arrays.fill(nexts, -1);
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                int top = stack.pop();
                nexts[top] = nums[i % n];
            }
            stack.push(i % n);
        }
        return nexts;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        int[] res = new Solution().nextGreaterElements(nums);
        for (int r : res) {
            System.out.println(r);
        }
    }
}

class OldSolution {
    public int[] nextGreaterElements(int[] nums) {
        final int n = nums.length;
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = n - 1; i >= 0; i--) {
            stack.push(nums[i]);
        }

        int[] nexts = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            nexts[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return nexts;
    }
}
