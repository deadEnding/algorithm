package leetcode.L388_LongestAbsoluteFilePath;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 8:38 PM 3/9/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int lengthLongestPath(String input) {
        String[] slugs = input.split("\\n");
        LinkedList<String> stack = new LinkedList<>();

        int len = 0;
        int max = 0;
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

    public static void main(String[] args) {
        String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(new Solution().lengthLongestPath(s));
    }
}
