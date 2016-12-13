package leetcode.L310_MinimumHeightTrees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 9:51 PM 12/13/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        LinkedList<Integer> result = new LinkedList<>();
        if (n == 0) {
            return result;
        }

        ArrayList<HashSet<Integer>> adj = new ArrayList<>();
        HashSet<Integer> nodes = new HashSet<>();
        for (int i = 0; i < n; i++) {
            nodes.add(i);
            adj.add(i, new HashSet<Integer>());
        }

        for (int[] pair : edges) {
            adj.get(pair[0]).add(pair[1]);
            adj.get(pair[1]).add(pair[0]);
        }

        while (nodes.size() > 2) {
            LinkedList<Integer> leaves = new LinkedList<>();
            for (int node : nodes) {
                if (adj.get(node).size() == 1) {
                    leaves.add(node);
                }
            }

            for (int leaf : leaves) {
                for (int next : adj.get(leaf)) {
                    adj.get(next).remove(leaf);
                }
                nodes.remove(leaf);
            }
        }

        for (int node : nodes) {
            result.add(node);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        System.out.println(new Solution().findMinHeightTrees(6, edges).toString());
    }
}


// 深搜求最长路径，超时
class DFSSolution {
    private ArrayList<Integer> maxPath;
    
    private void dfs(int ix, HashSet<Integer>[] adj, boolean[] visited, ArrayList<Integer> path) {
        path.add(ix);
        if (maxPath == null || maxPath.size() < path.size()) {
            maxPath = new ArrayList<>(path);
        }
        visited[ix] = true;
        for (int next : adj[ix]) {
            if (!visited[next]) {
                dfs(next, adj, visited, path);
            }
        }
        visited[ix] = false;
        path.remove(path.size() - 1);
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }

        HashSet<Integer>[] adj = new HashSet[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<>();
        }

        for (int[] pair : edges) {
            adj[pair[0]].add(pair[1]);
            adj[pair[1]].add(pair[0]);
        }

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            dfs(i, adj, visited, new ArrayList<Integer>());
        }

        result.add(maxPath.get(maxPath.size() / 2));
        if (maxPath.size() % 2 == 0) {
            result.add(maxPath.get(maxPath.size() / 2 - 1));
        }
        return result;
    }
}
