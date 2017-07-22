package leetcode.L554_BrickWall;

import java.util.HashMap;
import java.util.List;

public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        final int n = wall.size();

        int max = 0;
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (List<Integer> row : wall) {
            int ix = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                ix += row.get(i);
                counter.put(ix, counter.getOrDefault(ix, 0) + 1);
                max = Math.max(max, counter.get(ix));
            }
        }

        return n - max;
    }
}

