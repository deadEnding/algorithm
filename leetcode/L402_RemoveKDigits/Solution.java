package leetcode.L402_RemoveKDigits;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 11:42 AM 12/21/16
 * @version: 1.0
 * @description:
 */


class Solution {
    public String removeKdigits(String num, int k) {
        final int n = num.length();
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && stack.size() + (n - i) > n - k && c < stack.peek()) {
                stack.poll();
            }

            stack.push(c);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = stack.size() - 1, j = 0; j < n - k; j++) {
            char c = stack.get(i--);
            if (builder.length() == 0 && c == '0') {
                continue;
            }
            builder.append(c);
        }

        return builder.length() == 0 ? "0" : builder.toString();
    }

    public static void main(String[] args) {
        String num = "9";
        int k = 1;
        System.out.println(new Solution().removeKdigits(num, k));
    }
}


// worst: O(n^2)
class OldSolution {
    public String removeKdigits(String num, int k) {
        final int m = num.length() - k;

        StringBuffer sb = new StringBuffer();
        for (int i = 0, start = 0; i < m; i++) {
            int end = start + 1;
            int minIndex = start;
            while (num.length() - end + i >= m) {
                minIndex = num.charAt(minIndex) > num.charAt(end) ? end : minIndex;
                end++;
            }
            if (!(sb.length() == 0 && num.charAt(minIndex) == '0')) {
                sb.append(num.charAt(minIndex));
            }
            start = minIndex + 1;
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
