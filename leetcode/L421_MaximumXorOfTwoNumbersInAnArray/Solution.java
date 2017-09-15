package leetcode.L421_MaximumXorOfTwoNumbersInAnArray;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: deadend
 * @date: P10:48 AM 12/22/16
 * @version: 1.0
 * @description: unresolved
 */


// 若a ^ b = c，则有 a ^ c = b
class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for (int i = 31, mask = 0; i >= 0; i--) {
            mask = mask | (1 << i);
            HashSet<Integer> prefixs = new HashSet<>();
            for (int num : nums) {
                prefixs.add(mask & num);
            }

            int newMax = max | (1 << i);
            for (int prefix : prefixs) {
                if (prefixs.contains(newMax ^ prefix)) {
                    max = newMax;
                    break;
                }
            }
        }

        return max;
    }
}

// 若a ^ b = c，则有 a ^ c = b
class OldSolution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for (int i = 31, mask = 0; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }

            int tmp = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3,10,5,25,2,8};
        System.out.println(new Solution().findMaximumXOR(nums));
    }
}
