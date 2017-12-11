package custom.templates.finalpractice;

/**
 * Created by deadend on 25/10/2017.
 */
public class BST {

    class TreeNode {
        int val, dup, leftCount;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.dup = 1;
        }
    }

    private TreeNode root;

    public void insert(int val) {
        root = insert(root, val);
    }

    private TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        } else if (val < root.val) {
            root.leftCount++;
            root.left = insert(root.left, val);
        } else if (val == root.val) {
            root.dup++;
        } else {  // >
            root.right = insert(root.right, val);
        }
        return root;
    }

    public int search(int val) {
        return search(root, val);
    }

    private int search(TreeNode root, int val) {
        if (root == null) {
            return 0;
        } else if (val < root.val) {
            return search(root.left, val);
        } else if (val == root.val) {
            return root.leftCount + root.dup;
        } else {
            return root.leftCount + root.dup + search(root.right, val);
        }
    }
}
