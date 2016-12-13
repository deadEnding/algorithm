package leetcode.L306_AdditiveNumber;

/**
 * @author: deadend
 * @date: 9:49 AM 12/13/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private boolean isAdditiveNumber(String num, int i, int j) {
        int h = 0;
        while (j < num.length()) {
            long x = Long.valueOf(num.substring(h, i));
            long y = Long.valueOf(num.substring(i, j));
            String sz = String.valueOf(x + y);
            if (j + sz.length() > num.length() || !num.substring(j, j + sz.length()).equals(sz)) {
                return false;
            }
            h = i;
            i = j;
            j = j + sz.length();
        }
        return true;
    }

    public boolean isAdditiveNumber(String num) {
        final int n = num.length();

        for (int i = 1; i <= n / 2; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isAdditiveNumber(num, i, j)) {
                    return true;
                }
                if (num.charAt(i) == '0') {
                    break;
                }
            }
            if (num.charAt(0) == '0') {
                break;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String num = "198019823962";
        System.out.println(new Solution().isAdditiveNumber(num));
    }
}
