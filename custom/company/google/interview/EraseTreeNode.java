package custom.company.google.interview;

import common.tree.TreeNode;
import common.tree.TreeSerializer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class EraseTreeNode {

    private List<TreeNode> roots = new ArrayList<>();

    private TreeNode postorder(TreeNode root, HashSet<Integer> erased) {
        if (root == null) {
            return null;
        }

        root.left = postorder(root.left, erased);
        root.right = postorder(root.right, erased);
        if (erased.contains(root.val)) {
            if (root.left != null) {
                roots.add(root.left);
            }

            if (root.right != null) {
                roots.add(root.right);
            }

            return null;
        }

        return root;
    }

    public List<TreeNode> erase(TreeNode root, int[] nums) {
        HashSet<Integer> erased = new HashSet<>();
        for (int num : nums) {
            erased.add(num);
        }

        // 对 root 特殊处理，否则 root 不在最后的结果中
        TreeNode dummy = new TreeNode(-1);
        erased.add(-1);
        dummy.left = root;

        postorder(dummy, erased);
        return roots;
    }

    public static void main(String[] args) {
        String tree = "1,2,4,#,#,5,#,#,3,6,#,#,7,#,#";
        TreeNode root = TreeSerializer.deserialize(tree);
        List<TreeNode> roots = new EraseTreeNode().erase(root, new int[] {4, 3});
        for (TreeNode r : roots) {
            System.out.println(TreeSerializer.serialize(r));
        }
    }
}
