package leetcode.L373_FindKPairsWithSmallestSums;

import java.util.*;

/**
 * @author: deadend
 * @date: 9:53 PM 12/17/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new LinkedList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>(k, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] + o1[1] - o2[0] - o2[1];
            }
        });

        for (int i = 0; i < nums1.length && i < k; i++) {
            heap.add(new int[]{nums1[i], nums2[0], 0});
        }

        while (k-- > 0 && !heap.isEmpty()) {
            int[] pair = heap.poll();
            result.add(new int[]{pair[0], pair[1]});
            if (pair[2] < nums2.length - 1) {
                heap.add(new int[]{pair[0], nums2[pair[2] + 1], pair[2] + 1});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        List<int[]> result = new Solution().kSmallestPairs(nums1, nums2, k);
        for (int[] pair : result) {
            System.out.println(pair[0] + " " + pair[1]);
        }
    }
}
