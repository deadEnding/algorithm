package leetcode.L071_SimplifyPath;

import java.util.LinkedList;
import java.util.regex.Pattern;

/**
 * @author: deadend
 * @date: 3:07 PM 12/1/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();

        String[] slugs = path.split("/");
        for (int i = slugs.length - 1; i >= 0; i--) {
            if (slugs[i].equals("") || slugs[i].equals(".")) {
                continue;
            }

            if (!slugs[i].equals("..") && !stack.isEmpty() && stack.peek().equals("..")) {
                stack.pop();
            } else {
                stack.push(slugs[i]);
            }
        }

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            String slug = stack.pop();
            if (!slug.equals("..")) {
                sb.append("/" + slug);
            }
        }

        return sb.length() == 0 ? "/" : path.startsWith("/") ? sb.toString() : sb.substring(1).toString();
    }

    public static void main(String[] args) {
        String path = "//";
        System.out.println(new Solution().simplifyPath(path));
    }
}
