package leetcode.again.L091_DecodeWays;

/**
 * @author: deadend
 * @date: 1:11 PM 2/28/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int numDecodings(String s) {
        final int n = s.length();
        if (n == 0) {
            return 0;
        }

        int[] f = new int[2];
        f[n % 2] = 1;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '0') {
                f[i % 2] = 0;
            } else if (c == '1' || (c == '2' && i + 1 < n && s.charAt(i + 1) <= '6')) {
                f[i % 2] += f[(i + 1) % 2];
            } else {
                f[i % 2] = f[(i + 1) % 2];
            }
        }

        return f[0];
    }
}


class BasicSolution {
    public int numDecodings(String s) {
        if (s.equals("")) {
            return 0;
        }

        final int n = s.length();
        int count = 1, preCount = 0;
        for (int i = n - 1; i >= 0; i--) {
            int tmp = count;
            char c = s.charAt(i);
            if (c == '0') {
                count = 0;
            } else if (c == '1' || (c == '2' && i + 1 < n && s.charAt(i + 1) <= '6')) {
                count += preCount;
            }
            preCount = tmp;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings(""));
    }
}
