package leetcode.L464_CanIWin;

/**
 * @author: deadend
 * @date: 2:03 PM 11/27/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        return helper1(desiredTotal, new boolean[maxChoosableInteger+1]);
    }

    private boolean helper1(int total, boolean[] used) {
        if (total <= 0) {
            return false;
        }

        for (int i = 1; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                if (helper2(total - i, used)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    private boolean helper2(int total, boolean[] used) {
        if (total <= 0) {
            return true;
        }

        for (int i = 1; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                if (!helper1(total - i, used)) {
                    return false;
                }
                used[i] = false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canIWin(10, 11));
    }
}
