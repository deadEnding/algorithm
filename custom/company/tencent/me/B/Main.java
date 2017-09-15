package custom.company.tencent.me.B;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nk = sc.nextLine().split(" ");
        int n = Integer.valueOf(nk[0]);
        int k = Integer.valueOf(nk[1]);

        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < n; j++) {
                d[i][j] = line.charAt(j) - '0';
            }
        }

        double min = Long.MAX_VALUE;
        LinkedList<String[]> queue = new LinkedList<>();
        queue.offer(new String[] {"0", String.valueOf(k), "0"});
        while (!queue.isEmpty()) {
            String[] vs = queue.poll();
            int pos = Integer.valueOf(vs[0]);
            int remain = Integer.valueOf(vs[1]);
            double dist = Double.valueOf(vs[2]);
            if (pos == 1) {
                min = Math.min(min, dist);
                continue;
            }

            if (dist > min) {
                continue;
            }

            for (int i = 0; i < n; i++) {
                if (i != pos) {
                    queue.offer(new String[] {String.valueOf(i), String.valueOf(remain), String.valueOf(dist + d[pos][i])});
                    if (k > 0)
                        queue.offer(new String[] {String.valueOf(i), String.valueOf(remain - 1), String.valueOf(dist + d[pos][i] / 2.0)});
                }
            }
        }

        System.out.println(String.format("%.1f", min));
    }
}
