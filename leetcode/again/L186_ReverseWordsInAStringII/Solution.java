package leetcode.again.L186_ReverseWordsInAStringII;

public class Solution {
    private void reverse(char[] s, int l, int r) {
        for (; l < r; l++, r--) {
            char t = s[l];
            s[l] = s[r];
            s[r] = t;
        }
    }

    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        for (int l = -1, r = 0; r <= s.length; r++) {
            if (r == s.length || s[r] == ' ') {
                reverse(s, l + 1, r - 1);
                l = r;
            }
        }
    }

    public static void main(String[] args) {
        char[] s = "hello world - deadend".toCharArray();
        new Solution().reverseWords(s);
        for (char c : s) {
            System.out.print(c);
        }
        System.out.println();
    }
}
