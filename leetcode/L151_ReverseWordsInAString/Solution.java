package leetcode.L151_ReverseWordsInAString;


public class Solution {
    private static final char SPACE = ' ';

    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder builder = new StringBuilder();
        for (int i = 0, start = 0; i <= s.length(); i++) {
            char c = i < s.length() ? s.charAt(i) : SPACE;
            if (c == SPACE) {
                if (i > start) {
                    if (builder.length() > 0) {
                        builder.insert(0, SPACE);
                    }
                    builder.insert(0, s.substring(start, i));
                }
                start = i + 1;
            }
        }
        return builder.toString();
    }
}


class OldSolution {
    public String reverseWords(String s) {
        if (s.equals("")) {
            return "";
        }

        s = s.trim();
        int i = 0, j = s.length() - 1;
        while (i <= j && s.charAt(i) != ' ') {
            i++;
        }

        while (i <= j && s.charAt(j) != ' ') {
            j--;
        }

        if (i > j) {
            return s;
        } else {
            String ss = i == j ? "" : reverseWords(s.substring(i + 1, j).trim());
            if (ss.equals("")) {
                return  s.substring(j + 1) + " " + s.substring(0, i);
            } else {
                return s.substring(j + 1) + " " + ss + " " + s.substring(0, i);
            }
        }
    }
}
