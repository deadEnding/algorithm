package leetcode.L095_UniqueBinarySearchTreesII;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 8:40 PM 12/2/16
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
    private List<TreeNode> result = new LinkedList<>();

    private List<TreeNode> generateTree(int i, int j) {
        List<TreeNode> trees = new LinkedList<>();
        if (i > j) {
            trees.add(null);
            return trees;
        }

        for (int k = i; k <= j; k++) {
            List<TreeNode> leftTrees = generateTree(i, k - 1);
            List<TreeNode> rightTrees = generateTree(k + 1, j);
            for (TreeNode l : leftTrees) {
                for (TreeNode r : rightTrees) {
                    TreeNode root = new TreeNode(k);
                    root.left = l;
                    root.right = r;
                    trees.add(root);
                }
            }
        }
        return trees;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new LinkedList<TreeNode>();
        }
        return generateTree(1, n);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateTrees(0).size());
    }
}
