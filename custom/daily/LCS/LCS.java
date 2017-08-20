package custom.daily.LCS;


public class LCS {

    public String lcs(char[] x, char[] y) {
        final int m = x.length;
        final int n = y.length;

        int[][] dp = new int[m + 1][n + 1];
        int[][] from = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (x[i] == y[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    from[i + 1][j + 1] = 0;
                } else if (dp[i + 1][j] > dp[i][j + 1]) {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                    from[i + 1][j + 1] = 1;
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                    from[i + 1][j + 1] = 2;
                }
            }
        }


        return construct(x, from, m, n);
    }

    private String construct(char[] x, int[][] from, int i, int j) {
        if (i == 0 || j == 0) {
            return "";
        }

        if (from[i][j] == 0) {
            return construct(x, from, i - 1, j - 1) + x[i - 1];
        } else if (from[i][j] == 1) {
            return construct(x, from, i, j - 1);
        } else {
            return construct(x, from, i - 1, j);
        }
    }

    public static void main(String[] args) {
        char[] x = "123456".toCharArray();
        char[] y = "231456".toCharArray();
        System.out.println(new LCS().lcs(x, y));
    }
}


class OldLCS {

    public String lcs(char[] x, char[] y) {
        final int m = x.length;
        final int n = y.length;

        int[][] dp = new int[m + 1][n + 1];
        int[][] b = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (x[i] == y[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    b[i + 1][j + 1] = 1;
                } else if (dp[i + 1][j] > dp[i][j + 1]) {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                    b[i + 1][j + 1] = 2;
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                    b[i + 1][j + 1] = 3;
                }
            }
        }

        System.out.println(dp[m][n]);
        return construct(x, b, m, n);
    }

    public String construct(char[] x, int[][] b, int i, int j) {
        if (i == 0 || j == 0) {
            return "";
        }

        if (b[i][j] == 1) {
            return construct(x, b, i - 1, j - 1) + x[i - 1];
        } else if (b[i][j] == 2) {
            return construct(x, b, i, j - 1);
        } else {
            return construct(x, b, i - 1, j);
        }
    }

}
