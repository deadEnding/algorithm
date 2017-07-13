package hihocoder.practice.P12.Q2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: 11:05 AM 03/04/2017
 */


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> count = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            for (int j = 0, x = 0; j < m; j++) {
                x += sc.nextInt();
                if (j != m - 1) {
                    if (!count.containsKey(x)) {
                        count.put(x, 1);
                    } else {
                        count.put(x, count.get(x) + 1);
                    }
                    max = Math.max(max, count.get(x));
                }
            }
        }
        System.out.println(n - max);
    }
}
