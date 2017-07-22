package leetcode.L598_RangeAdditionII;


public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if (m == 0 || n == 0 || ops == null) {
            return 0;
        }

        int minx = m, miny = n;
        for (int[] op : ops) {
            minx = Math.min(minx, op[0]);
            miny = Math.min(miny, op[1]);
        }

        return minx * miny;
    }
}
