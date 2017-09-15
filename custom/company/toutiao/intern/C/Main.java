package custom.company.toutiao.intern.C;

import java.util.Scanner;

public class Main {

    public static int print(int x, int r, int c, char[][] b) {
        if (x == 1) {
            for (int i = 0; i < 5; i++) {
                b[i][c] = '*';
            }
            return 1;
        } else if (x == 2) {
            b[r][c] = b[r][c + 1] = b[r][c + 2] = b[r + 2][c] = b[r + 2][c + 1] = b[r + 2][c + 2] = b[r + 4][c] = b[r + 4][c + 1] = b[r + 4][c + 2] ='*';
            b[r + 1][c + 2] = b[r + 3][c]  = '*';
        } else if (x == 3) {
            b[r][c] = b[r][c + 1] = b[r][c + 2] = b[r + 2][c] = b[r + 2][c + 1] = b[r + 2][c + 2] = b[r + 4][c] = b[r + 4][c + 1] = b[r + 4][c + 2] ='*';
            b[r + 1][c + 2] = b[r + 3][c + 2]  = '*';
        } else if (x == 4) {
            b[r][c] = b[r][c + 2] = b[r + 1][c] = b[r + 1][c + 2] = '*';
            b[r + 2][c] = b[r + 2][c + 1] = b[r + 2][c + 2] = '*';
            b[r + 3][c + 2] = b[r + 4][c + 2] = '*';
        } else if (x == 5) {
            b[r][c] = b[r][c + 1] = b[r][c + 2] = b[r + 2][c] = b[r + 2][c + 1] = b[r + 2][c + 2] = b[r + 4][c] = b[r + 4][c + 1] = b[r + 4][c + 2] ='*';
            b[r + 1][c] = b[r + 3][c + 2]  = '*';
        } else if (x == 6) {
            b[r][c] = b[r][c + 1] = b[r][c + 2] = b[r + 2][c] = b[r + 2][c + 1] = b[r + 2][c + 2] = b[r + 4][c] = b[r + 4][c + 1] = b[r + 4][c + 2] ='*';
            b[r + 1][c] = b[r + 3][c + 2] = b[r + 3][c] = '*';
        } else if (x == 7) {
            b[r][c] = b[r][c + 1] = b[r][c + 2] = '*';
            for (int i = 0; i < 5; i++) {
                b[i][c + 2] = '*';
            }
        } else if (x == 8) {
            b[r][c] = b[r][c + 1] = b[r][c + 2] = b[r + 2][c] = b[r + 2][c + 1] = b[r + 2][c + 2] = b[r + 4][c] = b[r + 4][c + 1] = b[r + 4][c + 2] ='*';
            b[r + 1][c] = b[r + 1][c + 2] = b[r + 3][c + 2] = b[r + 3][c] = '*';
        } else if (x == 9) {
            b[r][c] = b[r][c + 1] = b[r][c + 2] = b[r + 2][c] = b[r + 2][c + 1] = b[r + 2][c + 2] = b[r + 4][c] = b[r + 4][c + 1] = b[r + 4][c + 2] ='*';
            b[r + 1][c] = b[r + 1][c + 2] = b[r + 3][c + 2] = '*';
        } else {
            b[r][c] = b[r][c + 1] = b[r][c + 2] = b[r + 2][c] = b[r + 2][c + 2] = b[r + 4][c] = b[r + 4][c + 1] = b[r + 4][c + 2] ='*';
            b[r + 1][c] = b[r + 1][c + 2] = b[r + 3][c + 2] = b[r + 3][c] = '*';
        }
        return 3;
    }

    public static int print0(char ch, int r, int c, char[][] b) {
        if (ch == '+') {
            b[r + 1][c + 1] = b[r + 2][c] = b[r + 2][c + 1] = b[r + 2][c + 2] = b[r + 3][c + 1] ='*';
        } else if (ch == '-') {
            b[r + 2][c] = b[r + 2][c + 1] = b[r + 2][c + 2] = '*';
        } else if (ch == '*') {
            b[r + 1][c] = b[r + 1][c + 2] = b[r + 2][c + 1] = b[r + 3][c] = b[r + 3][c + 2] =  '*';
        } else if (ch == '/') {
            b[r + 1][c + 2] = b[r + 2][c + 1] = b[r + 3][c] = '*';
        } else  if (ch == '=') {
            b[r + 1][c] = b[r + 1][c + 1] = b[r + 1][c + 2] = b[r + 1][c + 3] = '*';
            b[r + 3][c] = b[r + 3][c + 1] = b[r + 3][c + 2] = b[r + 3][c + 3] = '*';
            return 4;
        } else if (ch == '.') {
            b[r + 3][c] = b[r + 3][c + 1] = b[r + 4][c] = b[r + 4][c + 1] = '*';
            return 2;
        }
        return 3;
    }

    public static void printBoard(char[][] b, int col) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < col; j++) {
                if (b[i][j] == 0) {
                    System.out.print(' ');
                } else {
                    System.out.print(b[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static String trim(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ')
            builder.append(c);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = trim(s);
        String[] ab = s.split("[+\\-\\*/]");
        int a = Integer.valueOf(ab[0]);
        int b = Integer.valueOf(ab[1]);
        if (s.contains("+")) {
            s = s + "=" + (a + b);
        } else if (s.contains("-")) {
            s = s + "=" + (a - b);
        } else if (s.contains("*")) {
            s = s + "=" + (a * b);
        } else {
            if (a % b == 0)
                s = s + "=" + (a / b);
            else
                s = s + "=" + String.format("%.2f", (double)a / b);
        }

        char[][] board = new char[5][100];
        int col = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ')
                continue;

            if (col != 0) {
                col += 2;
            }

            if (Character.isDigit(c)) {
                col += print(c - '0', 0, col, board);
            } else {
                col += print0(c, 0, col, board);
            }
        }

        printBoard(board, col);
    }
}
