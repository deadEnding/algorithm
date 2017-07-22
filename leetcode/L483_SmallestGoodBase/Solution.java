package leetcode.L483_SmallestGoodBase;

/**
 * @author: deadend
 * @date: 1:16 PM 3/18/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.valueOf(n);

        // 求num数值2进制对应的位数，即最大位数，因此进制越大，位数越小
        int maxBits = 0;
        for (long t = num; t != 0; t >>= 1) {
            maxBits++;
        }

        // 位数由大到小进行测试，一旦合法立即返回
        for (int bits = maxBits; bits >= 2; bits--) {
            long k = helper(num, bits);
            if (k != -1) {
                return String.valueOf(k);
            }
        }
        return null;
    }

    // 是否存在x进制使得bits个1的值等于num，存在则返回x，否则返回-1
    public long helper(long num, int bits) {
        // 确定进制的上届，若直接r = num - 1会溢出
        long l = 2, r = (long) (Math.pow(num, 1.0 / (bits - 1)) + 1);
        while (l <= r) {
            long m = l + (r - l) / 2;
            long sum = 0, cur = 1;
            for (int i = 0; i < bits; i++) {
                sum += cur;
                cur *= m;
            }

            if (sum == num) {
                return m;
            } else if (sum < num) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "677";
        System.out.println(new Solution().smallestGoodBase(s));
    }
}
