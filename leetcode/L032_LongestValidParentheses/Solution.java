package leetcode.L032_LongestValidParentheses;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 12:46 PM 11/30/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        int last = -1;
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {      // 匹配中断
                    last = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {  // 上一次中断到现在全部匹配成功
                        max = Math.max(max, i - last);
                    } else {                // 上一次中断到现在部分匹配成功
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "((";
        System.out.println(new Solution().longestValidParentheses(s));
    }
}

class BasicSolution {
    public int longestValidParentheses(String s) {
        int max = 0;
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    int start = stack.pop();
                    if (start == -1) {
                        stack.pop();
                        if (!stack.isEmpty()) {
                            start = stack.pop();
                        } else {
                            continue;
                        }
                    }

                    int len = i - start + 1;
                    while (!stack.isEmpty() && stack.peek() == -1) {
                        stack.pop();
                        int l = stack.pop();
                        len += l;
                    }
                    max = Math.max(max, len);
                    stack.push(len);
                    stack.push(-1);
                }
            }
        }
        return max;
    }
}
