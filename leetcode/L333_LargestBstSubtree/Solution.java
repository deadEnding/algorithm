package leetcode.L333_LargestBstSubtree;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    private int maxNodeNum = 0;

    private int min(TreeNode root) {
        int min = Integer.MAX_VALUE;
        while (root != null) {
            min = Math.min(min, root.val);
            root = root.left;
        }

        return min;
    }

    private int max(TreeNode root) {
        int max = Integer.MIN_VALUE;
        while (root != null) {
            max = Math.max(max, root.val);
            root = root.right;
        }

        return max;
    }

    private int postorder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = postorder(root.left);
        int right = postorder(root.right);
        if (left == -1 || right == -1) {
            return -1;
        }

        long max = root.left == null ? Integer.MIN_VALUE - 1L : max(root.left);
        long min = root.right == null ? Integer.MAX_VALUE + 1L : min(root.right);
        if (max < root.val && root.val < min) {
            maxNodeNum = Math.max(maxNodeNum, left + right + 1);
            return left + right + 1;
        } else {
            return  -1;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        postorder(root);
        return maxNodeNum;
    }

    public static void main(String[] args) {
        int n = 4;
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(i);
        }

        nodes[2].left = nodes[0];
        nodes[2].right = nodes[3];
        nodes[0].right = nodes[1];
        nodes[3].val = 0;
        System.out.println(new Solution().largestBSTSubtree(nodes[2]));
    }
}
