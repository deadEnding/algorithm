package leetcode.L508_MostFrequentSubtreeSum;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author: deadend
 * @date: 7:34 PM 28/03/2017
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    private int helper(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }

        int sum = helper(root.left, map) + helper(root.right, map);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        int max = 0;
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int key : map.keySet()) {
            int val = map.get(key);
            if (val >= max) {
                if (val > max) {
                    tmp.clear();
                    max = val;
                }
                tmp.add(key);
            }
        }

        int[] result = new int[tmp.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = tmp.get(i);
        }
        return result;
    }
}
