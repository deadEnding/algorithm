package custom.CC150.CH11;

/**
 * @author: deadend
 * @date: P10:11 AM 1/3/17
 * @version: 1.0
 * @description:
 */


public class CountSmaller {

    class Node {
        int val;
        int leftCount;
        Node left, right;
        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    private Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
        } else if (val < root.val) {
            root.leftCount++;
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    private int getSmallerCount(Node root, int val, int preCount) {
        if (root == null) {
            return preCount;
        } else if (val == root.val) {
            return preCount + root.leftCount;
        } else if (val < root.val) {
            return getSmallerCount(root.left, val, preCount);
        } else {
            return getSmallerCount(root.right, val, preCount + root.leftCount + 1);
        }
    }

    public void track(int num) {
        root = insert(root, num);
    }

    public int getRankOfNumber(int num) {
        return getSmallerCount(root, num, 0);
    }
}
