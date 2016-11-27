package leetcode.L020_ValidParentheses;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 5:40 PM 11/27/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        stack.push('#');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if ((c == ')' && stack.peek() == '(') || (c == ']' && stack.peek() == '[') 
                    || (c == '}' && stack.peek() == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 1;
    }
}
