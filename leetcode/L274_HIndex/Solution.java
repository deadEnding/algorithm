package leetcode.L274_HIndex;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 2:02 PM 11/25/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int hIndex(int[] citations) {
        final int n = citations.length;
        int[] count = new int[n + 1];

        for (int i = 0; i < n; i++) {
            count[Math.min(n, citations[i])]++;
        }

        for (int i = n; i > 0; i--) {
            if (count[i] >= i) {
                return i;
            } else {
                count[i - 1] += count[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] citations = {1,2,100};
        System.out.println(new Solution().hIndex(citations));
    }
}

class BasicSolution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) {
                return citations.length - i;
            }
        }
        return 0;
    }
}
