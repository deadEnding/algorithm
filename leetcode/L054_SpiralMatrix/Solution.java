package leetcode.L054_SpiralMatrix;


import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int rs = 0, re = matrix.length - 1;
        int cs = 0, ce = matrix[0].length - 1;

        while (rs <= re && cs <= ce) {

            for (int j = cs; j <= ce; j++) {
                result.add(matrix[rs][j]);
            }

            if (++rs > re) {
                break;
            }

            for (int i = rs; i <= re; i++) {
                result.add(matrix[i][ce]);
            }

            if (--ce < cs) {
                break;
            }

            for (int j = ce; j >= cs; j--) {
                result.add(matrix[re][j]);
            }

            if (--re < rs) {
                break;
            }

            for (int i = re; i >= rs; i--) {
                result.add(matrix[i][cs]);
            }

            if (++cs > ce) {
                break;
            }
        }
        return result;
    }
}
