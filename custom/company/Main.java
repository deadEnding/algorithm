package custom.company;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static int solve(int n, int m, HashMap<Integer, HashMap<Integer, Integer>> cache) {
        if (n == 0 || m == 1) {
            return 1;
        }

        if (cache.containsKey(n) && cache.get(n).containsKey(m)) {
            return cache.get(n).get(m);
        }

        if (!cache.containsKey(n)) {
            cache.put(n, new HashMap<>());
        }

        int count;
        if (n < m) {
            count = solve(n, m / 2, cache);
        } else {
            count = solve(n, m / 2, cache) + solve(n - m, m, cache);
        }

        cache.get(n).put(n, count);
        return count;
    }

    private static int solve(int n) {
        int i;
        for (i = 31; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                break;
            }
        }

        return solve(n, 1 << i, new HashMap<Integer, HashMap<Integer, Integer>>());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(n));
    }
}
