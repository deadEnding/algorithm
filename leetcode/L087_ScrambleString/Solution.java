package leetcode.L087_ScrambleString;

/**
 * @author: deadend
 * @date: 8:58 PM 12/1/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        final int len = s1.length();
        boolean[][][] dp = new boolean[len][len][len + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int l = 2; l <= len; l++) {
            for (int i = 0; i <= len - l; i++) {
                for (int j = 0; j <= len - l; j++) {
                    for (int k = 1; k < l; k++) {
                        if ((dp[i][j][k] && dp[i + k][j + k][l - k]) || (dp[i][j + l - k][k] && dp[i + k][j][l - k])) {
                            dp[i][j][l] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][len];
    }
}

class BasicSolution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        int len = s1.length();
        int[] count = new int[256];
        for (int i = 0; i < len; i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        for (int i = 1; i < len; i++) {
            if ((isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) ||
                    (isScramble(s1.substring(0, i), s2.substring(len - i)) && isScramble(s1.substring(i), s2.substring(0, len - i)))) {
                return true;
            }
        }
        return false;
    }
}
