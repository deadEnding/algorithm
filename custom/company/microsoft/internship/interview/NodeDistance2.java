package custom.company.microsoft.internship.interview;

import java.util.ArrayList;

class TreeNode {
    int val;
    ArrayList<TreeNode> children = new ArrayList<>();
    public TreeNode(int val) {
        this.val = val;
    }
}

public class NodeDistance2 {

    private void print(ArrayList<TreeNode> nodes) {
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                System.out.println(nodes.get(i).val + " " + nodes.get(j).val);
            }
        }
    }

    private void preorder(TreeNode root, TreeNode parent, TreeNode pparent) {
        if (root == null) {
            return;
        }

        print(root.children);
        if (pparent != null) {
            System.out.println(root.val + " " + pparent.val);
        }

        for (TreeNode c : root.children) {
            preorder(c, root, parent);
        }
    }

    public void solve(TreeNode root) {
        preorder(root, null, null);
    }
}
