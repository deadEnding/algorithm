package leetcode.L387_FirstUniqueCharacterInAString;


/**
 * @author: deadend
 * @date: 1:40 PM 12/19/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int firstUniqChar(String s) {
        final int SIZE = 256;
        int[][] counter = new int[SIZE][2];

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            counter[c][0]++;
            counter[c][1] = i;
        }

        int min = -1;
        for (int i = 0; i < SIZE; i++) {
            if (counter[i][0] == 1) {
                min = min == -1 ? counter[i][1] : Math.min(min, counter[i][1]);
            }
        }
        return min;
    }
}
