package leetcode.L502_IPO;

import java.util.PriorityQueue;

/**
 * @author: deadend
 * @date: 3:33 PM 28/03/2017
 */


public class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        final int n = Capital.length;
        PriorityQueue<int[]> cheap = new PriorityQueue<>((i1, i2) -> (i1[0] - i2[0]));
        for (int i = 0; i < n; i++) {
            cheap.offer(new int[] {Capital[i], Profits[i]});
        }

        PriorityQueue<int[]> pheap = new PriorityQueue<>((i1, i2) -> (i2[1] - i1[1]));
        while (k-- > 0) {
            while (!cheap.isEmpty() && cheap.peek()[0] <= W) {
                pheap.offer(cheap.poll());
            }

            if (pheap.isEmpty()) {
                break;
            }

            W += pheap.poll()[1];
        }
        return W;
    }
}
