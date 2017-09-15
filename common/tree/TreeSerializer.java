package common.tree;

import java.util.Arrays;
import java.util.LinkedList;

public class TreeSerializer {

    private static final String NULL = "#";

    private static void serialize(TreeNode root, StringBuffer buffer) {
        if (root == null) {
            buffer.append((buffer.length() == 0 ? "" : ",") + NULL);
            return;
        }

        buffer.append((buffer.length() == 0 ? "" : ",") + root.val);
        serialize(root.left, buffer);
        serialize(root.right, buffer);
    }

    public static String serialize(TreeNode root) {
        StringBuffer buffer = new StringBuffer();
        serialize(root, buffer);
        return buffer.toString();
    }

    private static TreeNode deserialize(LinkedList<String> queue) {
        String val = queue.poll();
        if (val.equals(NULL)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }

    public static TreeNode deserialize(String data) {
        LinkedList<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserialize(queue);
    }
}
