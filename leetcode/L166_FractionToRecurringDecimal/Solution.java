package leetcode.L166_FractionToRecurringDecimal;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: P10:37 AM 3/18/17
 * @version: 1.0
 * @description:
 */


class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder builder = new StringBuilder();
        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
            builder.append("-");
        }

        long nume = Math.abs((long) numerator);
        long deno = Math.abs((long) denominator);
        builder.append(nume / deno);

        long remain = nume % deno;
        HashMap<Long, Integer> map = new HashMap<>();
        String tmp = "";
        while (remain != 0 && !map.containsKey(remain)) {
            map.put(remain, tmp.length());
            long t = remain * 10;
            tmp += t / deno;
            remain = t % deno;
        }

        if (remain == 0) {
            builder.append(tmp.length() > 0 ? "." + tmp : "");
        } else {
            int ix = map.get(remain);
            builder.append("." + tmp.substring(0, ix));
            builder.append("(" + tmp.substring(ix) + ")");
        }

        return builder.toString();
    }
}



class OldSolution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder builder = new StringBuilder();
        if (numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0) {
            builder.append("-");
        }

        long nume = Math.abs((long) numerator);
        long demo = Math.abs((long) denominator);
        builder.append(nume / demo);
        long remain = nume % demo;

        StringBuilder frac = new StringBuilder();
        HashMap<Long, Integer> map = new HashMap<>();

        while (remain != 0) {
            if (map.containsKey(remain)) {
                break;
            }

            map.put(remain, frac.length());
            remain *= 10;
            frac.append(remain / demo);
            remain %= demo;
        }

        if (remain == 0) {
            builder.append(frac.length() == 0 ? "" : "." + frac.toString());
        } else {
            int ix = map.get(remain);
            builder.append(String.format(".%s(%s)", frac.substring(0, ix), frac.substring(ix)));
        }
        return builder.toString();
    }
}
