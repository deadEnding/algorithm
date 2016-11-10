package leetcode.L039_CombinationSum;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 3:22 PM 11/10/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0, target, new LinkedList<Integer>());
        print();
        return result;
    }

    private void dfs(int[] candidates, int ix, int target, LinkedList<Integer> path) {
        if (target <= 0) {
            if (target == 0) {
                result.add(new LinkedList<Integer>(path));
            }
            return;
        }

        for (int i = ix; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            dfs(candidates, i, target - candidates[i], path);
            path.removeLast();
        }
    }

    public void print() {
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        new Solution().combinationSum(candidates, 1);
    }
}
