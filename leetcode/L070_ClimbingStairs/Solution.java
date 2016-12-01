package leetcode.L070_ClimbingStairs;

/**
 * @author: deadend
 * @date: 2:59 PM 12/1/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int climbStairs(int n) {
        int prev = 0, curr = 1;
        while (n-- > 0) {
            int tmp = curr;
            curr += prev;
            prev = tmp;
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(4));
    }
}
