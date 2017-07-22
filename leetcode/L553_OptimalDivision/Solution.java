package leetcode.again.L553_OptimalDivision;

public class Solution {
    public String optimalDivision(int[] nums) {
        final int n = nums.length;
        StringBuilder builder = new StringBuilder();
        builder.append(nums[0]);

        if (n == 2) {
            return builder.append("/").append(nums[1]).toString();
        }

        for (int i = 1; i < n; i++) {
            if (i == 1) {
                builder.append("/(").append(nums[i]);
            } else if (i == n - 1) {
                builder.append("/").append(nums[i]).append(")");
            } else {
                builder.append("/").append(nums[i]);
            }
        }

        return builder.toString();
    }
}

class BasicSolution {
    public String optimalDivision(int[] nums) {
        final int n = nums.length;
        double[][] max = new double[n][n];
        double[][] min = new double[n][n];
        int[][] maxSplit = new int[n][n];
        int[][] minSplit = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            max[i][i] = min[i][i] = nums[i];
            for (int j = i + 1; j < n; j++) {
                min[i][j] = Double.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    if (max[i][k] / min[k + 1][j] > max[i][j]) {
                        max[i][j] = max[i][k] / min[k + 1][j];
                        maxSplit[i][j] = k;
                    }

                    if (min[i][k] / max[k + 1][j] < min[i][j]) {
                        min[i][j] = min[i][k] / max[k + 1][j];
                        minSplit[i][j] = k;
                    }
                }
            }
        }

        return construct(0, n - 1, true, nums, maxSplit, minSplit);
    }

    private String construct(int l, int r, boolean isMax, int[] nums, int[][] maxSplit, int[][] minSplit) {
        if (l == r) {
            return String.valueOf(nums[l]);
        }

        int k = isMax ? maxSplit[l][r] : minSplit[l][r];
        return String.format(k + 1 != r ? "%s/(%s)" : "%s/%s", construct(l, k, isMax, nums, maxSplit, minSplit),
                construct(k + 1, r, !isMax, nums, maxSplit, minSplit));
    }

    public static void main(String[] args) {
        int[] nums = {1000, 100, 10, 2};
        System.out.println(new Solution().optimalDivision(nums));
    }
}
