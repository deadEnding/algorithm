package custom.CC150.CH18;

/**
 * @author: deadend
 * @date: 2:36 PM 1/5/17
 * @version: 1.0
 * @description:
 */


public class Count2s {
    private int count2sInRangeAtDigit(int n, int d) {
        int power = (int) Math.pow(10, d);
        int nextPower = power * 10;

        int roundDown = n - n % nextPower;
        int roundUp = roundDown + nextPower;

        int digit = n / power % 10;
        if (digit < 2) {
            return roundDown / 10;
        } else if (digit == 2) {
            return roundDown / 10 + n % power + 1;
        } else {
            return roundUp / 10;
        }
    }

    public int count2sInRange(int n) {
        int count = 0;
        int len = String.valueOf(n).length();
        for (int i = 0; i < len; i++) {
            count += count2sInRangeAtDigit(n, i);
        }
        return count;
    }
}
