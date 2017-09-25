package custom.company.qihu.I0921;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (i + 2 < n && nums[i] <= nums[i +1 ] && nums[i + 1] <= nums[i + 2]) {
                sum[i + 1] = sum[i] + 1;
            } else {
                sum[i + 1] = sum[i];
            }
        }


        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            if (r - l < 2) {
                System.out.println(0);
            } else {

                System.out.println(sum[r - 2] - sum[l - 1]);
            }
        }

    }
}
