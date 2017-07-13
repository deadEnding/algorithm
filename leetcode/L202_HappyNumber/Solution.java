package leetcode.L202_HappyNumber;

import java.util.HashSet;

/**
 * @author: deadend
 * @date: P10:41 AM 11/25/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        do {
            set.add(n);
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
        } while (n != 1 && !set.contains(n));
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(19));
    }
}
