package leetcode.L399_EvaluateDivision;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 9:33 PM 12/20/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private double query(String from, String to, HashMap<String, HashMap<String, Double>> m) {
        if (!m.containsKey(from) || !m.containsKey(to)) {
            return -1.0;
        }

        if (from.equals(to)) {
            return 1.0;
        }

        double d;
        for (String fm : m.get(from).keySet()) {
            if (m.get(from).get(fm) < 0.000001) {
                continue;
            }

            double tmp = m.get(from).get(fm);
            m.get(from).put(fm, 0.0);
            if ((d = query(fm, to, m)) + 1.0 > 0.000001) {
                m.get(from).put(fm, tmp);
                return tmp * d;
            }
            m.get(from).put(fm, tmp);
        }
        return -1.0;
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, HashMap<String, Double>> m = new HashMap<>();

        for (int i = 0; i < equations.length; i++) {
            if (!m.containsKey(equations[i][0])) {
                m.put(equations[i][0], new HashMap<String, Double>());
            }
            m.get(equations[i][0]).put(equations[i][1], values[i]);

            if (!m.containsKey(equations[i][1])) {
                m.put(equations[i][1], new HashMap<String, Double>());
            }
            m.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
        }

        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = query(queries[i][0], queries[i][1], m);
        }
        return result;
    }

    public static void main(String[] args) {
        String[][] eq = {{"A", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"A", "c"}, {"b", "c"}, {"A", "e"}, {"A", "A"}, {"x", "x"}};
        double[] result = new Solution().calcEquation(eq, values, queries);
        for (double d : result) {
            System.out.println(d);
        }
    }
}
