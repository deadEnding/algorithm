package custom.CC150.CH4;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 1:58 PM 12/28/16
 * @version: 1.0
 * @description:
 */


public class PathSum {
    private int pathSum(TreeNode root, int currSum, int sum, HashMap<Integer, Integer> mem) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;
        int count = mem.containsKey(currSum - sum) ? mem.get(currSum - sum) : 0;
        mem.put(currSum, mem.containsKey(currSum) ? mem.get(currSum) + 1 : 1);
        count += pathSum(root.left, currSum, sum, mem) + pathSum(root.right, currSum, sum, mem);
        mem.put(currSum, mem.get(currSum) - 1);
        return count;
    }

    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> mem = new HashMap<>();
        mem.put(0, 1);
        return pathSum(root, 0, sum, mem);
    }
}
