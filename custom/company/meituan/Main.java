package custom.company.meituan;

import java.util.*;

public class Main {

    private static int n;
    private static Integer[] nums;

    public static boolean solve() {
        if (n <= 1) {
            return true;
        }

        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int[] sums = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            sums[i] = sums[i + 1] + nums[i];
        }

        return nums[0] <= sums[1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(solve() ? "Yes" : "No");
    }
}
