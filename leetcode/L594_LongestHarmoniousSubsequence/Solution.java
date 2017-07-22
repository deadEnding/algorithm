package leetcode.L594_LongestHarmoniousSubsequence;


import java.util.HashMap;

public class Solution {
    public int findLHS(int[] nums) {
        int max = 0;

        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) {
            int cnt = counter.getOrDefault(n, 0) + 1;
            counter.put(n, cnt);

            if (counter.containsKey(n - 1)) {
                max = Math.max(max, cnt + counter.get(n - 1));
            }

            if (counter.containsKey(n + 1)) {
                max = Math.max(max, cnt + counter.get(n + 1));
            }
        }

        return max;
    }
}
