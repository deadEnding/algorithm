package leetcode.L007_ReverseInteger;


public class Solution {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        long num = Math.abs(x);
        long rnum = 0L;

        while (num != 0) {
            rnum = rnum * 10 + num % 10;
            num /= 10;
        }

        rnum *= sign;
        if (rnum > Integer.MAX_VALUE || rnum < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) rnum;
    }
}
