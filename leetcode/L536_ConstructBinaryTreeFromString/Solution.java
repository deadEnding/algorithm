package leetcode.L536_ConstructBinaryTreeFromString;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 8:09 PM 01/04/2017
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode str2tree(String s) {
        if (s.equals("")) {
            return null;
        }

        final int n = s.length();
        LinkedList<Integer> childStack = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        int sign = 1;
        int num = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '-') {
                sign = -1;
            } else if (Character.isDigit(c)) {
                num = c - '0';
                while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(++i) - '0';
                }
                num *= sign;
                stack.push(new TreeNode(num));
                childStack.push(0);
                sign = 1;
            } else if (c == ')') {
                childStack.pop();
                TreeNode p = stack.pop();
                if (childStack.peek() == 0) {
                    stack.peek().left = p;
                    childStack.push(childStack.pop() + 1);
                } else {
                    stack.peek().right = p;
                }
            }
        }
        return stack.peek();
    }

    private void preorder(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        String s = "4(2(3)(1))(6(5))";
        TreeNode root = new Solution().str2tree(s);
        new Solution().preorder(root);
    }
}
