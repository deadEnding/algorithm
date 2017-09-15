package leetcode.L308_RangeSumQuery2dMutable;

/**
 * @author: deadend
 * @date: 9:48 PM 3/9/17
 * @version: 1.0
 * @description:
 */

class NumMatrix {

    class BIT2D {
        int[][] sums;

        public BIT2D(int[][] mt) {
            final int m = mt.length, n = mt[0].length;
            sums = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    add(i, j, mt[i][j]);
                }
            }
        }

        private int lowbit(int x) {
            return x & -x;
        }

        public void add(int r, int c, int delta) {
            for (int i = r + 1; i < sums.length; i += lowbit(i)) {
                for (int j = c + 1; j < sums[0].length; j += lowbit(j)) {
                    sums[i][j] += delta;
                }
            }
        }

        public int sum(int r, int c) {
            int sum = 0;
            for (int i = r + 1; i > 0; i -= lowbit(i)) {
                for (int j = c + 1; j > 0; j -= lowbit(j)) {
                    sum += sums[i][j];
                }
            }
            return sum;
        }
    }

    private int[][] matrix;
    private BIT2D bit2D;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        this.matrix = matrix;
        this.bit2D = new BIT2D(matrix);
    }

    public void update(int row, int col, int val) {
        bit2D.add(row, col, val - matrix[row][col]);
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return bit2D.sum(row2, col2) + bit2D.sum(row1 - 1, col1 - 1)
                - bit2D.sum(row1 - 1, col2) - bit2D.sum(row2, col1 - 1);
    }
}



class OldNumMatrix {

    class BIT2D {

        int[][] sums;

        public BIT2D(int[][] mt) {
            final int m = mt.length, n = mt[0].length;
            sums = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    add(i + 1, j + 1, mt[i][j]);
                }
            }
        }

        private int lowbit(int x) {
            return x & -x;
        }

        public void add(int r, int c, int diff) {
            for (int i = r; i < sums.length; i += lowbit(i))  {
                for (int j = c; j < sums[0].length; j += lowbit(j)) {
                    sums[i][j] += diff;
                }
            }
        }

        public int sum(int r, int c) {
            int s = 0;
            for (int i = r; i > 0; i -= lowbit(i)) {
                for (int j = c; j > 0; j -= lowbit(j)) {
                    s += sums[i][j];
                }
            }
            return s;
        }
    }

    private BIT2D bit2d;
    private int[][] matrix;

    public OldNumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        bit2d = new BIT2D(matrix);
        this.matrix = matrix;
    }

    public void update(int row, int col, int val) {
        bit2d.add(row + 1, col + 1, val - matrix[row][col]);
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return bit2d.sum(row2 + 1, col2 + 1) + bit2d.sum(row1, col1) - bit2d.sum(row1, col2 + 1) - bit2d.sum(row2 + 1, col1);
    }
}

