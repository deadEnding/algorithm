package leetcode.L005_LongestPalindromicSubstring;

/**
 * @author: deadend
 * @date: P10:31 AM 11/27/16
 * @version: 1.0
 * @description:
 */


// Manacher算法
public class Solution {
    private String insert(String s, char ch) {
        StringBuffer sb = new StringBuffer();

        for (char c : s.toCharArray()) {
            sb.append('#');
            sb.append(c);
        }
        sb.append('#');

        return sb.toString();
    }

    public String longestPalindrome(String s) {
        String ns = insert(s, '#');
        int[] p = new int[ns.length()];

        int maxi = 0, max = 0;
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
            if (p[i] - 1 > max) {
                max = p[i] - 1;
                maxi = i;
            }
        }
        return s.substring((maxi - max + 1) / 2, (maxi + max) / 2);
    }


    public static void main(String[] args) {
        String s = "baaaa";
        System.out.println(new Solution().longestPalindrome(s));
    }
}


// 动态规划
class DPSolution {
    public String longestPalindrome(String s) {
        final int n = s.length();
        boolean[][] isPali = new boolean[n][n];
        int start = 0;
        int maxLen = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                isPali[i][j] = (s.charAt(i) == s.charAt(j) && (j - i <= 1 ? true : isPali[i+1][j-1]));
                if (isPali[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}

class BasicSolution {
    public String longestPalindrome(String s) {
        final int n = s.length();
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            int a, b;
            if (i % 2 == 1) {   // 空隙
                a = i / 2;
                b = (i + 1) / 2;
            } else {
                a = i / 2 - 1;
                b = i / 2 + 1;
            }
            while (a >= 0 && b < n && s.charAt(a) == s.charAt(b)) {
                a--;
                b++;
            }
            if (b - a - 1 > maxLen) {
                maxLen = b - a - 1;
                start = a + 1;
            }
        }
        return s.substring(start, start + maxLen);
    }
}
