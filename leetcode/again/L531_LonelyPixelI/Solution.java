package leetcode.again.L531_LonelyPixelI;

/**
 * @author: deadend
 * @date: 7:00 PM 3/13/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int findLonelyPixel(char[][] picture) {
        if (picture == null || picture.length == 0 || picture[0].length == 0) {
            return 0;
        }

        final int m = picture.length, n = picture[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count += (picture[i][j] == 'B' && row[i] == 1 && col[j] == 1) ? 1 : 0;
            }
        }
        return count;
    }
}
