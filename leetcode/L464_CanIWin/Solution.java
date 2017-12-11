package leetcode.L464_CanIWin;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 2:03 PM 11/27/16
 * @version: 1.0
 * @description:
 */

class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0)
            return true;

        if (maxChoosableInteger * (1 + maxChoosableInteger) / 2 < desiredTotal)
            return false;

        return dfs(maxChoosableInteger, desiredTotal, 0, new HashMap<Integer, Boolean>());
    }

    private boolean dfs(int n, int total, int used, HashMap<Integer, Boolean> cache) {
        if (total <= 0)
            return false;

        if (!cache.containsKey(used)) {
            cache.put(used, false);
            for (int i = 1; i <= n; i++) {
                int b = 1 << i;
                if ((used & b) == 0) {
                    if (!dfs(n, total - i, used | b, cache)) {
                        cache.put(used, true);
                        break;
                    }
                }
            }
        }
        return cache.get(used);
    }
}


class SSolution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) {
            return true;
        }

        if (maxChoosableInteger * (1 + maxChoosableInteger) / 2 < desiredTotal) {
            return false;
        }

        return dfs(desiredTotal, maxChoosableInteger, 0, new HashMap<>());
    }

    private boolean dfs(int total, int n, int used, HashMap<Integer, Boolean> cache) {
        if (total <= 0) {
            return false;
        }


        if (!cache.containsKey(used)) {
            cache.put(used, false);
            for (int i = 1; i <= n; i++) {
                int bit = 1 << i;
                if ((used & bit) == 0) {
                    if (!dfs(total - i, n, used | bit, cache)) {
                        cache.put(used, true);
                        break;
                    }
                }
            }
        }

        return cache.get(used);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canIWin(10, 1));
    }
}


// Maybe wrong
class OldSolution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        return helper1(desiredTotal, new boolean[maxChoosableInteger+1]);
    }

    private boolean helper1(int total, boolean[] used) {
        if (total <= 0) {
            return false;
        }

        for (int i = 1; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                if (helper2(total - i, used)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    private boolean helper2(int total, boolean[] used) {
        if (total <= 0) {
            return true;
        }

        for (int i = 1; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                if (!helper1(total - i, used)) {
                    return false;
                }
                used[i] = false;
            }
        }
        return true;
    }
}
