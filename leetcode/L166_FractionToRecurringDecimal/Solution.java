package leetcode.L166_FractionToRecurringDecimal;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 9:21 AM 11/25/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuffer result = new StringBuffer();
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            result.append('-');
        }

        long nume = Math.abs((long)numerator);
        long deno = Math.abs((long)denominator);
        result.append(nume / deno);
        long remain  = nume % deno;
        String fractional = "";
        HashMap<Long, Integer> map = new HashMap<>();

        while (remain != 0) {
            if (map.containsKey(remain)) {
                break;
            }
            map.put(remain, fractional.length());
            remain *= 10;
            fractional += remain / deno;
            remain %= deno;
        }

        if (remain == 0) {
            result.append(fractional.equals("") ? "" : "." + fractional);
        } else {
            String tmp = fractional.substring(0, map.get(remain)) + "(" + fractional.substring(map.get(remain), fractional.length()) + ")";
            result.append("." + tmp);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fractionToDecimal(-1, Integer.MIN_VALUE));
    }
}
