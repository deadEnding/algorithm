package custom.company.toutiao.recruit.T1017.B;

import java.util.Scanner;

public class Main {

    private static int n, x;
    private static int[] nums;

    private static void solve() {
        int min = x;
        for (int i = n + x; i > x; i--) {
            int ix = i % n;
            if (nums[min] > nums[ix]) {
                min = ix;
            }
        }

        int[] old = new int[n];
        int minCount = nums[min];
        for (int i = min + 1; i < min + n; i++) {
            int ix = i % n;
            if (min <= x && min < ix && ix <= x || min > x && (ix > min || ix <= x)) {
                old[ix] = nums[ix] - minCount - 1;
                old[min] += minCount + 1;
            } else {
                old[ix] = nums[ix] -  minCount;
                old[min] += minCount;
            }
        }
        old[min] += minCount;

        for (int i = 0; i < n; i++) {
            System.out.print(old[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextInt() - 1;
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        solve();
    }
}
