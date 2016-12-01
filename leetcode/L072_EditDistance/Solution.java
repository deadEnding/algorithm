package leetcode.L072_EditDistance;

/**
 * @author: deadend
 * @date: 4:16 PM 12/1/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int minDistance(String word1, String word2) {
        final int n1 = word1.length();
        final int n2 = word2.length();

        int[][] dist = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            dist[i][0] = i;
        }

        for (int j = 0; j <= n2; j++) {
            dist[0][j] = j;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                int replace = dist[i-1][j-1] + (word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1);
                dist[i][j] = Math.min(Math.min(dist[i][j-1], dist[i-1][j]) + 1, replace);
            }
        }
        return dist[n1][n2];
    }
}
