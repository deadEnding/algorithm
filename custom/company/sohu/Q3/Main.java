package custom.company.sohu.Q3;

import java.util.Scanner;

public class Main {

    public static boolean backtracking(int ix, int[] scount, int[] tcount) {
        if (ix == 26) {
            for (int i = 0; i < 26; i++) {
                if (tcount[i] != 0) {
                    return false;
                }
            }
            return true;
        }

        if (scount[ix] == 0) {
            return backtracking(ix + 1, scount, tcount);
        }

        for (int i = 0; i < 26; i++) {
            if (i == ix) {
                continue;
            }

            if (tcount[i] >= scount[ix]) {
                tcount[i] -= scount[ix];
                if (backtracking(ix + 1, scount, tcount)) {
                    return true;
                }
                tcount[i] += scount[ix];
            }
        }
        return false;
    }

    public static boolean resolve(String s, String t) {
        int[] scount = new int[26];
        for (char c : s.toCharArray()) {
            scount[c - 'A']++;
        }

        int[] tcount = new int[26];
        for (char c : t.toCharArray()) {
            tcount[c - 'A']++;
        }

        return backtracking(0, scount, tcount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(resolve(s, t) ? "YES" : "NO");
    }
}
