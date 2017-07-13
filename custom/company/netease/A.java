package custom.company.netease;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by deadend on 2017/3/25.
 */
public class A {

    private static HashSet<Integer> prim = new HashSet<>();

    private static boolean isPrim(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void init(int n) {
        for (int i = 2; i < n; i++) {
            if (isPrim(i)) {
                prim.add(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        init(n);
        int count = 0;
        for (int i = 2; i * 2 <= n; i++) {
            if (prim.contains(i) && prim.contains(n - i)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
