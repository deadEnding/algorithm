package leetcode.L017_LetterCombinationsOfAPhoneNumber;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private String[] map = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private List<String> result = new LinkedList<>();

    private void dfs(int ix, String digits, String s) {
        if (ix == digits.length()) {
            result.add(s);
            return;
        }

        String letters = map[digits.charAt(ix) - '0'];
        for (char c : letters.toCharArray()) {
            dfs(ix + 1, digits, s + c);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            dfs(0, digits, "");
        }
        return result;
    }
}
