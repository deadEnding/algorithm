package leetcode.L533_LonelyPixelII;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 7:39 PM 3/13/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int findBlackPixel(char[][] picture, int N) {
        if (picture == null || picture.length == 0 || picture[0].length == 0) {
            return 0;
        }

        final int m = picture.length, n = picture[0].length;
        int[] colCount = new int[n];
        HashMap<String, Integer> rowCount = new HashMap<>();
        for (int i = 0; i < m; i++) {
            StringBuffer buffer = new StringBuffer();
            int rc = 0;
            for (int j = 0; j < n; j++) {
                buffer.append(picture[i][j]);
                if (picture[i][j] == 'B') {
                    rc++;
                    colCount[j]++;
                }
            }

            if (rc == N) {
                String r = buffer.toString();
                rowCount.put(r, rowCount.getOrDefault(r, 0) + 1);
            }
        }

        int count = 0;
        for (String row : rowCount.keySet()) {
            int rc = rowCount.get(row);
            if (rc == N) {
                for (int j = 0; j < n; j++) {
                    if (row.charAt(j) == 'B' && colCount[j] == N) {
                        count += N;
                    }
                }
            }
        }
        return count;
    }
}
