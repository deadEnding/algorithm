package leetcode.L403_FrogJump;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: deadend
 * @date: 2:39 PM 12/21/16
 * @version: 1.0
 * @description:
 */

class Solution {
    private boolean canCross(int[] stones, int ix, int last, HashMap<Integer, HashSet<Integer>> cannot) {
        if (ix == stones.length - 1) {
            return true;
        }

        if (cannot.containsKey(ix) && cannot.get(ix).contains(last)) {
            return false;
        }

        if (!cannot.containsKey(ix)) {
            cannot.put(ix, new HashSet<Integer>());
        }

        for (int i = -1; i <= 1; i++) {
            int p = Arrays.binarySearch(stones, ix + 1, stones.length, stones[ix] + last + i);
            if (p > 0 && canCross(stones, p, last + i, cannot)) {
                return true;
            }
        }
        cannot.get(ix).add(last);
        return false;
    }

    public boolean canCross(int[] stones) {
        if (stones.length == 1) {
            return true;
        }

        if (stones[1] != 1) {
            return false;
        }

        return canCross(stones, 1, 1, new HashMap<Integer, HashSet<Integer>>());
    }
}


// map保存每块石头处能跳的步数
class IterSolution {
    public boolean canCross(int[] stones) {
        if (stones.length == 1) {
            return true;
        }

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        map.put(0, new HashSet<Integer>());
        map.get(0).add(1);
        for (int i = 0; i < stones.length; i++) {
            if (!map.containsKey(stones[i])) {
                continue;
            }

            for (int s : map.get(stones[i])) {
                int dst = stones[i] + s;
                if (dst == stones[stones.length - 1]) {
                    return true;
                }
                if (Arrays.binarySearch(stones, i + 1, stones.length, dst) > 0) {
                    if (!map.containsKey(dst)) {
                        map.put(dst, new HashSet<Integer>());
                    }
                    for (int j = Math.max(1, s - 1); j <= s + 1; j++) {
                        map.get(dst).add(j);
                    }
                }
            }
        }
        return false;
    }
}
