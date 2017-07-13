package hihocoder.practice.P12.Q4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: 2:24 PM 03/04/2017
 */


public class Main {

    public static long max(int[] nums) {
        final int n = nums.length;
        long max = 0;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, (long) nums[i] * nums[i + 1] * (nums[i] & nums[i + 1]));
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
