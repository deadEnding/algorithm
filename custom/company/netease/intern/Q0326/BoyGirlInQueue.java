package custom.company.netease.intern.Q0326;

import java.util.Scanner;

/**
 * Created by deadend on 2017/3/26.
 */
public class BoyGirlInQueue {

    public static int resolve(String s) {
        int boys = 0, girls = 0;
        int b = 0, g = 0;
        for (char c : s.toCharArray()) {
            if (c == 'B') {
                b++;
                girls += g;
            } else {
                g++;
                boys += b;
            }
        }

        return Math.min(boys, girls);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(resolve(s));
    }
}
