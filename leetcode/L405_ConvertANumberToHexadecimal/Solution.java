package leetcode.L405_ConvertANumberToHexadecimal;

/**
 * @author: deadend
 * @date: 2:24 PM 12/21/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String toHex(int num) {
        final int mask = 15;
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        StringBuffer sb = new StringBuffer();
        while (num != 0) {
            sb.insert(0, map[num & mask]);
            num >>>= 4;
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
