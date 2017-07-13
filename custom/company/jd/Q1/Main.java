package custom.company.jd.Q1;

import java.util.Scanner;

public class Main {

    public static int solve(String s) {
        final int n = s.length();
        int count = 0;
        boolean[] find = new boolean[n];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int d = c - '0';
                for (int j = i - d; j <= i + d; j++) {
                    if (0 <= j && j < n && s.charAt(j) == 'X' && !find[j]) {
                        find[j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String s = sc.nextLine();
        System.out.println(solve(s));
    }
}
