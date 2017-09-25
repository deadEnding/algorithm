package custom.company.xiaomi.C;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    private static char toChar(int v) {
        return (char) (v - '1' + 'a');
    }

    private static ArrayList<String> dfs(String s) {
        final int n = s.length();

        ArrayList<String>[] dp = new ArrayList[2];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new ArrayList<>();
            dp[i].add("");
        }

        for (int i = n - 1; i >= 0; i--) {
            ArrayList<String> current = new ArrayList<>();
            if (s.charAt(i) != '0' && i + 1 < n) {
                char c1 = toChar(Integer.valueOf(s.charAt(i + 1)));
                for (String next : dp[(i + 1) % 2]) {
                    current.add(c1 + next);
                }

                if (i + 2 < n) {
                    int v = Integer.valueOf(s.substring(i, i + 2));
                    if (1 <= v && v <= 26) {
                        char c2 = toChar(v);
                        for (String next : dp[(i + 2) % 2]) {
                            current.add(c2 + next);
                        }
                    }
                }
            }

            dp[i % 2] = current;
        }
        return dp[0];
    }

    public static String solve(String s) {
        ArrayList<String> res = new ArrayList<>();

        String r = "";
        for (int i = 0; i < res.size(); i++) {
            r += res.get(i);
            if (i != res.size() - 1)
                r += " ";
        }
        return r;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(solve(s));
        }
    }
}
