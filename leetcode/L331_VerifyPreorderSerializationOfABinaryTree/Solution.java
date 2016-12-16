package leetcode.L331_VerifyPreorderSerializationOfABinaryTree;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 11:00 AM 12/16/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] vals = preorder.split(",");

        int degree = 1;
        for (String val : vals) {
            if (--degree < 0) {
                return false;
            }
            degree += val.equals("#") ? 0 : 2;
        }
        return degree == 0;
    }
}

class StackSolution {
    public boolean isValidSerialization(String preorder) {
        final String dummy = "#";
        String[] vals = preorder.split(",");
        LinkedList<String> stack = new LinkedList<>();

        for (String val : vals) {
            if (val.equals(dummy)) {
                while (!stack.isEmpty() && stack.peek().equals(dummy)) {
                    if (stack.size() < 2) {
                        return false;
                    }
                    stack.pop();
                    stack.pop();
                }
                stack.push(dummy);
            } else {
                stack.push(val);
            }
        }
        return stack.size() == 1 && stack.pop().equals(dummy);
    }

    public static void main(String[] args) {
        String preorder = "1,#,#,#,#";
        System.out.println(new Solution().isValidSerialization(preorder));
    }
}
