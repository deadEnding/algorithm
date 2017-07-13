package leetcode.L492_ConstructTheRectangle;

/**
 * @author: deadend
 * @date: P10:59 AM 2/5/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int[] constructRectangle(int area) {
        for (int i = (int) Math.sqrt(area); i <= area; i++) {
            if (area % i == 0 && i >= (area / i)) {
                return new int[]{i, area / i};
            }
        }
        return null;
    }
}
