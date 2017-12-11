package custom.company.yixin.A;

import java.util.Scanner;

public class BMain {

    public static int solve(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (i + j == s.length() || s.charAt(i + j) != t.charAt(j)) {
                    break;
                }

                if (j == t.length() - 1) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] st = sc.nextLine().split(" ");
        System.out.println(solve(st[0], st[1]));
    }
}
