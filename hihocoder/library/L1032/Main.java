package hihocoder.library.L1032;

import java.util.Scanner;

/**
 * @author: deadend
 * @date: 6:44 PM 12/25/16
 * @version: 1.0
 * @description:
 */


public class Main {
    private static String insert(String s, char ch) {
        StringBuffer sb = new StringBuffer();

        for (char c : s.toCharArray()) {
            sb.append('#');
            sb.append(c);
        }
        sb.append('#');

        return sb.toString();
    }

    public static int maxLength(String s) {
        String ns = insert(s, '#');
        int[] p = new int[ns.length()];

        int max = 0;
        int id = 0, mx = 1;
        for (int i = 1; i < ns.length(); i++) {
            // 关键点
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
            // 向左右延伸求解
            while (i - p[i] >= 0 && i + p[i] < ns.length() && ns.charAt(i + p[i]) == ns.charAt(i - p[i])) {
                p[i]++;
            }
            // 更新右边界最大值
            if (i + p[i] > mx) {
                mx = i + p[i];
                id = i;
            }
            // 更新最大值
            max = Math.max(max, p[i] - 1);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.next());
        while (n-- > 0) {
            System.out.println(maxLength(sc.next()));
        }
    }
}


// 动态规划, O(n^2)
class TimeOutMain {
    public static int maxLength(String s) {
        final int n = s.length();
        if (n == 0) {
            return 0;
        }

        int max = 1;
        boolean[][] isPali = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                isPali[i][j] = s.charAt(i) == s.charAt(j) && (i + 1 == j || isPali[i + 1][j - 1]);
                max = Math.max(max, isPali[i][j] ? j - i + 1 : 0);
            }
            isPali[j][j] = true;
        }
        return max;
    }
}

