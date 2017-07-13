package custom.company.alibaba.internship;

import java.util.Scanner;

/**
 * @author: deadend
 * @date: 1:40 PM 3/15/17
 * @version: 1.0
 * @description:
 */


public class TreeSolution {

    public static int resolve(int[] nums) {
        final int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int sum = 0;
        int height = nums[n - 1] / 100;     // 高度
        int[] children = new int[n];        // 以每个节点为根的叶子节点个数
        for (int i = n - 1, ix = n - 1; i >= 0; i--) {    // 自底向上
            int a = nums[i] / 100;
            int b = nums[i] % 100 / 10;
            int c = nums[i] % 10;
            if (a == height) {
                children[i] = 1;
            } else {
                int from = (a + 1) * 100 + (2 * b - 1) * 10;
                int to = (a + 1) * 100 + 2 * b * 10 + 9;
                while (ix > i && from <= nums[ix] && nums[ix] <= to) {
                    children[i] += children[ix];
                    ix--;
                }
                if (children[i] == 0) {
                    children[i] = 1;
                }
            }
            sum += children[i] * c;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {113, 215, 221, 312, 324};
        System.out.println(new TreeSolution().resolve(nums));
    }
}
