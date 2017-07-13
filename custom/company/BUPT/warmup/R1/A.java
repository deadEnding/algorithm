package custom.company.BUPT.warmup.R1;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: 6:16 PM 28/03/2017
 */


public class A {

    private static HashSet<Integer> prims = new HashSet<>();

    private static boolean isPrim(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void init() {
        for (int i = 2; i <= (1 << 15); i++) {
            if (isPrim(i)) {
                prims.add(i);
            }
        }
    }

    public static int resolve(int n) {
        int cnt = 0;
        for (int i : prims) {
            int j = n - i;
            if (prims.contains(i) && prims.contains(j)) {
                cnt += i == j ? 2 : 1;
            }
        }
        return cnt / 2;
    }

    public static void main(String[] args) {
        init();
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            System.out.println(resolve(n));
        }
    }
}
