package leetcode.L077_Combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 5:05 PM 12/1/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    private void dfs(int ix, int n, int k, ArrayList<Integer> path) {
        if (ix == n + 1) {
            if (path.size() == k) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        path.add(ix);
        dfs(ix + 1, n, k, path);
        path.remove(path.size() - 1);

        dfs(ix + 1, n, k, path);
    }

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k, new ArrayList<>());
        return result;
    }
}


class OldSolution {
    private List<List<Integer>> result = new LinkedList<>();

    private void combine(int ix, int n, int k, ArrayList<Integer> path) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = ix; i <= n; i++) {
            path.add(i);
            combine(i + 1, n, k, path);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        combine(1, n, k, new ArrayList<Integer>(k));
        return result;
    }
}
