package leetcode.L501_FindModeInBinarySearchTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 11:36 AM 2/5/17
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
    private void preorder(TreeNode root, HashMap<Integer, Integer> counter) {
        if (root != null) {
            counter.put(root.val, counter.containsKey(root.val) ? counter.get(root.val) + 1 : 1);
            preorder(root.left, counter);
            preorder(root.right, counter);
        }
    }

    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        preorder(root, counter);
        int max = 0;
        List<Integer> modes = new ArrayList<>();
        for (int key : counter.keySet()) {
            if (counter.get(key) > max) {
                max = counter.get(key);
                modes.clear();
                modes.add(key);
            } else if (counter.get(key) == max) {
                modes.add(key);
            }
        }

        int[] result = new int[modes.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = modes.get(i);
        }
        return result;
    }
}
