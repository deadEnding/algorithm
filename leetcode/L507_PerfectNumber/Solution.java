package leetcode.L507_PerfectNumber;

/**
 * @author: deadend
 * @date: 6:51 PM 28/03/2017
 */


public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }

        long sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                if (i == num / i) {
                    sum += i;
                } else {
                    sum += i + num / i;
                }
            }
        }
        return sum == num;
    }
}
