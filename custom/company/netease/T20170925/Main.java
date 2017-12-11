package custom.company.netease.T20170925;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int n, s;
    private static int[] nums;
    private static int minDist = Integer.MAX_VALUE;

    private static void dfs(int ix) {
        if (ix == n) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int num : nums) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            minDist = Math.min(minDist, max - min);
            return;
        }

        int val = nums[ix];
        nums[ix] = val + s;
        dfs(ix + 1);

        nums[ix] = val - s;
        dfs(ix + 1);

        nums[ix] = val;
    }

    private static int solve() {
        dfs(0);
        return minDist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);
        System.out.println(solve());
    }
}
