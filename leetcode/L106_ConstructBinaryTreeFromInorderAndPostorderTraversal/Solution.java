package leetcode.again.L106_ConstructBinaryTreeFromInorderAndPostorderTraversal;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Solution {

    private int findIndex(int[] order, int s, int e, int target) {
        for (int i = s; i <= e; i++) {
            if (target == order[i])
                return i;
        }
        return -1;
    }

    private TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if (is > ie) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[pe]);
        int im = findIndex(inorder, is, ie, postorder[pe]);
        int lcount = im - is;
        root.left = buildTree(inorder, is, im - 1, postorder, ps, ps + lcount - 1);
        root.right = buildTree(inorder, im + 1, ie, postorder, ps + lcount, pe - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        final int n = inorder.length;
        return buildTree(inorder, 0, n - 1, postorder, 0, n - 1);
    }
}
