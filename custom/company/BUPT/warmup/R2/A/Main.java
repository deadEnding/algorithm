package custom.company.BUPT.warmup.R2.A;

import java.util.Scanner;

public class Main {

    private static int resove(char[][] board, int n, int m, int k) {
        int rs = k - 1, re = n - k;
        int cs = k - 1, ce = m - k;
        int count = 0;
        int d = k - 1;
        for (int r = rs; r <= re; r++) {
            for (int c = cs; c <= ce; c++) {
                boolean exit = false;
                for (int i = Math.max(0, r - d); i <= Math.min(n - 1, r + d); i++) {
                    int d0 = d - Math.abs(r - i);
                    for (int j = Math.max(0, c - d0); j <= Math.min(m - 1, c + d0); j++) {
                        if (board[i][j] == 'X') {
                            exit = true;
                            break;
                        }
                    }
                    if (exit) {
                        break;
                    }
                }

                if (!exit) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        for (int c = 0; c < cases; c++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            char[][] board = new char[n][];
            for (int i = 0; i < n; i++) {
                board[i] = sc.nextLine().toCharArray();
            }
            System.out.println(resove(board, n, m, k));
        }
    }
}
