package leetcode.L058_LengthOfLastWord;

/**
 * @author: deadend
 * @date: P10:45 PM 11/30/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int lengthOfLastWord(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                for (int j = i; j >= -1; j--) {
                    if (j == -1 || s.charAt(j) == ' ') {
                        return i - j;
                    }
                }
            }
        }

        return 0;
    }
}


class OldSolution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (len > 0 && c == ' ') {
                break;
            } else {
                len += c == ' ' ? 0 : 1;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord(" hh  word"));
    }
}
