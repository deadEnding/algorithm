package leetcode.L449_SerializeAndDeserializeBst;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 3:50 PM 2/18/17
 * @version: 1.0
 * @description:
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Codec {

    private static final String dummy = "#";

    private void serialize(TreeNode root, StringBuffer buffer) {
        if (root == null) {
            buffer.append((buffer.length() == 0 ? "" : ",") + dummy);
            return;
        }

        buffer.append((buffer.length() == 0 ? "" : ",") + root.val);
        serialize(root.left, buffer);
        serialize(root.right, buffer);
    }

    public String serialize(TreeNode root) {
        StringBuffer buffer = new StringBuffer();
        serialize(root, buffer);
        return buffer.toString();
    }

    private TreeNode deserialize(LinkedList<String> queue) {
        String val = queue.poll();
        if (val.equals(dummy)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }

    public TreeNode deserialize(String data) {
        LinkedList<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserialize(queue);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        Codec codec = new Codec();
        String s = codec.serialize(root);
        System.out.println(s);
        TreeNode n = codec.deserialize(s);
        System.out.println(n.val);

    }
}
