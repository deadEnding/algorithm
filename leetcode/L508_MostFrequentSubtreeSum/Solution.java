package leetcode.L508_MostFrequentSubtreeSum;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author: deadend
 * @date: 2:28 PM 2/11/17
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
    private int helper(TreeNode root, HashMap<Integer, Integer> count) {
        if (root == null) {
            return 0;
        }

        int sum = root.val + helper(root.left, count) + helper(root.right, count);
        count.put(sum, count.getOrDefault(sum, 0) + 1);
        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> count = new HashMap<>();
        helper(root, count);

        int c = 0;
        ArrayList<Integer> highest = new ArrayList<>();
        for (int key : count.keySet()) {
            int val = count.get(key);
            if (val >= c) {
                if (val > c) {
                    highest.clear();
                    c = val;
                }
                highest.add(key);
            }
        }

        int[] result = new int[highest.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = highest.get(i);
        }
        return result;
    }
}
