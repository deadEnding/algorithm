package leetcode.L095_UniqueBinarySearchTreesII;


import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    private List<TreeNode> generateTrees(int s, int e) {
        List<TreeNode> trees = new LinkedList<>();
        if (s > e) {
            trees.add(null);
        } else {
            for (int i = s; i <= e; i++) {
                List<TreeNode> lefts = generateTrees(s, i - 1);
                List<TreeNode> rights = generateTrees(i + 1, e);
                for (TreeNode l : lefts) {
                    for (TreeNode r : rights) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        trees.add(root);
                    }
                }
            }
        }
        return trees;
    }


    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new LinkedList<>();
        return generateTrees(1, n);
    }
}
