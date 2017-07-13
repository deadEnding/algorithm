package leetcode.again.L422_ValidWordSquare;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 8:16 PM 3/12/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public boolean validWordSquare(List<String> words) {
        final int n = words.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                if (j >= n || words.get(j).length() <= i ||
                        words.get(i).charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<String> words = new LinkedList<String>() {{ add("abc"); add("b"); }};
        System.out.println(new Solution().validWordSquare(words));
    }
}
