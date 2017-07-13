package leetcode.L227_BasicCalculatorII;


import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 12:46 PM 12/P10/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public int calculate(String s) {
        long num = 0;
        char sign = '+';
        LinkedList<Long> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (!Character.isSpaceChar(c) || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        break;
                    case '-':
                        num = - num;
                        break;
                    case '*':
                        num = stack.pop() * num;
                        break;
                    case '/':
                        num = stack.pop() / num;
                        break;
                    default:
                        break;
                }

                stack.push(num);
                num = 0;
                sign = c;
            }
        }

        while (!stack.isEmpty())
            num += stack.pop();

        return (int)num;
    }
}

class BasicSolution {
    public int calculate(String s) {
        final int n = s.length();
        LinkedList<Integer> stack = new LinkedList<>();
        int sign = 1;
        stack.push(sign);

        int result = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                if (sign == 1) {
                    result = num;
                } else if (sign == 2) {
                    result *= num;
                } else if (sign == 3) {
                    result /= num;
                }
            } else if (c == '+' || c == '-') {
                stack.push(result);
                sign = c == '+' ? 1 : -1;
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == '*') {
                sign = 2;
            } else if (c == '/') {
                sign = 3;
            }
        }
        stack.push(result);

        result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop() * stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        String s = " 3+5 / 2 ";
        System.out.println(new Solution().calculate(s));
    }
}
