package leetcode.L437_PathSumIII;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 10:25 AM 12/4/16
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
    private int preOrder(TreeNode root, int pathSum, int target, HashMap<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }

        pathSum += root.val;
        int count = map.containsKey(pathSum - target) ? map.get(pathSum - target) : 0;    // pathSum - pathSumUp = target
        map.put(pathSum, map.containsKey(pathSum) ? map.get(pathSum) + 1 : 1);

        count += preOrder(root.left, pathSum, target, map) + preOrder(root.right, pathSum, target, map);
        map.put(pathSum, map.get(pathSum) - 1);   // 避免回溯时干扰上层节点的判断
        return count;
    }

    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        return preOrder(root, 0, sum, map);
    }
}

// Best: 平衡树 O(nlogn)
// Worst: 链树 O(n^2)
class BasicSolution {
    private int preOrder(TreeNode root, int sum) {
        int count = 0;
        if (root == null) {
            return 0;
        }

        sum -= root.val;
        if (sum == 0) {
            count++;
        }

        count += preOrder(root.left, sum) + preOrder(root.right, sum);
        return count;
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return preOrder(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
}
