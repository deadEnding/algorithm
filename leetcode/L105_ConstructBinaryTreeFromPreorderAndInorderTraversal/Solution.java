package leetcode.L105_ConstructBinaryTreeFromPreorderAndInorderTraversal;

/**
 * @author: deadend
 * @date: 8:28 PM 12/3/16
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
    private TreeNode build(int[] preorder, int i1, int[] inorder, int i2, int len) {
        if (len == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[i1]);
        int pos = 0;
        for (int i = i2; i < i2 + len; i++) {
            if (inorder[i] == preorder[i1]) {
                pos = i;
                break;
            }
        }
        root.left = build(preorder, i1 + 1, inorder, i2, pos - i2);
        root.right = build(preorder, i1 + 1 + pos - i2, inorder, pos + 1, len - (pos - i2 + 1));
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, inorder, 0, preorder.length);
    }
}