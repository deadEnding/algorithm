package leetcode.L374_GuessNumberHigherOrLower;

/**
 * @author: deadend
 * @date: 10:50 PM 12/16/16
 * @version: 1.0
 * @description:
 */

class GuessGame {
    public int guess(int num) {
        return 1;
    }
}


public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int tip = guess(m);
            if (tip == 0) {
                return m;
            } else if (tip == -1) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
