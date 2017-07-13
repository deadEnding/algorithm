package custom.company.netease.intern.Q0326;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by deadend on 2017/3/26.
 */
public class ElementNumInSet {

    private static int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    public static int resolve(int w, int x, int y, int z) {
        HashSet<String> set = new HashSet<>();
        for (int i = w; i <= x; i++) {
            for (int j = y; j <= z; j++) {
                int k = gcd(i, j);
                set.add(i / k + "|" + j / k);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        System.out.println(resolve(w, x, y, z));
    }
}
