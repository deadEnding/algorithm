package leetcode.L282_ExpressionAddOperators;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 9:52 PM 12/11/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    private void helper(List<String> rst, String path, String num, int target, int ix, long eval, long tomulti) { // tomulti 上一次数字结尾的乘法公式片段
        if (ix == num.length()) {
            if (target == eval) {
                rst.add(path);
            }
            return;
        }

        for (int i = ix; i < num.length(); i++) {
            if (num.charAt(ix) == '0' && i != ix) {
                break;
            }
            long cur = Long.parseLong(num.substring(ix, i + 1));
            if (ix == 0) {
                helper(rst,  "" + cur, num, target, i + 1, cur, cur);
            } else {
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur, cur);
                helper(rst, path + "-" + cur, num, target,  i + 1, eval - cur, -cur);
                helper(rst, path + "*" + cur, num, target, i + 1, eval - tomulti + tomulti * cur, tomulti * cur);
            }
        }
    }

    public List<String> addOperators(String num, int target) {
        List<String> result = new LinkedList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        helper(result, "", num, target, 0, 0, 0);   
        return result;
    }
}
