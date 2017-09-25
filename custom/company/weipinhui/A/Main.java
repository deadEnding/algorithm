package custom.company.weipinhui.A;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] b = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                b[i][j] = (char) (sc.nextInt() + '0');
            }
        }

        solveSudoku(b);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(b[i][j]);
                if (j != 8) {
                    System.out.print(" ");
                } else {
                    System.out.println();
                }
            }
        }
    }


    public static void solveSudoku(char[][] board) {
        solve(board, 0);
    }

    private static boolean solve(char[][] board, int k) {
        if (k == 81) {
            return true;
        }

        int i = k / 9, j = k % 9;
        if (board[i][j] == '0') {
            for (char c = '1'; c <= '9'; c++) {
                board[i][j] = c;
                if (isValid(board, i, j) && solve(board, k + 1)) {
                    return true;
                }
                board[i][j] = '0';
            }
            return false;
        } else {
            return solve(board, k + 1);
        }
    }

    private static boolean isValid(char[][] board, int i, int j) {
        boolean[] row = new boolean[9];
        boolean[] col = new boolean[9];
        boolean[] sqr = new boolean[9];
        for (int k = 0; k < 9; k++) {
            if (board[i][k] != '0') {
                if (row[board[i][k] - '1']) {
                    return false;
                }
                row[board[i][k] - '1'] = true;
            }

            if (board[k][j] != '0') {
                if (col[board[k][j] - '1']) {
                    return false;
                }
                col[board[k][j] - '1'] = true;
            }

            int ix = i / 3 * 3 + k / 3;
            int jx = j / 3 * 3 + k % 3;
            if (board[ix][jx] != '0') {
                if (sqr[board[ix][jx] - '1']) {
                    return false;
                }
                sqr[board[ix][jx] - '1'] = true;
            }
        }
        return true;
    }
}

