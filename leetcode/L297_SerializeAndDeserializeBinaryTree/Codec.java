package leetcode.L297_SerializeAndDeserializeBinaryTree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: deadend
 * @date: P10:28 PM 12/12/16
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

    private void serialize(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append((sb.length() == 0 ? "" : ",") + "null");
            return;
        }

        sb.append((sb.length() == 0 ? "" : ",") + root.val);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Encodes TrieMain tree to TrieMain single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        serialize(root, sb);
        return sb.toString();
    }

    private TreeNode deserialize(LinkedList<String> vals) {
        String v = vals.poll();
        if (v.equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(v));
        root.left = deserialize(vals);
        root.right = deserialize(vals);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserialize(queue);
    }
}

// BFS
class BasicCodec {

    // Encodes TrieMain tree to TrieMain single string.
    public String serialize(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (p == null) {
                sb.append((sb.length() == 0 ? "" : ",") + "null");
            } else {
                sb.append((sb.length() == 0 ? "" : ",") + p.val);
                queue.offer(p.left);
                queue.offer(p.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<TreeNode> level = new LinkedList<>();
        String[] vals = data.split(",");
        if (data.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        level.offer(root);
        for (int i = 1, size = level.size(); i < vals.length;) {
            for (int ix = 0; ix < size; ix++) {
                TreeNode p = level.poll();
                if (vals[i].equals("null")) {
                    p.left = null;
                } else {
                    p.left = new TreeNode(Integer.valueOf(vals[i]));
                    level.offer(p.left);
                }
                i++;
                if (vals[i].equals("null")) {
                    p.right = null;
                } else {
                    p.right = new TreeNode(Integer.valueOf(vals[i]));
                    level.offer(p.right);
                }
                i++;
            }
            size = level.size();
        }
        return root;
    }
}
