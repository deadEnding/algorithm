package leetcode.L441_ArrangingCoins;

/**
 * @author: deadend
 * @date: 1:54 PM 12/23/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int arrangeCoins(int n) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2 + 1;
            long count = (1L + mid) * mid / 2;
            if (n < count) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution().arrangeCoins(n));
    }
}