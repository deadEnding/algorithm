package leetcode.L349_IntersectionOfTwoArrays;

import java.util.Collections;
import java.util.HashSet;

/**
 * @author: deadend
 * @date: 3:25 PM 11/26/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }

        HashSet<Integer> set2 = new HashSet<>();
        for (int n : nums2) {
            set2.add(n);
        }

        set1.retainAll(set2);
        int[] result = new int[set1.size()];
        int ix = 0;
        for (int n : set1) {
            result[ix++] = n;
        }
        return result;
    }
}
