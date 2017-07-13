package leetcode.again.L020_ValidParentheses;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 9:37 AM 3/17/17
 * @version: 1.0
 * @description:
 */


public class Solution {

    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (!(!stack.isEmpty() && stack.pop() == map.get(c))) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

class FirstSolution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char sc = stack.peek();
                if (c == ')' && sc != '(' || c == ']' && sc != '[' || c == '}' && sc != '{') {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
