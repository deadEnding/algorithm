package leetcode.L293_FlipGame;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 7:44 PM 3/11/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new LinkedList<>();
        char[] chs = s.toCharArray();

        for (int i = 1; i < chs.length; i++) {
            if (chs[i] == '+' && chs[i - 1] == '+') {
                chs[i] = chs[i - 1] = '-';
                result.add(new String(chs));
                chs[i] = chs[i - 1] = '+';
            }
        }

        return result;
    }
}
