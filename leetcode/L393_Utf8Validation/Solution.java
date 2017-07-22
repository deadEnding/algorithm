package leetcode.L393_Utf8Validation;

/**
 * @author: deadend
 * @date: 4:57 PM 3/P10/17
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

        if (data[ix] < 0b10000000) {
            return isValid(data, ix + 1);
        }

        if (data[ix] < 0b11000000) {
            return false;
        }

        if (data[ix] >= 0b11111000) {
            return false;
        }

        int n = data[ix] < 0b11100000 ? 1 : (data[ix] < 0b11110000 ? 2 : 3);
        while (n-- > 0) {
            ix++;
            if (ix >= data.length || data[ix] < 0b10000000 || data[ix] > 0b10111111) {
                return false;
            }
        }
        return isValid(data, ix + 1);
    }

    public boolean validUtf8(int[] data) {
        return isValid(data, 0);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validUtf8(new int[]{197, 130, 1}));
    }
}


class BasicSolution {

    private static final int MASK_0 = 0b11000000;

    private static final int MASK_1 = 0b10000000;
    private static final int MASK_2 = 0b11100000;
    private static final int MASK_3 = 0b11110000;
    private static final int MASK_4 = 0b11111000;

    private boolean maskHelper(int num) {
        return (MASK_0 & (MASK_0 - 1)) == (num & MASK_0);
    }

    private int valueHelper(int num) {
        return num & (num - 1);
    }

    public boolean validUtf8(int[] data) {
        final int n = data.length;
        for (int i = 0; i < n;) {
            if ((data[i] & MASK_1) == valueHelper(MASK_1)) {
                i++;
            } else if ((data[i] & MASK_2) == valueHelper(MASK_2)) {
                if (i + 1 >= n || !maskHelper(data[i + 1])) {
                    return false;
                }
                i += 2;
            } else if ((data[i] & MASK_3) == valueHelper(MASK_3)) {
                if (i + 2 >= n || !maskHelper(data[i + 1]) || !maskHelper(data[i + 2])) {
                    return false;
                }
                i += 3;
            } else if ((data[i] & MASK_4) == valueHelper(MASK_4)) {
                if (i + 3 >= n || !maskHelper(data[i + 1]) || !maskHelper(data[i + 2]) || !maskHelper(data[i + 3])) {
                    return false;
                }
                i += 4;
            } else {
                return false;
            }
        }

        return true;
    }
}
