package leetcode.L313_SuperUglyNumber;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: deadend
 * @date: P10:58 PM 12/13/16
 * @version: 1.0
 * @description:
 */


class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] supers = new int[n];
        supers[0] = 1;

        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < primes.length; i++) {
            heap.offer(new int[] { primes[i] * supers[0], i, 0 });
        }

        for (int i = 1; i < n; i++) {
            int min = heap.peek()[0];
            supers[i] = min;

            while (!heap.isEmpty() && heap.peek()[0] == min) {
                int[] p = heap.poll();
                if (p[2] + 1 < n) {
                    p[0] = primes[p[1]] * supers[++p[2]];
                    heap.offer(p);
                }
            }
        }

        return supers[n - 1];
    }
}

class OldSolution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] supers = new int[n];
        supers[0] = 1;
        int[] index = new int[primes.length];

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, supers[index[j]] * primes[j]);
            }

            supers[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (min == supers[index[j]] * primes[j]) {
                    index[j]++;
                }
            }
        }
        return supers[n - 1];
    }

    public static void main(String[] args) {
        int[] primes = {2, 7, 13, 19};
        System.out.println(new Solution().nthSuperUglyNumber(12, primes));
    }
}
