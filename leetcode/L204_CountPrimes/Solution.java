package leetcode.L204_CountPrimes;

/**
 * @author: deadend
 * @date: P10:52 AM 11/25/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i * i < n; i++) {
            if (notPrime[i]) {
                continue;
            }
            for (int j = i * i; j < n; j += i) {
                notPrime[j] = true;
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countPrimes(5));
    }
}
