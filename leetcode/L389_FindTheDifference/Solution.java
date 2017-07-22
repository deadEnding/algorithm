package leetcode.again.L389_FindTheDifference;

import java.util.HashSet;

/**
 * @author: deadend
 * @date: 2:09 PM 3/16/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public char findTheDifference(String s, String t) {
        long sum = 0L;
        for (char c : s.toCharArray()) {
            sum -= c;
        }

        for (char c : t.toCharArray()) {
            sum += c;
        }
        return (char) sum;
    }
}


class BasicSolution {
    public char findTheDifference(String s, String t) {
        HashSet<Character> set = new HashSet<>();
        String[] strs = {s, t};
        for (String str : strs) {
            for (char c : str.toCharArray()) {
                if (set.contains(c)) {
                    set.remove(c);
                } else {
                    set.add(c);
                }
            }
        }
        return set.iterator().next();
    }
}
