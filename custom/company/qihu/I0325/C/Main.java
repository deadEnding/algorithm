package custom.company.qihu.I0325.C;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by deadend on 2017/3/25.
 */
public class Main {

    private static int[] resolve(int[] tasks, int[] tmps) {
        int n = tasks.length, m = tmps.length;
        int[] result = new int[m];

        PriorityQueue<int[]> heap = new PriorityQueue<>((i1, i2) -> (i1[0] - i2[0]));
        for (int i = 0; i < m; i++) {
            heap.offer(new int[] {tmps[i], i});
        }

        int tsp = 1;
        int ix = 0;
        while (!heap.isEmpty()) {
            if (ix < n && tasks[ix] == tsp) {
                tsp = tasks[ix++] + 1;
            } else {
                while (!heap.isEmpty() && (ix == n || heap.peek()[0] < tasks[ix])) {
                    int[] cur = heap.poll();
                    result[cur[1]] = Math.max(tsp, cur[0]);
                }

                if (heap.isEmpty()) {
                    break;
                }

                tsp = tasks[ix];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] tasks = new int[n];
        for (int i = 0; i < n; i++) {
            tasks[i] = sc.nextInt();
        }

        int[] tmps = new int[m];
        for (int j = 0; j < m; j++) {
            tmps[j] = sc.nextInt();
        }

        int[] result = resolve(tasks, tmps);
        for (int re : result) {
            System.out.println(re);
        }
    }
}
