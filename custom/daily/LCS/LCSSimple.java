package custom.daily.LCS;

/**
 * Created by yuhui.zzc on 20/08/2017.
 */
public class LCSSimple {

    public int lcs(char[] x, char[] y) {
        final int m = x.length;
        final int n = y.length;

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (x[i] == y[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        char[] x = "123456".toCharArray();
        char[] y = "231456".toCharArray();
        System.out.println(new LCSSimple().lcs(x, y));
    }
}
