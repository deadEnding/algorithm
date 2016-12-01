package leetcode.L069_Sqrt_X;

/**
 * @author: deadend
 * @date: 2:36 PM 12/1/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int mySqrt(int x) {
        long l = 0, r = x;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                return (int) mid;
            } else if ((mid + 1) * (mid + 1) <= x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(2147395599));
    }
}
