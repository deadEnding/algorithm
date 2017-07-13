package leetcode.again.L319_BulbSwitcher;

/**
 * @author: deadend
 * @date: 9:51 AM 3/1/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int bulbSwitch(int n) {
        int count = 0;
        for (long i = 1L; i * i <= n; i++) {
            count++;
        }
        return count;
    }
}
