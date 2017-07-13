package leetcode.again.L331_VerifyPreorderSerializationOfABinaryTree;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: P10:58 AM 3/1/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean isValidSerialization(String preorder) {
        final String nval = "#";
        String[] vals = preorder.split(",");
        LinkedList<String> stack = new LinkedList<>();

        for (String v : vals) {
            if (v.equals(nval)) {
                while (!stack.isEmpty() && stack.peek().equals(nval)) {
                    if (stack.size() < 2) {
                        return false;
                    }
                    stack.pop();
                    stack.pop();
                }
            }
            stack.push(v);
        }

        return stack.size() == 1 && stack.peek().equals(nval);
    }

    public static void main(String[] args) {
        String s = "1,#";
        System.out.println(new Solution().isValidSerialization(s));
    }
}
