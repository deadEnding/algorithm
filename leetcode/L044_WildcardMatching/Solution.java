package leetcode.L044_WildcardMatching;

/**
 * @author: deadend
 * @date: 3:07 PM 11/30/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean isMatch(String s, String p) {
        int match = 0;     // 遇到过*后匹配失败时回溯到match重新匹配
        int starIx = -1;   // 最近的*的下标

        int i = 0, j = 0;
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                match = i;
                starIx = j++;
            } else if (starIx != -1){
                j = starIx + 1;
                i = match++;
            } else {
                return false;
            }
        }

        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        return j == p.length();
    }

    public static void main(String[] args) {
        String s = "alibaba";
        String p = "**A";
        System.out.println(new Solution().isMatch(s, p));
    }
}
