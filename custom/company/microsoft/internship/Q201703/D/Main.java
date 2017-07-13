package custom.company.microsoft.internship.Q201703.D;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    private static int split(String s) {
        int l = 0, r = 0;
        ArrayList<String> sp = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
        }
        return 0;
    }

    private static int min(String s) {
        int l = 0, r = 0;
        int i = 0;
        for (i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                l++;
            else
                r++;

            if (l < r) {
                if (i + 1 < s.length())
                    return 1 + min(s.substring(i + 1));
                return 1;
            }
        }

        return l - r;
    }

    private static HashSet<String> result = new HashSet<>();

    private static void dfs(int ix, int len, int si, String s, int l, int r, String t, int min) {
        if (ix == len) {
            if (l == r && si == s.length()) {
                result.add(t);
            }
            return;
        }

        if (r > l || l + r > min) {
            return;
        }

        dfs(ix + 1, len, si, s, l + 1, r, t + "(", min);
        dfs(ix + 1, len, si, s, l, r + 1, t + ")", min);
        if (si < s.length())
            dfs(ix + 1, len, si + 1, s, l + (s.charAt(si) == '(' ? 1 : 0), r + (s.charAt(si) == ')' ? 1: 0), t + s.charAt(si), min);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int min = min(s);
        dfs(0, min + s.length(), 0, s, 0, 0, "", min);
        System.out.println(min + " " + result.size());
    }
}
