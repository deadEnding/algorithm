package custom.company.microsoft.internship.Q201607.B;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: 10:45 AM 31/03/2017
 */


public class Main {

    private static void resolve(int[][] a, int h) {
        int[] width = new int[h + 1];
        width[1] = 3;
        if (h >= 2)
            width[2] = 5;
        for (int i = 3; i <= h; i++) {
            width[i] = 2 * width[i - 1] + 1;
        }

        int[] cnt = new int[a.length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, h});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < a.length; i++) {
                if (p[0] >= a[i][0] && p[0] <= a[i][2] && p[1] >= a[i][1] && p[1] <= a[i][3]) {
                    cnt[i]++;
                }
            }

            if (p[2] > 1) {
                int d = (width[p[2] - 1] + 1) / 2;
                queue.offer(new int[] {p[0] + d, p[1] - d, p[2] - 1});
                queue.offer(new int[] {p[0] + d, p[1] + d, p[2] - 1});
            }
        }

        for (int c : cnt) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int n = sc.nextInt();
        int[][] area = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                area[i][j] = sc.nextInt();
            }
        }
        resolve(area, h);
    }
}
