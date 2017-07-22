package leetcode.L294_FlipGameII;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 7:52 PM 3/11/17
 * @version: 1.0
 * @description:
 */

public class Solution {
    public boolean canWin(String s) {
        if (s == null || !s.contains("++")) {
            return false;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)) {
                String t = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!canWin(t)) {
                    return true;
                }
            }
        }
        return false;
    }
}

// 与或树
class BasicSolution {
    private List<String> nexts(String s) {
        char[] chs = s.toCharArray();
        List<String> result = new LinkedList<>();

        for (int i = 1; i < chs.length; i++) {
            if (chs[i] == '+' && chs[i - 1] == '+') {
                chs[i] = chs[i - 1] = '-';
                result.add(new String(chs));
                chs[i] = chs[i - 1] = '+';
            }
        }
        return result;
    }

    private boolean canWin(String s, boolean and, HashMap<String, Boolean> cache) {
        if (!s.contains("++")) {
            return and;
        }

        if (!cache.containsKey(s)) {
            boolean val = and;
            List<String> nexts = nexts(s);
            for (String next : nexts) {
                boolean subVal = canWin(next, !and, cache);
                val = and ? (val && subVal) : (val || subVal);
            }
            cache.put(s, val);
        }
        return cache.get(s);
    }

    public boolean canWin(String s) {
        return canWin(s, false, new HashMap<>());
    }

    public static void main(String[] args) {
        String s = "+-";
        System.out.println(new Solution().canWin(s));
    }
}
