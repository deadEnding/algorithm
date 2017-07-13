package leetcode.L257_BinaryTreePaths;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 11:20 PM 12/P10/16
 * @version: 1.0
 * @description:
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    private void binaryTreePaths(TreeNode root, List<String> result, List<Integer> path) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            StringBuffer sb = new StringBuffer();
            for (int v : path) {
                sb.append(v + "->");
            }
            sb.append(root.val);
            result.add(sb.toString());
            return;
        }

        path.add(root.val);
        binaryTreePaths(root.left, result, path);
        binaryTreePaths(root.right, result, path);
        path.remove(path.size() - 1);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        binaryTreePaths(root, result, new LinkedList<Integer>());
        return result;
    }
}
