package leetcode.L099_RecoverBinarySearchTree;

import java.util.ArrayList;

/**
 * @author: deadend
 * @date: 2:27 PM 12/3/16
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
    private void inorder(TreeNode root, ArrayList<TreeNode> nodes) {
        if (root == null) {
            return;
        }

        inorder(root.left, nodes);
        nodes.add(root);
        inorder(root.right, nodes);
    }

    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> nodes = new ArrayList<>();
        inorder(root, nodes);
        ArrayList<TreeNode> wrong = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            long prev = i - 1 >= 0 ? nodes.get(i - 1).val : Integer.MIN_VALUE - 1L;
            long next = i + 1 < nodes.size() ? nodes.get(i + 1).val : Integer.MAX_VALUE + 1L;
            if (!(prev < nodes.get(i).val && nodes.get(i).val < next)) {
                wrong.add(nodes.get(i));
            }
        }

        int tmp =  wrong.get(0).val;
        wrong.get(0).val = wrong.get(wrong.size() - 1).val;
        wrong.get(wrong.size() - 1).val = tmp;
    }
}

class RecusiveSolution {
    private TreeNode first  = null;   // 记录第一个不符合大小规则的节点
    private TreeNode second = null;   // 记录最后一个不符合大小规则的节点
    private TreeNode last   = null;   // 记录上一个被访问的节点

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (last != null) {   // 非第一个被访问的元素
            if (first == null && root.val < last.val) {
                first = last;
            }
            if (first != null && root.val < last.val) {   // 不能是else if，否则当被交换的两个节点大小相邻时不能记录下后一节点
                second = root;
            }
        }
        last = root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}
