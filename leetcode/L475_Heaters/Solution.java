package leetcode.L475_Heaters;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 8:37 PM 12/24/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int max = 0;
        int j = 0;
        for (int house : houses) {
            // 寻找离house最近的加热器
            while (j + 1 < heaters.length &&
                Math.abs(house - heaters[j]) >= Math.abs(house - heaters[j + 1])) {
                j++;
            }
            max = Math.max(max, Math.abs(house - heaters[j]));
        }
        return max;
    }
}
