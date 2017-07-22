package leetcode.L320_GeneralizedAbbreviation;

import java.util.*;

/**
 * @author: deadend
 * @date: 3:12 PM 3/11/17
 * @version: 1.0
 * @description:
 */


public class Solution {

    // 组合树
    private void backtrace(int ix, String word, String path, int count, List<String> result) {
        if (ix == word.length()) {
            path += count > 0 ? String.valueOf(count) : "";
            result.add(path);
        } else {
            // 不省略当前字符
            backtrace(ix + 1, word, path + (count > 0 ? String.valueOf(count) : "") + word.charAt(ix), 0, result);
            // 省略当前字符
            backtrace(ix + 1, word, path, count + 1, result);
        }
    }

    public List<String> generateAbbreviations(String word) {
        List<String> result = new LinkedList<>();
        backtrace(0, word, "", 0, result);
        return result;
    }

    public static void main(String[] args) {
        String word = "word";
        System.out.println(new Solution().generateAbbreviations(word));
    }
}
