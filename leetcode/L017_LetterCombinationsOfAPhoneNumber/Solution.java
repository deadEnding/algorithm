package leetcode.L017_LetterCombinationsOfAPhoneNumber;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 5:17 PM 11/27/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private String[] map = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private List<String> result = new LinkedList<>();

    private void dfs(int ix, String digits, StringBuffer sb) {
        if (ix == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String letters = map[digits.charAt(ix) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            dfs(ix + 1, digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            dfs(0, digits, new StringBuffer());
        }
        return result;
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(new Solution().letterCombinations(digits));
    }
}
