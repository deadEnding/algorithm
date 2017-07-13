package custom.company.netease.intern.Q0325;

import java.util.Scanner;

/**
 * Created by deadend on 2017/3/25.
 */
public class MainB {

    private static int merge(int[] nums, int s, int m, int e) {
        final int n = e - s + 1;
        int[] tmp = new int[n];
        int total = 0;
        for (int ix = n - 1, i = m, j = e; ix >= 0; ix--) {
            long a = i >= s ? nums[i] : Integer.MIN_VALUE + 1L;
            long b = j >= m + 1 ? nums[j] : Integer.MIN_VALUE + 1L;
            if (a > b) {
                tmp[ix] = nums[i--];
                total += j - m;
            } else {
                tmp[ix] = nums[j--];
            }
        }

        for (int i = s, ix = 0; i <= e; i++) {
            nums[i] = tmp[ix++];
        }
        return total;
    }

    private static int countInversePairs(int[] nums, int s, int e) {
        if (s == e) {
            return 0;
        }

        int total = 0;
        int m = s + (e - s) / 2;
        total += countInversePairs(nums, s, m) + countInversePairs(nums, m + 1, e);
        total += merge(nums, s, m, e);
        return total;
    }

    private static int resolve(String s) {
        final int n = s.length();
        int[] nums1 = new int[n];
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            nums1[i] = c == 'G' ? 1 : 2;
            nums2[i] = c == 'G' ? 2 : 1;
        }

        return Math.min(countInversePairs(nums1, 0, n - 1), countInversePairs(nums2, 0, n - 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        System.out.println(resolve(s));
    }
}
