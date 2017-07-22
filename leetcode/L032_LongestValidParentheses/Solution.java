package leetcode.L032_LongestValidParentheses;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 9:58 AM 2/27/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    class Item {
        int ix;
        char c;

        public Item(int ix, char c) {
            this.ix = ix;
            this.c = c;
        }
    }

    public int longestValidParentheses(String s) {
        final int n = s.length();

        int max = 0;
        LinkedList<Item> stack = new LinkedList<>();
        stack.push(new Item(-1, ')'));

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' && stack.peek().c == '(') {
                stack.pop();
                max = Math.max(max, i - stack.peek().ix);
            } else {
                stack.push(new Item(i, c));
            }
        }

        return max;
    }
}

class OldSolution {

    public int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && stack.peek() >= 0) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(max, i + 1);
                    } else {
                        int t = stack.peek();
                        max = Math.max(max, i - (t >= 0 ? t : -(t + 1)));
                    }
                } else {
                    stack.push(-i - 1);
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        String s = ")()())()()(";
        System.out.println(new Solution().longestValidParentheses(s));
    }
}
