package leetcode.L332_ReconstructItinerary;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: deadend
 * @date: 8:21 PM 3/17/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private void dfs(String from, HashMap<String, PriorityQueue<String>> adj, LinkedList<String> path) {
        PriorityQueue<String> tos = adj.get(from);
        while (tos != null && !tos.isEmpty()) {
            String to = tos.poll();
            dfs(to, adj, path);
        }
        path.addFirst(from);
    }

    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> adj = new HashMap<>();
        for (String[] pair : tickets) {
            if (!adj.containsKey(pair[0])) {
                adj.put(pair[0], new PriorityQueue<>());
            }
            adj.get(pair[0]).offer(pair[1]);
        }

        LinkedList<String> path = new LinkedList<>();
        dfs("JFK", adj, path);
        return path;
    }
}
