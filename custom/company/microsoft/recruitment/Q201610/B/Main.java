package custom.company.microsoft.recruitment.Q201610.B;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: deadend
 * @date: 3:29 PM 31/03/2017
 */


public class Main {

    private static int resolve(String com, HashSet<Character>[] set) {
        final int n = com.length();

        int max = 0;
        int[] dp = new int[26];
        for (int i = 0; i < n; i++) {
            int ix = com.charAt(i) - 'a';
            int tmp = 1;  // 必须用tmp，用dp[ix]会出错
            for (char c = 'a'; c <= 'z'; c++) {
                if (!set[ix].contains(c)) {
                    tmp = Math.max(tmp, dp[c - 'a'] + 1);
                }
            }
            dp[ix] = tmp;
            max = Math.max(max, dp[ix]);
        }

        return n - max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String com = sc.nextLine();
        int n = Integer.valueOf(sc.nextLine());
        HashSet<Character>[] set = new HashSet[26];
        for (int i = 0; i < 26; i++) {
            set[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            char c1 = line.charAt(0);
            char c2 = line.charAt(1);
            set[c1 - 'a'].add(c2);
            set[c2 - 'a'].add(c1);
        }
        System.out.println(resolve(com, set));
    }
}
