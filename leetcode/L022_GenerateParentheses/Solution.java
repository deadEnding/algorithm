package leetcode.L022_GenerateParentheses;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 9:46 AM 11/29/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    private void dfs(int l, int r, int n, StringBuffer path, List<String> result) {
        if (r == n) {
            result.add(path.toString());
            return;
        }

        if (l < n) {
            path.append('(');
            dfs(l + 1, r, n, path, result);
            path.deleteCharAt(path.length() - 1);
        }

        if (l > r) {
            path.append(')');
            dfs(l, r + 1, n, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        dfs(0, 0, n, new StringBuffer(), result);
        return result;
    }

    public static void main(String[] args) {
        List<String> result = new Solution().generateParenthesis(3);
        for (String s : result) {
            System.out.println(s);
        }
    }
}

class OtherSolution {
    private void dfs(int i, int j, StringBuffer path, List<String> result) {
        if (i == 0 && j == 0) {
            result.add(path.toString());
            return;
        }

        if (i > 0 && i <= j) {
            path.append('(');
            dfs(i - 1, j, path, result);
            path.deleteCharAt(path.length() - 1);
        }

        if (i < j) {
            path.append(')');
            dfs(i, j - 1, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<String>();
        dfs(n, n, new StringBuffer(), result);
        return result;
    }
}


