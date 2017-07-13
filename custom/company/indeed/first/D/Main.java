package custom.company.indeed.first.D;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    private static int n, a, b;

    private static long total;

    private static boolean check(Integer[] h, int level) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((h1, h2) -> (h2 - h1));
        int leave = a;
        long cut = 0;

        for (int num : h) {
            int times = num / level;
            cut += Math.min(leave, times) * level;
            leave -= Math.min(leave, times);

            if (leave <= 0) {
                return total - cut <= (b - a);
            }

            if (num % level != 0) {
                heap.offer(num % level);
            }
        }

        for (;leave > 0 && !heap.isEmpty(); leave--) {
            int v = heap.poll();
            cut += Math.min(v, level);
            if (v > level) {
                heap.offer(v - level);
            }
        }

        return total - cut <= (b - (a - leave));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        Integer[] h = new Integer[n];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
            total += h[i];
        }

        Arrays.sort(h, (h1, h2) -> (h2 - h1));
        int l = 1, r = h[0];

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(h, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if (check(h, l)) {
            System.out.println(l);
        } else {
            System.out.println(-1);
        }
    }
}
