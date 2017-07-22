package custom.company.google.kickstart.roundC.C;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 思路：由于朋友的个数为1或2，因此可以统计答案的各类情况，然后暴力枚举
 */

public class MagicalThinking {

    private static int n;
    private static int q;
    private static String[] friends;
    private static int[] friendsScore;
    private static String mine;

//    private static int solveOne() {
//        int x = 0;
//        for (int i = 0; i < q; i++) {
//            x += friends[0].charAt(i) == mine.charAt(i) ? 1 : 0;
//        }
//
//        int y = q - x;
//        return friendsScore[0] < x ? friendsScore[0] + y : 2 * x + y - friendsScore[0];
//    }

    private static int solve() {
        return n == 1 ? solveOne() : solveTwo();
    }

    private static int solveOne() {
        int A = 0;
        for (int i = 0; i < q; i++) {
            A += friends[0].charAt(i) == mine.charAt(i) ? 1 : 0;
        }

        int B = q - A;
        int max = 0;
        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= B; j++) {
                if (i + B - j == friendsScore[0]) {
                    max = Math.max(max, i + j);
                }
            }
        }
        return max;
    }

    private static int solveTwo() {
        int A = 0, B = 0, C = 0, D = 0;
        for (int i = 0; i < q; i++) {
            char a = friends[0].charAt(i);
            char b = friends[1].charAt(i);
            char c = mine.charAt(i);
            if (a == c && b == c) {
                A++;
            } else if (a == c) {
                B++;
            } else if (b == c) {
                C++;
            } else {
                D++;
            }
        }

        int max = 0;
        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= B; j++) {
                for (int k = 0; k <= C; k++) {
                    for (int l = 0; l <= D; l++) {
                        if (i + j + C - k + D - l == friendsScore[0] && i + B - j + k + D - l == friendsScore[1]) {
                            max = Math.max(max, i + j + k + l);
                        }
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("/Users/deadend/Downloads/C-large-practice1.in");
        System.setIn(fis);

        PrintStream ps=new PrintStream(new FileOutputStream("/Users/deadend/Downloads/C-large.out"));
        System.setOut(ps);

        Scanner sc = new Scanner(System.in);
        int cases = Integer.valueOf(sc.nextLine());
        for (int c = 1; c <= cases; c++) {
            String[] nq = sc.nextLine().split(" ");
            n = Integer.valueOf(nq[0]);
            q = Integer.valueOf(nq[1]);
            friends = new String[n];
            friendsScore = new int[n];
            for (int i = 0; i < n; i++) {
                friends[i] = sc.nextLine();
            }

            mine = sc.nextLine();
            String[] scores = sc.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                friendsScore[i] = Integer.valueOf(scores[i]);
            }

            System.out.println(String.format("Case #%d: %s", c, solve()));
        }
    }
}
