package leetcode.L557_ReverseWordsInAStringIII;

public class Solution {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0, start = 0; i <= s.length(); i++) {
            char c = i < s.length() ? s.charAt(i) : ' ';
            if (c == ' ') {
                builder.append(new StringBuilder(s.substring(start, i)).reverse());
                builder.append(i < s.length() ? " " : "");
                start = i + 1;
            }
        }

        return builder.toString();
    }
}

