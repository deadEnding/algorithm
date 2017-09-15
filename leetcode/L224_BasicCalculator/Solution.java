package leetcode.L224_BasicCalculator;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 9:48 AM 12/P10/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public int calculate(String s) {
        final int n = s.length();
        LinkedList<Integer> stack = new LinkedList<>();
        int sign = 1;
        int result = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (Character.isDigit(c)) {
                int v = c - '0';
                while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
                    v = v * 10 + s.charAt(++i) - '0';
                }
                result += v * sign;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                sign = stack.pop();
                result = stack.pop() + sign * result;
            }
        }

        return result;
    }
}


class OldSolution {
    public int calculate(String s) {
        final int n = s.length();
        LinkedList<Integer> stack = new LinkedList<>();
        int sign = 1;
        int result = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result += num * sign;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result = result * stack.pop() + stack.pop();
            }
        }
        return result;
    }
}
