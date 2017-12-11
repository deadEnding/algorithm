package custom.company.toutiao.recruit.T1017.A;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private static int m, n;
    private static char[][] b;

    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int[] find(char c) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (b[i][j] == c) {
                    b[i][j] = '.';
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }


    private static int solve() {
        int[] s = find('0');
        int[] p = find('S');
        int[] e = find('E');
        boolean[][][] visited = new boolean[m][n][4];
        LinkedList<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {s[0], s[1], p[0], p[1], 0});
        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] x = queue.poll();
            if (x[0] == e[0] && x[1] == e[1]) {
                min = Math.min(min, x[4]);
                continue;
            }

            for (int d = 0; d < dirs.length; d++) {
                if (visited[x[0]][x[1]][d]) {
                    continue;
                }

                visited[x[0]][x[1]][d] = true;
                int nx = x[0] + dirs[d][0];
                int ny = x[1] + dirs[d][1];
                int npx = x[0] + dirs[d][0] * -1;
                int npy = x[1] + dirs[d][1] * -1;

                if (reachable(nx, ny)) {
                    int dist = canArrive(x[2], x[3], npx, npy, x[0], x[1]);
                    if (dist < 0) {
                        continue;
                    }
                    queue.offer(new int[] {nx, ny, x[0], x[1], x[4] + dist + 1});
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private static int canArrive(int sx, int sy, int ex, int ey, int x, int y) {
        b[x][y] = '#';

        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {sx, sy, 0});
        boolean[][] visited = new boolean[m][n];
        while (!queue.isEmpty()) {
            int[] p = queue.poll();

            if (p[0] == ex && p[1] == ey) {
                b[x][y] = '.';
                return p[2];
            }

            for (int d = 0; d < dirs.length; d++) {
                int nx = p[0] + dirs[d][0];
                int ny = p[1] + dirs[d][1];
                if (!reachable(nx, ny)) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny, p[2] + 1});
            }
        }

        b[x][y] = '.';
        return -1;
    }

    private static boolean reachable(int nx, int ny) {
        if (nx < 0 || ny < 0 || nx >= m || ny >= n || b[nx][ny] == '#') {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        sc.nextLine();
        b = new char[m][n];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextLine().toCharArray();
        }

        System.out.println(solve());
    }
}
