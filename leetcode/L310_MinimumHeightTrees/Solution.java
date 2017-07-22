package leetcode.L310_MinimumHeightTrees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 9:09 AM 3/1/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashSet<Integer>[] adj = new HashSet[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<>();
        }

        int[] degree = new int[n];
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }

        int remain = n;
        while (remain > 2) {
            HashSet<Integer> leaves = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (degree[i] == 1) {
                    leaves.add(i);
                }
            }

            for (int i : leaves) {
                for (int neig : adj[i]) {
                    degree[neig]--;
                    adj[neig].remove(i);
                }
                degree[i] = -1;
            }
            remain -= leaves.size();
        }

        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] >= 0) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        System.out.println(new Solution().findMinHeightTrees(n, edges));
    }
}
