package leetcode.L437_PathSumIII;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 7:22 PM 3/1/17
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

    private int preorder(TreeNode root, int pathSum, int sum, HashMap<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }

        pathSum += root.val;
        int count = map.getOrDefault(pathSum - sum, 0);
        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);
        count += preorder(root.left, pathSum, sum, map);
        count += preorder(root.right, pathSum, sum, map);
        map.put(pathSum, map.getOrDefault(pathSum, 0) - 1);
        return count;
    }

    public int pathSum(TreeNode root, int sum) {
        return preorder(root, 0, sum, new HashMap<Integer, Integer>(){{ put(0, 1); }});
    }
}

