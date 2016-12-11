package leetcode.L241_DifferentWaysToAddParentheses;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 12:33 PM 12/11/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private List<Integer> diffWaysToCompute(String input, int from, int to) {
        List<Integer> result = new LinkedList<>();
        for (int i = from; i < to; i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                List<Integer> left = diffWaysToCompute(input, from, i);
                List<Integer> right = diffWaysToCompute(input, i + 1, to);
                for (int l : left) {
                    for (int r : right) {
                        result.add(c == '+' ? l + r : (c == '-' ? l - r : l * r));
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(input.substring(from, to)));
        }
        return result;
    }

    public List<Integer> diffWaysToCompute(String input) {
        return diffWaysToCompute(input, 0, input.length());
    }

    public static void main(String[] args) {
        String input = "2*3-4*5";
        List<Integer> result = new Solution().diffWaysToCompute(input);
        for (int i : result) {
            System.out.println(i + " ");
        }
    }
}
