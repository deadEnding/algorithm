package custom.CC150.CH9;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 9:53 AM 12/30/16
 * @version: 1.0
 * @description: 生成n对括号的所有合法排列方式
 */


public class GenerateParenthesis {
    private List<String> result = new LinkedList<>();

    private void generate(StringBuffer path, int i, int j) {
        if (j == 0) {
            result.add(path.toString());
            return;
        }

        if (i > 0) {
            path.append('(');
            generate(path, i - 1, j);
            path.deleteCharAt(path.length() - 1);
        }

        if (i < j) {
            path.append(')');
            generate(path, i, j - 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        generate(new StringBuffer(), n, n);
        return result;
    }
}
