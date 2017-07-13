package leetcode.L502_IPO;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: deadend
 * @date: 2:16 PM 2/12/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        final int n = Capital.length;
        PriorityQueue<int[]> profitsMaxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[0], o1[0]);
            }
        });
        PriorityQueue<int[]> capitalMinHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        for (int i = 0; i < n; i++) {
            capitalMinHeap.add(new int[]{Profits[i], Capital[i]});
        }

        for (int ix = 0; ix < k; ix++) {
            while (!capitalMinHeap.isEmpty() && capitalMinHeap.peek()[1] <= W) {
                profitsMaxHeap.add(capitalMinHeap.poll());
            }
            if (profitsMaxHeap.isEmpty()) {
                break;
            }
            W += profitsMaxHeap.poll()[0];
        }
        return W;
    }

    public static void main(String[] args) {
        int k = 2, W = 0;
        int[] Profits = {1,2,3};
        int[] Captial = {1,1,1};
        System.out.println(new Solution().findMaximizedCapital(k, W, Profits, Captial));
    }
}
