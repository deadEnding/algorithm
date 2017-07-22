package leetcode.L071_SimplifyPath;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: deadend
 * @date: 3:12 PM 3/2/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String simplifyPath(String path) {
        String[] ps = path.split("/", -1);
        LinkedList<String> stack = new LinkedList<>();
        for (String p : ps) {
            if (p.equals("") || p.equals(".")) {
                continue;
            }

            if (p.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(p);
            }
        }

        StringBuffer buffer = new StringBuffer();
        while (!stack.isEmpty()) {
            buffer.insert(0, stack.pop() + (buffer.length() > 0 ? "/" : ""));
        }
        if (path.startsWith("/")) {
            buffer.insert(0, "/");
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("").length());
    }
}

