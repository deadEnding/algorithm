package leetcode.again.L131_PalindromePartitioning;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 2:16 PM 2/28/17
 * @version: 1.0
 * @description:
 */


public class Solution {

    private void backtrace(String s, int ix, boolean[][] isPali, LinkedList<String> path, List<List<String>> result) {
        if (ix == s.length()) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = ix; i < s.length(); i++) {
            if (isPali[ix][i]) {
                path.add(s.substring(ix, i + 1));
                backtrace(s, i + 1, isPali, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        final int n = s.length();
        boolean[][] isPali = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                isPali[i][j] = s.charAt(i) == s.charAt(j) && (i + 1 >= j || isPali[i + 1][j - 1]);
            }
        }
        List<List<String>> result = new LinkedList<>();
        backtrace(s, 0, isPali, new LinkedList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        String s = "efe";
        System.out.println(new Solution().partition(s));
    }
}
