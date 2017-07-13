package custom.company.baidu.Q2016.smallestcost;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SmallestCost {

    public static long solve(String s, long[] l, long[] r) {
        final int n = s.length();
        int sum = 0;
        PriorityQueue<long[]> heap = new PriorityQueue<>((l1, l2) -> (Long.compare(l1[0], l2[0])));

        char[] chs = s.toCharArray();
        for (int i = 0, delta = 0; i < n; i++) {
            char c = chs[i];
            if (c == '?') {   // 默认转化为右括号
                sum += r[i];
                heap.offer(new long[] {l[i] - r[i], i});
                chs[i] = ')';
            }

            if (c == '(') {
                delta++;
            } else {
                delta--;
            }

            if (delta < 0) {
                if (heap.isEmpty()) {
                    return -1L;
                }

                long[] p = heap.poll();
                sum += p[0];
                chs[(int) p[1]] = '(';
                delta += 2;
            }
        }

        System.out.println(new String(chs));
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();

        long[] l = new long[n];
        long[] r = new long[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '?') {
                l[i] = sc.nextLong();
                r[i] = sc.nextLong();
            }
        }

        System.out.println(solve(s, l, r));
    }
}
