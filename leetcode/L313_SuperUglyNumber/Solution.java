package leetcode.L313_SuperUglyNumber;

/**
 * @author: deadend
 * @date: 10:58 PM 12/13/16
 * @version: 1.0
 * @description:
 */


public class Solution {
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
