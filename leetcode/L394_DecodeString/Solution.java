package leetcode.L394_DecodeString;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: P10:37 PM 3/9/17
 * @version: 1.0
 * @description:
 */

public class Solution {
    private String ntime(String s, int n) {
        StringBuilder builder = new StringBuilder();
        while (n-- > 0) {
            builder.append(s);
        }
        return builder.toString();
    }

    public String decodeString(String s) {
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<StringBuilder> stack = new LinkedList<>();
        stack.push(new StringBuilder());

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int val = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    val = val * 10 + s.charAt(++i) - '0';
                }
                numStack.push(val);
            } else if (c == '[') {
                stack.push(new StringBuilder());
            } else if (c == ']') {
                StringBuilder top = stack.pop();
                stack.peek().append(ntime(top.toString(), numStack.pop()));
            } else {
                stack.peek().append(c);
            }
        }

        return stack.peek().toString();
    }
}


class OldSolution {
    private String ntimes(String t, int n) {
        StringBuffer buffer = new StringBuffer();
        while (n-- > 0) {
            buffer.append(t);
        }
        return buffer.toString();
    }

    public String decodeString(String s) {
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<StringBuffer> stack = new LinkedList<>();
        stack.push(new StringBuffer());

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int val = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    val = val * 10 + s.charAt(++i) - '0';
                }
                numStack.push(val);
            } else if (c == '[') {
                stack.push(new StringBuffer());
            } else if (c == ']') {
                StringBuffer t = stack.pop();
                stack.peek().append(ntimes(t.toString(), numStack.pop()));
            } else {
                stack.peek().append(c);
            }
        }
        return stack.peek().toString();
    }

    public static void main(String[] args) {
        String s = "100[leetcode]";
        System.out.println(new Solution().decodeString(s));
    }
}
