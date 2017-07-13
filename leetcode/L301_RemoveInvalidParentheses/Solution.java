package leetcode.L301_RemoveInvalidParentheses;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 1:49 PM 2/16/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            count += c == '(' ? 1 : (c == ')' ? -1 : 0);
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new LinkedList<>();
        LinkedList<String> queue = new LinkedList<>();
        queue.add(s);
        HashSet<String> visited = new HashSet<>();
        visited.add(s);
        while (!queue.isEmpty()) {
            String t = queue.poll();

            if (!result.isEmpty() && result.get(0).length() > t.length()) {
                break;
            }

            if (isValid(t)) {
                result.add(t);
            }

            for (int i = 0; i < t.length(); i++) {
                if (t.charAt(i) != '(' && t.charAt(i) != ')') {
                    continue;
                }

                String ns = t.substring(0, i) + t.substring(i + 1);
                if (!visited.contains(ns)) {
                    queue.add(ns);
                    visited.add(ns);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "))";
        List<String> result = new Solution().removeInvalidParentheses(s);
        System.out.println(result);
    }
}
