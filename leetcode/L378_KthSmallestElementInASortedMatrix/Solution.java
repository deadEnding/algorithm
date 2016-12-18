package leetcode.L378_KthSmallestElementInASortedMatrix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: deadend
 * @date: 9:31 PM 12/18/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        final int n = matrix.length;
        PriorityQueue<int[]> heap = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < Math.min(n, k); i++) {
            heap.offer(new int[]{matrix[i][0], i, 0});
        }

        int kth = 0;
        while (k-- > 0) {
            int[] curr = heap.poll();
            kth = curr[0];
            if (curr[2] + 1 < n) {
                heap.offer(new int[]{matrix[curr[1]][curr[2] + 1], curr[1], curr[2] + 1});
            }
        }
        return kth;
    }
}

class BinarySearchSolution {
    public int kthSmallest(int[][] matrix, int k) {
        final int n = matrix.length;

        int l = matrix[0][0];
        int r = matrix[n - 1][n - 1];

        while (l < r) {
            int mid = l + (r - l) / 2;
            int count = 0;
            for (int i = 0; i < n; i++) {
                int pos = Arrays.binarySearch(matrix[i], mid + 1);  // 注意Arrays.binarySearch在有重复元素的数组时返回重复元素第二次出现的下标
                count += pos >= 0 ? pos : -pos - 1;
            }
            if (count < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
