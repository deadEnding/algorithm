package leetcode.L054_SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: deadend
 * @date: 1:05 PM 11/14/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int rs = 0;
        int re = matrix.length - 1;
        int cs = 0;
        int ce = matrix[0].length - 1;

        while (rs <= re && cs <= ce) {
            // 右
            for (int j = cs; j <= ce; j++) {
                result.add(matrix[rs][j]);
            }
            if (++rs > re)
                break;

            // 下
            for (int i = rs; i <= re; i++) {
                result.add(matrix[i][ce]);
            }
            if (cs > --ce)
                break;

            // 左
            for (int j = ce; j >= cs; j--) {
                result.add(matrix[re][j]);
            }
            if (rs > --re)
                break;

            // 上
            for (int i = re; i >= rs; i--) {
                result.add(matrix[i][cs]);
            }
            if (++cs > ce)
                break;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}};
        List<Integer> result = new Solution().spiralOrder(matrix);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
