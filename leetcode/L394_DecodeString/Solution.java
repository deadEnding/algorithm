package leetcode.L394_DecodeString;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 9:47 PM 12/19/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        stack.push("");

        for (int i = 0, count = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                for (count = c - '0'; i + 1 < s.length() && Character.isDigit(s.charAt(i + 1)); i++) {
                    count = count * 10 + s.charAt(i + 1) - '0';
                }
                stack.push(String.valueOf(count));
            } else if (c == '[') {
                stack.push("");
            } else if (c == ']') {
                StringBuffer tmp = new StringBuffer();
                String top = stack.pop();
                count = Integer.valueOf(stack.pop());
                while (count-- > 0) {
                    tmp.append(top);
                }
                stack.push(stack.pop() + tmp.toString());
            } else {
                stack.push(stack.pop() + c);
            }
        }
        return stack.peek().toString();
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(new Solution().decodeString(s));
    }
}
