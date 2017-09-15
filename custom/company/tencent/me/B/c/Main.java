package custom.company.tencent.me.B.c;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();
        long d = sc.nextInt();

        long min = Integer.MAX_VALUE;
        LinkedList<long[]> queue = new LinkedList<>();
        queue.offer(new long[] {a, b, 0L});

        while (!queue.isEmpty()) {
            long[] vs = queue.poll();
            System.out.println(vs[0] + "," + vs[1] + "," + vs[2]);
            if (vs[0] == c && vs[1] == d) {
                min = Math.min(min, vs[2]);
                continue;
            }

            if (vs[0] >= c || vs[1] >= d || vs[2] >= min) {
                continue;
            }

            queue.offer(new long[] {vs[0] + 1, vs[1] + 1, vs[2] + 1});
            queue.offer(new long[] {vs[0] * 2, vs[1] * 2, vs[2] + 1});
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
