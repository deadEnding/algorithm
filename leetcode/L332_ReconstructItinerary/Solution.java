package leetcode.L332_ReconstructItinerary;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: deadend
 * @date: 12:34 PM 12/16/16
 * @version: 1.0
 * @description:
 */

// 欧拉路径
public class Solution {
    private HashMap<String, PriorityQueue<String>> map = new HashMap<>();

    LinkedList<String> path = new LinkedList<>();

    // 直到无路可走，即为终点
    private void dfs(String from) {
        PriorityQueue<String> tos = map.get(from);
        while (tos != null && !tos.isEmpty()) {
            String s = tos.poll();
            dfs(s);
        }
        path.addFirst(from);
    }

    public List<String> findItinerary(String[][] tickets) {
        for (String[] pair : tickets) {
            if (!map.containsKey(pair[0])) {
                map.put(pair[0], new PriorityQueue<String>());
            }
            map.get(pair[0]).offer(pair[1]);
        }
        dfs("JFK");
        return path;
    }
}
