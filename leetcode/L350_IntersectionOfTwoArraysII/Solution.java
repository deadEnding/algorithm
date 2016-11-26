package leetcode.L350_IntersectionOfTwoArraysII;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 3:39 PM 11/26/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int n : nums1) {
            counter.put(n, counter.containsKey(n) ? counter.get(n) + 1 : 1);
        }

        HashMap<Integer, Integer> interCounter = new HashMap<>();
        int len = 0;
        for (int n : nums2) {
            if (counter.containsKey(n) && counter.get(n) > 0) {
                interCounter.put(n, interCounter.containsKey(n) ? interCounter.get(n) + 1 : 1);
                len++;
                counter.put(n, counter.get(n) - 1);
            }
        }

        int[] result = new int[len];
        int ix = 0;
        for (int key : interCounter.keySet()) {
            for (int i = 0; i < interCounter.get(key); i++) {
                result[ix++] = key;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] result = new Solution().intersect(nums1, nums2);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
