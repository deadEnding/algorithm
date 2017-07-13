package leetcode.again.L151_ReverseWordsInAString;


public class Solution {
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
