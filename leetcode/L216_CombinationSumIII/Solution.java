package leetcode.L216_CombinationSumIII;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 10:07 PM 11/22/16
 * @version: 1.0
 * @description:
 */


public class Solution {

    private List<List<Integer>> result =  new LinkedList<>();

    private void dfs(int k, int ix, int n, LinkedList<Integer> path) {
        if (k == 0) {
            if (n == 0) {
                result.add(new LinkedList<Integer>(path));
            }
            return;
        }

        for (int i = ix; i <= 9; i++) {
            path.addLast(i);
            dfs(k - 1, i + 1, n - i, path);
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, 1, n, new LinkedList<Integer>());
        return result;
    }


    public static void main(String[] args) {
        List<List<Integer>> result = new Solution().combinationSum3(3, 9);
        for (List<Integer> list: result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
