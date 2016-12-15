package leetcode.L316_RemoveDuplicateLetters;

/**
 * @author: deadend
 * @date: 9:26 AM 12/15/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s.equals("")) {
            return "";
        }
        int[] counter = new int[26];
        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }

        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            pos = s.charAt(i) < s.charAt(pos) ? i : pos;
            if ((--counter[s.charAt(i) - 'a']) == 0) {
                break;
            }
        }

        String h = String.valueOf(s.charAt(pos));
        return h + removeDuplicateLetters(s.substring(pos + 1).replace(h, ""));
    }

    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(new Solution().removeDuplicateLetters(s));
    }
}
