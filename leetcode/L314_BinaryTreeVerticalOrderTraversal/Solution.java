package leetcode.again.L314_BinaryTreeVerticalOrderTraversal;

import java.util.*;

/**
 * @author: deadend
 * @date: 8:32 PM 3/14/17
 * @version: 1.0
 * @description:
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    class QueueNode {
        TreeNode node;
        int x;
        public QueueNode(TreeNode node, int x) {
            this.node = node;
            this.x = x;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        HashMap<Integer, List<Integer>> map = new LinkedHashMap<>();
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 0));
        while (!queue.isEmpty()) {
            QueueNode qn = queue.poll();
            if (!map.containsKey(qn.x)) {
                map.put(qn.x, new LinkedList<>());
            }

            map.get(qn.x).add(qn.node.val);
            if (qn.node.left != null) {
                queue.offer(new QueueNode(qn.node.left, qn.x - 1));
            }

            if (qn.node.right != null) {
                queue.offer(new QueueNode(qn.node.right, qn.x + 1));
            }
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.addAll(map.keySet());
        while (!heap.isEmpty()) {
            result.add(map.get(heap.poll()));
        }
        return result;
    }
}
