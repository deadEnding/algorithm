package leetcode.L483_SmallestGoodBase;

/**
 * @author: deadend
 * @date: 7:37 PM 2/4/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.valueOf(n);
        int maxBits = (int) (Math.log(num + 1) / Math.log(2)) + 1;

        for (int len = maxBits; len >= 2; len--) {
            long base = binarySearch(num, len);
            if (base != -1) {
                return String.valueOf(base);
            }
        }

        return String.valueOf(num - 1);
    }

    public long binarySearch(long num, int len) {
        long l = 2, r = (long) Math.pow(num + 1, 1.0 / (len - 1)) + 1;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long curNum = base2dec(mid, len);
            if (curNum == num) {
                return mid;
            } else if (curNum < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    private long base2dec(long base, int len) {
        long num = 0L, bit = 1L;
        for (int i = 0; i < len; i++) {
            num += bit;
            bit *= base;
        }

        return num;
    }

    public static void main(String[] args) {
        String n = "15";
        System.out.println(new Solution().smallestGoodBase(n));
    }
}
