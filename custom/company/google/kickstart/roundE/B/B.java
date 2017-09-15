package custom.company.google.kickstart.roundE.B;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class B {

    private static long[] rawnums;

    private static HashMap<Long, Integer> count() {
        HashMap<Long, Integer> map = new HashMap<>();
        for (long num : rawnums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }

    private static long solve() {
        if (rawnums.length < 4) {
            return 0;
        }

        HashMap<Long, Integer> map = count();
        final int n = map.size();
        long[] nums = new long[map.size()];
        int ix = 0;
        for (long key : map.keySet()) {
            nums[ix++] = key;
        }

        Arrays.sort(nums);
        int[] count = new int[map.size()];
        for (int i = 0; i < n; i++) {
            count[i] = map.get(nums[i]);
        }

        long[] sum = new long[n + 1];
        sum[0] = 0;
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + count[i];
        }

        long total = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] < 2) {
                continue;
            }

            if (count[i] >= 3) {
                long c3 = count[i] * (count[i] - 1L) * (count[i] - 2L) / 6;
                long maxOfBig = nums[i] * 3;
                int index = Arrays.binarySearch(nums, maxOfBig);
                index = index < 0 ? - (index + 1) : index;
                total += c3 * (sum[index] - count[i]);
            }

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                long maxOfBig = nums[j] + 2 * nums[i];
                int index = Arrays.binarySearch(nums, j+ 1, n, maxOfBig);
                index = index < 0 ? - (index + 1) : index;

                long cnt;
                if (j < i) {
                    cnt = sum[index] - sum[j + 1] - count[i];
                } else {
                    cnt = sum[index] - sum[j + 1];
                }

                long c2 = count[i] * (count[i] - 1L)/2;
                total += cnt * c2 * count[j];
            }

        }

        return total;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String base = "/Users/deadend/Downloads/";
//        String input = "B-small-attempt0";
        String input = "B-large-practice";
        FileInputStream fis = new FileInputStream(base + input + ".in");
        PrintStream ps = new PrintStream(new FileOutputStream(base + input + ".out"));
        System.setIn(fis);
        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        for (int _c = 1; _c <= cases; _c++) {
            int n = sc.nextInt();
            rawnums = new long[n];
            for (int i = 0; i < n; i++) {
                rawnums[i] = sc.nextLong();
            }
            System.out.println(String.format("Case #%d: %d", _c, solve()));
        }
    }
}
