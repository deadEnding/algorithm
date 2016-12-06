package leetcode.L139_WordBreak;

import java.util.Set;

/**
 * @author: deadend
 * @date: 3:30 PM 12/6/16
 * @version: 1.0
 * @description:
 */

// can[i] = contain(i, j) && can[j]
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        final int n = s.length();
        boolean[] can = new boolean[n + 1];
        can[n] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n; j > i; j--) {
                if (wordDict.contains(s.substring(i, j)) && can[j]) {
                    can[i] = true;
                    break;
                }
            }
        }
        return can[0];
    }
}

// 备忘录
class RecusiveSolution {
    private boolean wordBreak(String s, int from, Set<String> dict, int[] can) {
        if (can[from] == 0) {
            if (dict.contains(s.substring(from))) {
                can[from] = 1;
            } else {
                can[from] = -1;
                for (int i = from + 1; i < s.length(); i++) {
                    if (dict.contains(s.substring(from, i)) && wordBreak(s, i, dict, can)) {
                        can[from] = 1;
                        break;
                    }
                }
            }
        }
        return can[from] == 1 ? true : false;
    }

    public boolean wordBreak(String s, Set<String> wordDict) {
        final int n = s.length();
        int[] can = new int[n];
        return wordBreak(s, 0, wordDict, can);
    }
}
