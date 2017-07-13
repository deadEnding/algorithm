package leetcode.again.L539_MinimumTimeDifference;


import java.util.List;

public class Solution {
    private int convert(String tp) {
        String[] hm = tp.split(":");
        return Integer.valueOf(hm[0]) * 60 + Integer.valueOf(hm[1]);
    }

    public int findMinDifference(List<String> timePoints) {
        final int n = 24 * 60;
        boolean[] exist = new boolean[n];

        for (String tp : timePoints) {
            int ix = convert(tp);
            if (exist[ix]) {
                return 0;
            }
            exist[ix] = true;
        }

        int min = Integer.MAX_VALUE;
        int first = -1, last = -1;
        for (int i = 0; i < n; i++) {
            if (exist[i]) {
                if (last != -1) {
                    min = Math.min(min, i - last);
                } else {
                    first = i;
                }
                last = i;
            }
        }

        min = Math.min(min, n - (last - first));
        return min;
    }
}
