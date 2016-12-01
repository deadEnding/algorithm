package leetcode.L060_PermutationSequence;

/**
 * @author: deadend
 * @date: 10:42 AM 12/1/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private int factorial(int x) {
        int f = 1;
        while (x > 1) {
            f *= x;
            x--;
        }
        return f;
    }

    private String helper(int n, int k, boolean[] used) {
        if (n == 1 || k == 0) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < used.length; i++) {
                if (!used[i]) {
                    sb.append(i + 1);
                }
            }
            return sb.toString();
        }

        int f = factorial(n - 1);
        int start = 0;
        for (int d = k / f, i = 0; d >= 0; i++) {
            if (!used[i]) {
                d--;
                start = i;
            }
        }
        used[start] = true;
        return (start + 1) + helper(n - 1, k % f, used);
    }

    public String getPermutation(int n, int k) {
        return helper(n, k - 1, new boolean[n]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(3, 6));
    }
}
