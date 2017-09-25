package leetcode.L496_NextGreaterElementI;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 11:08 AM 2/11/17
 * @version: 1.0
 * @description:
 */

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], -1);
        }

        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            if (map.containsKey(nums2[i]) && !stack.isEmpty()) {
                map.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}


class BasicSolution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], -1);
        }

        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                int top = stack.pop();
                if (map.containsKey(top)) {
                    map.put(top, nums2[i]);
                }
            }
            stack.push(nums2[i]);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}


class OldSolution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int fn : findNums) {
            map.put(fn, -1);
        }

        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                int top = stack.pop();
                if (map.containsKey(top)) {
                    map.put(top, nums[i]);
                }
            }
            stack.push(nums[i]);
        }

        int[] result = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            result[i] = map.get(findNums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] findNums = {4,1,2};
        int[] nums = {1,3,4,2};
        int[] result = new Solution().nextGreaterElement(findNums, nums);
        for (int r : result) {
            System.out.print(r + ",");
        }
    }
}
