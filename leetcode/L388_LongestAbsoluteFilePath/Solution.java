package leetcode.L388_LongestAbsoluteFilePath;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 2:10 PM 12/19/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int lengthLongestPath(String input) {
        String[] slugs = input.split("\\n");
        LinkedList<String> stack = new LinkedList<>();

        int max = 0;
        int len = 0;
        for (String s : slugs) {
            int start = s.lastIndexOf('\t') + 1;
            while (!stack.isEmpty() && start < stack.size()) {
                len -= stack.pop().length();
            }
            stack.push(s.substring(start));
            len += s.length() - start;
            if (s.contains(".")) {
                max = Math.max(max, len + stack.size() - 1);
            }
        }
        return max;
    }
}