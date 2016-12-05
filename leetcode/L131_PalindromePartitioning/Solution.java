package leetcode.L131_PalindromePartitioning;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 8:18 PM 12/5/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private List<List<String>> result = new LinkedList<>();

    private void helper(String s, boolean[][] isPali, int ix, LinkedList<String> path) {
        if (ix == isPali.length) {
            result.add(new LinkedList(path));
            return;
        }

        for (int i = ix; i < isPali.length; i++) {
            if (isPali[ix][i]) {
                path.addLast(s.substring(ix, i + 1));
                helper(s, isPali, i + 1, path);
                path.removeLast();
            }
        }
    }

    public List<List<String>> partition(String s) {
        final int n = s.length();
        boolean[][] isPali = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                isPali[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 1 || isPali[i + 1][j - 1]);
            }
        }

        helper(s, isPali, 0, new LinkedList<String>());
        return result;
    }

    public static void main(String[] args) {
        String s = "efe";
        List<List<String>> result = new Solution().partition(s);
        for (List<String> list : result) {
            System.out.println(list.toString());
        }
    }
}
