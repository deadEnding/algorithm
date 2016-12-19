package leetcode.L393_Ut8Validation;

/**
 * @author: deadend
 * @date: 9:08 PM 12/19/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private boolean isValid(int[] data, int ix) {
        if (ix == data.length) {
            return true;
        }
        if (data[ix] < 0) {
            return false;
        }

        if (data[ix] < 128) {
            return isValid(data, ix + 1);
        }

        if (data[ix] < 192) {
            return false;
        }

        if (data[ix] >= 248) {
            return false;
        }

        int n = data[ix] < 224 ? 1 : (data[ix] < 240 ? 2 : 3);
        while (n-- > 0) {
            ix++;
            if (ix == data.length || data[ix] < 128 || data[ix] >= 192) {
                return false;
            }
        }
        return isValid(data, ix + 1);
    }

    public boolean validUtf8(int[] data) {
        return isValid(data, 0);
    }

    public static void main(String[] args) {
        int[] data = {39,89,227,83,132,95,10,0};
        System.out.println(new Solution().validUtf8(data));
    }
}
