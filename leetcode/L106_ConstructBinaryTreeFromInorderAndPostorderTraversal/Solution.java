package leetcode.L106_ConstructBinaryTreeFromInorderAndPostorderTraversal;

/**
 * @author: deadend
 * @date: 8:49 PM 12/3/16
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
    private int findPosition(int[] inorder, int i, int j, int target) {
        for (int k = i; k < j; k++) {
            if (inorder[k] == target) {
                return k;
            }
        }
        return -1;
    }

    private TreeNode build(int[] inorder, int ini, int inj, int[] postorder, int posti, int postj) {
        if (ini == inj) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postj - 1]);
        int inRootPos = findPosition(inorder, ini, inj, postorder[postj - 1]);
        int leftSize = inRootPos - ini;

        root.left = build(inorder, ini, inRootPos, postorder, posti, posti + leftSize);
        root.right = build(inorder, inRootPos + 1, inj, postorder, posti + leftSize, postj - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
}
