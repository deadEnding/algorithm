package leetcode.L059_SpiralMatrixII;

/**
 * @author: deadend
 * @date: 9:33 AM 11/17/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int rs = 0;
        int re = n - 1;
        int cs = 0;
        int ce = n - 1;
        int step = 1;
        while (true) {
            for (int j = cs; j <= ce; j++)
                result[rs][j] = step++;
            if (++rs > re) break;

            for (int i = rs; i <= re; i++)
                result[i][ce] = step++;
            if (cs > --ce) break;

            for (int j = ce; j >= cs; j--)
                result[re][j] = step++;
            if (rs > --re) break;

            for (int i = re; i >= rs; i--)
                result[i][cs] = step++;
            if (++cs > ce) break;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] result = new Solution().generateMatrix(0);
        for (int[] row : result) {
            for (int c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
