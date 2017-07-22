package leetcode.again.L373_FindKPairsWithSmallestSums;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: deadend
 * @date: 2:05 PM 3/1/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new LinkedList<>();
        if (nums1.length == 0 || nums2.length == 0)
            return result;

        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> (o1[0] + o1[1] - o2[0] - o2[1]));

        for (int i = 0; i < nums1.length; i++) {
            heap.offer(new int[] {nums1[i], nums2[0], 0});
        }

        while (k-- > 0 && !heap.isEmpty()) {
            int[] p = heap.poll();
            result.add(new int[] {p[0], p[1]});
            if (p[2] + 1 < nums2.length)
                heap.offer(new int[] {p[0], nums2[p[2] + 1], p[2] + 1});
        }

        return result;
    }
}
