package leetcode.L097_InterleavingString;

/**
 * @author: deadend
 * @date: 10:08 PM 12/2/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        final int n1 = s1.length();
        final int n2 = s2.length();
        final int n3 = s3.length();

        if (n1 + n2 != n3) {
            return false;
        }

        boolean[][] can = new boolean[n1 + 1][n2 + 1];

        can[0][0] = true;

        for (int i = 1; i <= n1; i++) {
            can[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
        }

        for (int j = 1; j <= n2; j++) {
            can[0][j] = s2.substring(0, j).equals(s3.substring(0, j));
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if ((can[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) ||
                    (can[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))) {
                    can[i][j] = true;
                }
            }
        }

        return can[n1][n2];
    }

    public static void main(String[] args) {
        String s1 = "";
        String s2 = "c";
        String s3 = "c";
        System.out.println(new Solution().isInterleave(s1, s2, s3));
    }
}
