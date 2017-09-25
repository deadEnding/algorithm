package leetcode.L399_EvaluateDivision;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: deadend
 * @date: 2:15 PM 3/14/17
 * @version: 1.0
 * @description:
 */


class Solution {

    private Double dfs(String start, String end, HashMap<String, HashMap<String, Double>> adj, HashSet<String> visited) {
        if (start.equals(end)) {
            return 1.0;
        }

        if (visited.contains(start)) {
            return null;
        }

        visited.add(start);
        HashMap<String, Double> neigs = adj.get(start);
        for (String next : neigs.keySet()) {
            Double sub = dfs(next, end, adj, visited);
            if (sub != null) {
                visited.remove(start);
                return neigs.get(next) * sub;
            }
        }

        visited.remove(start);
        return null;
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] e = equations[i];
            if (!map.containsKey(e[0])) {
                map.put(e[0], new HashMap<>());
            }
            map.get(e[0]).put(e[1], values[i]);

            if (!map.containsKey(e[1])) {
                map.put(e[1], new HashMap<>());
            }
            map.get(e[1]).put(e[0], 1.0 / values[i]);
        }

        double[] result = new double[queries.length];
        HashSet<String> visited = new HashSet<>();
        for (int i = 0; i < queries.length; i++) {
            String[] q = queries[i];
            if (!map.containsKey(q[0]) || !map.containsKey(q[1])) {
                result[i] = -1.0;
            } else {
                Double r = dfs(q[0], q[1], map, visited);
                result[i] = r == null ? -1.0 : r;
            }
        }

        return result;
    }
}


class BasicSolution {
    private Double dfs(String curr, String target, HashMap<String, HashMap<String, Double>> adj, HashSet<String> visited) {
        if (curr.equals(target)) {
            return 1.0;
        }

        if (visited.contains(curr)) {
            return null;
        }

        visited.add(curr);
        HashMap<String, Double> neighs = adj.get(curr);
        Double sub;
        for (String ng : neighs.keySet()) {
            if ((sub = dfs(ng, target, adj, visited)) != null) {
                visited.remove(curr);
                return sub * neighs.get(ng);
            }
        }

        visited.remove(curr);
        return null;
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, HashMap<String, Double>> adj = new HashMap<>();

        for (int i = 0; i < equations.length; i++) {
            String[] e = equations[i];
            if (!adj.containsKey(e[0])) {
                adj.put(e[0], new HashMap<>());
            }

            if (!adj.containsKey(e[1])) {
                adj.put(e[1], new HashMap<>());
            }
            adj.get(e[0]).put(e[1], values[i]);
            adj.get(e[1]).put(e[0], 1 / values[i]);
        }

        double[] result = new double[queries.length];
        HashSet<String> visited = new HashSet<>();
        for (int i = 0; i < queries.length; i++) {
            if (!adj.containsKey(queries[i][0]) || !adj.containsKey(queries[i][1])) {
                result[i] = -1.0;
            } else {
                Double r = dfs(queries[i][0], queries[i][1], adj, visited);
                result[i] = r == null ? -1.0 : r;
            }
        }
        return result;
    }
}
