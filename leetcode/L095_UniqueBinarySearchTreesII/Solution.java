package leetcode.L095_UniqueBinarySearchTreesII;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    private List<TreeNode> ONLY_NULL = new ArrayList<TreeNode>() {{ add(null); }};

    private List<TreeNode> generateTrees(int s, int e) {
        if (s > e) {
            return ONLY_NULL;
        }

        List<TreeNode> result = new ArrayList<>();
        for (int i = s; i <= e; i++) {
            List<TreeNode> lefts = generateTrees(s, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, e);
            for (TreeNode l : lefts) {
                for (TreeNode r : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }

        return result;
    }

    public List<TreeNode> generateTrees(int n) {
        return n == 0 ? new ArrayList<>() : generateTrees(1, n);
    }
}


class OldSolution {
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
