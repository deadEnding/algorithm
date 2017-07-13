package leetcode.again.L475_Heaters;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 6:43 PM 3/13/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int max = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            while (j + 1 < heaters.length &&
                    Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1])) {
                j++;
            }
            max = Math.max(max, Math.abs(houses[i] - heaters[j]));
        }
        return max;
    }
}
