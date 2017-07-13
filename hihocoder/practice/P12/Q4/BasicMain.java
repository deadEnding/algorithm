package hihocoder.practice.P12.Q4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: 1:45 PM 03/04/2017
 */


public class BasicMain {

    public static long max(int[] nums) {
        final int n = nums.length;
        long max = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                long tmp = (long) nums[i] * nums[j];
                if (tmp * nums[i] <= max)  // 优化，后续不可能有超过max的值
                    break;

                max = Math.max(max, tmp * (nums[i] & nums[j]));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int c = 0; c < cases; c++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums);
            System.out.println(max(nums));
        }
    }
}
