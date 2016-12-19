package leetcode.L390_EliminationGame;

/**
 * @author: deadend
 * @date: 2:47 PM 12/19/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (1 + n / 2 - lastRemaining(n / 2));
    }
}
