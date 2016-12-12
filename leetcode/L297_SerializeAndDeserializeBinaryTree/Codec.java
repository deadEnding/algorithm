package leetcode.L297_SerializeAndDeserializeBinaryTree;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 10:28 PM 12/12/16
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

    // Encodes a tree to a single string.
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n21 = new TreeNode(4);
        TreeNode n22 = new TreeNode(5);

        root.left = n1;
        root.right = n2;
        n2.left = n21;
        n2.right = n22;
        String data = new Codec().serialize(root);
        TreeNode r = new Codec().deserialize(data);
        System.out.println(r.val);
        System.out.println(r.left.val);
        System.out.println(r.right.val);
        System.out.println(r.right.left.val);
        System.out.println(r.right.right.val);
    }
}
