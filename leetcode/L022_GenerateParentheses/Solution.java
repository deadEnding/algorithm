package leetcode.L022_GenerateParentheses;


import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<String> result = new LinkedList<>();

    private void dfs(int l, int r, String path) {
        if (l == 0 && r == 0) {
            result.add(path);
            return;
        }

        if (l > 0) {
            dfs(l - 1, r, path + "(");
        }

        if (r > l) {
            dfs(l, r - 1, path + ")");
        }
    }

    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return result;
    }
}
