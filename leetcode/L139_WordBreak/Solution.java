package leetcode.again.L139_WordBreak;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author: deadend
 * @date: 9:51 AM 3/17/17
 * @version: 1.0
 * @description:
 */

public class Solution {
    private boolean helper(int ix, String s, HashSet<String> dict, int[] can) {
        if (can[ix] == 0) {
            if (dict.contains(s.substring(ix))) {
                can[ix] = 1;
            } else {
                can[ix] = -1;
                for (int i = ix + 1; i < s.length(); i++) {
                    if (dict.contains(s.substring(ix, i)) && helper(i, s, dict, can)) {
                        can[ix] = 1;
                        break;
                    }
                }
            }
        }
        return can[ix] == 1;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        final int n = s.length();
        HashSet<String> set = new HashSet<>();
        set.addAll(wordDict);
        return helper(0, s, set, new int[n]);
    }
}


class DPUpDownSolution {

    private boolean helper(int ix, String s, HashSet<String> dict, HashMap<Integer, Boolean> cache) {
        if (ix == s.length()) {
            return true;
        }

        if (cache.containsKey(ix)) {
            return cache.get(ix);
        }

        for (int i = ix + 1; i <= s.length(); i++) {
            if (dict.contains(s.substring(ix, i)) && helper(i, s, dict, cache)) {
                cache.put(ix, true);
                return true;
            }
        }
        cache.put(ix, false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        set.addAll(wordDict);
        return helper(0, s, set, new HashMap<>());
    }
}

class DPSolution {
    public boolean wordBreak(String s, List<String> wordDict) {
        final int n = s.length();
        HashSet<String> set = new HashSet<>();
        set.addAll(wordDict);
        boolean[] can = new boolean[n + 1];
        can[n] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                if (set.contains(s.substring(i, j)) && can[j]) {
                    can[i] = true;
                    break;
                }
            }
        }
        return can[0];
    }
}


class TimeoutSolution {
    private boolean wordBreak(String s, HashSet<String> wordDict, HashMap<String, Boolean> cache) {
        if (wordDict.contains(s)) {
            return true;
        }

        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        for (int i = 1; i < s.length(); i++) {
            if (wordBreak(s.substring(0, i), wordDict, cache) && wordBreak(s.substring(i), wordDict, cache)) {
                cache.put(s, true);
                return true;
            }
        }
        cache.put(s, false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>();
        dict.addAll(wordDict);
        return wordBreak(s, dict, new HashMap<>());
    }
}
