package leetcode.L069_SqrtX;

/**
 * @author: deadend
 * @date: 12:38 PM 3/3/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        while (l < r) {
            int m = l + (r - l) / 2 + 1;
            long sq = (long)m * m;
            if (sq == x)
                return m;
            else if (sq > x)
                r = m - 1;
            else
                l = m;
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(2));
    }
}
