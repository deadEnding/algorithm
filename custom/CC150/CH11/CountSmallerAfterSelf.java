package custom.CC150.CH11;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 9:03 AM 1/3/17
 * @version: 1.0
 * @description:
 */

public class CountSmallerAfterSelf {
    class Node {
        int val, dump;
        int leftCount;
        Node left, right;

        public Node(int val) {
            this.val = val;
            dump = 1;
        }
    }

    private Node insert(Node root, int val, int preCount, List<Integer> result) {
        if (root == null) {
            root = new Node(val);
            result.add(0, preCount);
        } else if (val == root.val) {
            root.dump++;
            result.add(0, preCount + root.leftCount);
        } else if (val < root.val) {
            root.leftCount++;
            root.left = insert(root.left, val, preCount, result);
        } else {
            root.right = insert(root.right, val, preCount + root.leftCount + root.dump, result);
        }
        return root;
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new LinkedList<>();
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(root, nums[i], 0, result);
        }
        return result;
    }
}
