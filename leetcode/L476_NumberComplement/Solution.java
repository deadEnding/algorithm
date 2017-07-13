package leetcode.L476_NumberComplement;

/**
 * @author: deadend
 * @date: 9:19 AM 1/9/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int findComplement(int num) {
        int result = 0;
        int base = 1;
        while (num != 0) {
            result += base * (1 - (num & 1));
            num >>= 1;
            base <<= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findComplement(Integer.MAX_VALUE));
    }
}
