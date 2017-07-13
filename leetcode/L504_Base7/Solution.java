package leetcode.L504_Base7;

/**
 * @author: deadend
 * @date: 12:46 PM 2/12/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    private String convertTo7WithUnsigned(int num) {
        StringBuffer buffer = new StringBuffer();
        while (num != 0) {
            int t = num / 7;
            buffer.insert(0, num - t * 7);
            num = t;
        }
        return buffer.length() == 0 ? "0" : buffer.toString();
    }

    public String convertTo7(int num) {
        return (num < 0 ? "-" : "") + convertTo7WithUnsigned(Math.abs(num));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convertTo7(0));
    }
}
