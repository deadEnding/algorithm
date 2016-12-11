package leetcode.L239_SlidingWindowMaximum;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * @author: deadend
 * @date: 1:27 PM 12/11/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && i - deque.getFirst() == k) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);

            if (i >= k - 1) {
                result[i - (k - 1)] = nums[deque.getFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] maxs = new Solution().maxSlidingWindow(nums, k);
        for (int max : maxs) {
            System.out.print(max + " ");
        }
    }
}

// 时间复杂度 O(nlogk)
class BasicSolution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1);
            if (i < k - 1) {
                continue;
            }
            int ix = i - k + 1;
            result[ix] = map.lastKey();
            map.put(nums[ix], map.get(nums[ix]) - 1);
            if (map.get(nums[ix]) == 0) {
                map.remove(nums[ix]);
            }
        }
        return result;
    }
}
