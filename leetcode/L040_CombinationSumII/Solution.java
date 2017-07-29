package leetcode.L040_CombinationSumII;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 3:38 PM 11/P10/16
 * @version: 1.0
 * @description:
 */


public class Solution {

    private List<List<Integer>> result = new LinkedList<>();

    private void dfs(int ix, int[] cdd, int remain, LinkedList<Integer> path) {
        if (remain <= 0) {
            if (remain == 0)
                result.add(new LinkedList<>(path));
            return;
        }

        HashSet<Integer> used = new HashSet<>();
        for (int i = ix; i < cdd.length; i++) {
            if (used.contains(cdd[i])) {
                continue;
            }

            path.addLast(cdd[i]);
            dfs(i + 1, cdd, remain - cdd[i], path);
            path.removeLast();

            used.add(cdd[i]);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, candidates, target, new LinkedList<>());
        return result;
    }
}

class OldSolution {
    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new LinkedList<Integer>());
        return result;
    }

    private void dfs(int[] candidates, int ix, int target, LinkedList<Integer> path) {
        if (target <= 0) {
            if (target == 0) {
                result.add(new LinkedList<>(path));
            }
            return;
        }

        for (int i = ix; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], path);
            path.removeLast();

            while (i + 1 < candidates.length && candidates[i+1] == candidates[i]) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] candicates = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> result = new Solution().combinationSum2(candicates, 8);
        for (List<Integer> list: result) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}