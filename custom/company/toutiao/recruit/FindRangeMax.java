package custom.company.toutiao.recruit;

import java.util.LinkedList;

/**
 * 给定数组，找数组下标的区间，使区间内 最小数 * 区间内整数和 的值最大，返回最大值
 */
public class FindRangeMax {

    public int find(int[] nums) {
        final int n = nums.length;
        LinkedList<Integer> stack = new LinkedList<>();
        int[][] range = new int[n][2];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                range[stack.pop()][1] = i;  // not contain
            }

            range[i][0] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            range[stack.pop()][1] = n;
        }

        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i] * (sum[range[i][1]] - sum[range[i][0] + 1]));
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,4};
        System.out.println(new FindRangeMax().find(nums));
    }
}
