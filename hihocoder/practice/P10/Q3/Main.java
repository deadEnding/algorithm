package hihocoder.practice.P10.Q3;

import java.util.HashMap;
import java.util.Scanner;


public class Main {

    private static long comb(int x) {
        return (long)x * (x - 1) / 2;
    }

    private static long getCount(long[] nums, long m) {
        final int n = nums.length;
        HashMap<Long, Integer> counter = new HashMap<>();
        long total = 0;
        long pairs = 0;
        for (int i = 0, start = 0; i < n; i++) {
            int cnt = 1;
            if (counter.containsKey(nums[i])) {
                cnt += counter.get(nums[i]);
            }
            counter.put(nums[i], cnt);
            pairs += cnt - 1;
            while (pairs > m) {
                long old = nums[start++];
                int oldCnt = counter.get(old) - 1;
                counter.put(old, oldCnt);
                pairs -= oldCnt;
            }
            total += i - start + 1;
        }
        return total;
    }

    private static long resolve(long[] nums, int k) {
        long l = 0;
        long r = comb(nums.length);
        while (l < r) {
            long m = l + (r - l) / 2;
            long count = getCount(nums, m);
            if (count < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int c = 0; c < cases; c++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long[] nums = new long[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextLong();
            }
            System.out.println(resolve(nums, k));
        }
    }
}
