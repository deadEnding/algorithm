package leetcode.L501_FindModeInBinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 3:12 PM 28/03/2017
 */


class TreeNode {
    int val;TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        ArrayList<Integer> result = new ArrayList<>();
        int max = 0, cur = 0;

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root, last = null;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if (last == null || last.val == p.val) {
                    cur++;
                } else {
                    if (cur > max) {
                        max = cur;
                        result.clear();
                        result.add(last.val);
                    } else if (cur == max) {
                        result.add(last.val);
                    }
                    cur = 1;
                }
                last = p;
                p = p.right;
            }
        }


        if (cur > max) {
            result.clear();
            result.add(last.val);
        } else if (cur == max) {
            result.add(last.val);
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}

class OldSolution {
    private ArrayList<Integer> values = new ArrayList<>();
    private int max = 0;
    private int cur = 0;
    private TreeNode last;

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (last != null && last.val != root.val) {
            cur = 0;
        }
        cur++;
        if (cur >= max) {
            if (cur > max) {
                values.clear();
                max = cur;
            }
            values.add(root.val);
        }
        last = root;
        inorder(root.right);
    }

    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] result = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            result[i] = values.get(i);
        }
        return result;
    }
}
