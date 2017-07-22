package leetcode.L275_HIndexII;

/**
 * @author: deadend
 * @date: 3:14 PM 3/15/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int hIndex(int[] citations) {
        final int n = citations.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (citations[m] >= n - m) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return n - l;
    }
}

class BasicSolution {
    public int hIndex(int[] citations) {
        final int n = citations.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (citations[m] == n - m) {
                return n - m;
            } else if (citations[m] > n - m) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return n - l;
    }
}

