package leetcode.L247_StrobogrammaticNumberII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: deadend
 * @date: P10:20 AM 3/11/17
 * @version: 1.0
 * @description:
 */


public class Solution {

    private List<String> helper(int n, boolean canLeadZero) {
        if (n == 0) {
            return new ArrayList<>(Arrays.asList(""));
        }

        if (n == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        }

        List<String> subs = helper(n - 2, true);

        List<String> result = new ArrayList<>();
        for (String s : subs) {
            if (canLeadZero) {
                result.add("0" + s + "0");
            }

            result.add("1" + s + "1");
            result.add("8" + s + "8");
            result.add("6" + s + "9");
            result.add("9" + s + "6");
        }
        return result;
    }

    public List<String> findStrobogrammatic(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return helper(n, false);
    }
}
