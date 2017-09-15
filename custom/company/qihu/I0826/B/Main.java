package custom.company.qihu.I0826.B;

import java.util.Scanner;

public class Main {

    static class TreeNode {
        int val, dup, leftCount;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.dup = 1;
        }
    }

    static class BST {
        private TreeNode root;

        private TreeNode insert(TreeNode root, int val) {
            if (root == null) {
                root = new TreeNode(val);
            } else if (val == root.val) {
                root.dup++;
            } else if (val < root.val) {
                root.leftCount++;
                root.left = insert(root.left, val);
            } else {
                root.right = insert(root.right, val);
            }
            return root;
        }

        public void insert(int val) {
            root = insert(root, val);
        }

        private int search(TreeNode root, int val) {
            if (root == null) {
                return 0;
            } else if (val == root.val) {
                return root.leftCount + root.dup;
            } else if (val < root.val) {
                return search(root.left, val);
            } else {
                return root.leftCount + root.dup + search(root.right, val);
            }
        }

        public int search(int val) {
            return search(root, val);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BST bst = new BST();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int cnt = i - bst.search(x);
            System.out.print(i == 0 ? cnt : (" " + cnt));
            bst.insert(x);
        }
    }
}
