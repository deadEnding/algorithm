package leetcode.again.L523_ContinuousSubarraySum;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 10:34 PM 28/03/2017
 */

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = k == 0 ? sum : sum % k;
            if (map.containsKey(mod)) {
                if (i - map.get(mod) >= 2) {
                    return true;
                }
            } else {
                map.put(mod, i);
            }
        }
        return false;
    }
}

class BasicSolution {
    public boolean checkSubarraySum(int[] nums, int k) {
        final int n = nums.length;

        int[] sum = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        for (int i = 0; i <= n; i++) {
            for (int j = i + 2; j <= n; j++) {
                if ((k == 0 && sum[i] == sum[j]) || (k != 0 && (sum[i] - sum[j]) % k == 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}
