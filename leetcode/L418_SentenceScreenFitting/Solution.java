package leetcode.again.L418_SentenceScreenFitting;

/**
 * @author: deadend
 * @date: 9:12 AM 3/P10/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int len = s.length();
        int start = 0;
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % len) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start - 1) % len) != ' ') {
                    start--;
                }
            }
        }

        return start / s.length();
    }

    public static void main(String[] args) {
        int r = 1;
        int c = 1;
        String[] s = {"a"};
        System.out.println(new Solution().wordsTyping(s, r, c));
    }
}


class TimeoutSolution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if (sentence == null || sentence.length == 0 || rows == 0 || cols == 0) {
            return 0;
        }

        final int len = rows * cols;
        int count = 0;
        for (int i = 0, ix = 0; i < len; ix++) {
            String s = sentence[(ix %= sentence.length)];
            if (i != 0 && i % cols != 0) {   // 空格
                i++;
            }

            if (i + s.length() <= (i / cols + 1) * cols) { // 此行可以放下
                i += s.length();
            } else if (cols < s.length()) {
                break;
            } else {
                i = (i / cols + 1) * cols + s.length();
            }

            if (ix == sentence.length - 1 && i - 1 < len) {
                count++;
            }
        }
        return count;
    }
}
