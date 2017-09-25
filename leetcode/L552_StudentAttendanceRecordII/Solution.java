package leetcode.L552_StudentAttendanceRecordII;

class Solution {
    public int checkRecord(int n) {
        final int MOD = 1000000007;

        int[][][] dp = new int[n + 1][2][3];
        dp[0] = new int[][] {{1,0,0}, {0,0,0}};
        for (int i = 1; i <= n; i++) {
            dp[i][0][0] = ((dp[i - 1][0][0] + dp[i - 1][0][1]) % MOD + dp[i - 1][0][2]) % MOD;
            dp[i][0][1] = dp[i - 1][0][0];
            dp[i][0][2] = dp[i - 1][0][1];
            dp[i][1][0] = (((dp[i - 1][0][0] + dp[i - 1][0][1]) % MOD +
                    (dp[i - 1][0][2] + dp[i - 1][1][0]) % MOD) % MOD + (dp[i - 1][1][1] + dp[i - 1][1][2]) % MOD) % MOD;
            dp[i][1][1] = dp[i - 1][1][0];
            dp[i][1][2] = dp[i - 1][1][1];
        }

        int sum = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sum = (sum + dp[n][i][j]) % MOD;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkRecord(2));
    }
}
