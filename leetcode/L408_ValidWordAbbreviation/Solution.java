package leetcode.L408_ValidWordAbbreviation;

/**
 * @author: deadend
 * @date: 5:34 PM 3/13/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;

        while (i < word.length() && j < abbr.length()) {
            char wc = word.charAt(i);
            char ac = abbr.charAt(j);
            if (wc == ac) {
                i++;
                j++;
            } else if (Character.isLetter(ac)) {
                return false;
            } else {
                if (ac == '0') {
                    return false;
                }

                int num = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + abbr.charAt(j++) - '0';
                }

                i += num;
            }
        }


        return i == word.length() && j == abbr.length();
    }
}

class RecuSolution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word.length() == 0 && abbr.length() == 0) {
            return true;
        }

        if (word.length() == 0 || abbr.length() == 0) {
            return false;
        }

        if (Character.isLetter(abbr.charAt(0))) {
            return word.charAt(0) == abbr.charAt(0) && validWordAbbreviation(word.substring(1), abbr.substring(1));
        }

        if (abbr.charAt(0) == '0') {
            return false;
        }

        int num = abbr.charAt(0) - '0';
        for (int ix = 1; ix < abbr.length() && Character.isDigit(abbr.charAt(ix)); ix++) {
            num = num * 10 + abbr.charAt(ix) - '0';
        }

        if (word.length() < num) {
            return false;
        }

        return validWordAbbreviation(word.substring(num), abbr.substring(String.valueOf(num).length()));
    }
}


class OldSolution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            char c = abbr.charAt(j);
            if (word.charAt(i) == c) {
                i++;
                j++;
            } else if (Character.isLetter(c)) {
                return false;
            } else {
                if (c == '0') {
                    return false;
                }
                int n = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    n = n * 10 + abbr.charAt(j) - '0';
                    j++;
                }
                i += n;
            }
        }
        return i == word.length() && j == abbr.length();
    }

    public static void main(String[] args) {
        String word = "internationalization";
        String abbr = "i12iz4n";
        System.out.println(new Solution().validWordAbbreviation(word, abbr));
    }
}
