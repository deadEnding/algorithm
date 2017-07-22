package leetcode.L297_SerializeAndDeserializeBinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: deadend
 * @date: 5:09 PM 3/14/17
 * @version: 1.0
 * @description:
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


// 先序
public class Codec {

    private static final String NULL = "#";
    private static final String sep = ",";

    private void serialize(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append(builder.length() != 0 ? sep + NULL : NULL);
        } else {
            builder.append(builder.length() != 0 ? sep + root.val : root.val);
            serialize(root.left, builder);
            serialize(root.right, builder);
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        return builder.toString();
    }

    private TreeNode deserialize(Queue<String> queue) {
        String vs = queue.poll();
        if (vs.equals(NULL)) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.valueOf(vs));
            root.left = deserialize(queue);
            root.right = deserialize(queue);
            return root;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(sep)));
        return deserialize(queue);
    }
}
