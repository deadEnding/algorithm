package leetcode.L316_RemoveDuplicateLetters;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 12:22 PM 3/17/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] counter = new int[26];
        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }

        boolean[] visited = new boolean[26];
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            int ix = c - 'a';
            counter[ix]--;
            if (visited[ix]) {
                continue;
            }

            while (!stack.isEmpty() && c < stack.peek() && counter[stack.peek() - 'a'] != 0) {
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            visited[ix] = true;
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "ccacbaba";
        System.out.println(new Solution().removeDuplicateLetters(s));
    }
}

class BasicSolution {
    public String removeDuplicateLetters(String s) {
        if (s.equals("")) {
            return "";
        }

        int[] counter = new int[26];
        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }

        int min = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(min)) {
                min = i;
            }

            if (--counter[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }

        String h = String.valueOf(s.charAt(min));
        return h + removeDuplicateLetters(s.substring(min + 1).replace(h, ""));
    }
}
