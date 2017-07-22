package leetcode.L220_ContainsDuplicateIII;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author: deadend
 * @date: 4:01 PM 2/28/17
 * @version: 1.0
 * @description:
 */


// O(n)
public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }

        final int n = nums.length;
        HashMap<Long, Long> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long mapedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucketId = mapedNum / (t + 1L);
            if (map.containsKey(bucketId) ||
                    map.containsKey(bucketId - 1) && mapedNum - map.get(bucketId - 1) <= t ||
                    map.containsKey(bucketId + 1) && map.get(bucketId + 1) - mapedNum <= t) {
                return true;
            }

            if (map.size() == k) {
                long expiredBucketId = ((long) nums[i - k] - Integer.MIN_VALUE) / (t + 1L);
                map.remove(expiredBucketId);
            }

            map.put(bucketId, mapedNum);
        }
        return false;
    }
}

// O(nlogn)
class BasicSolution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1 || k < 1 || t < 0) {
            return false;
        }

        TreeMap<Long, Long> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            java.util.SortedMap<Long, Long> subMap = map.subMap((long) nums[i] - t, (long) nums[i] + t + 1);
            if (!subMap.isEmpty()) {
                return true;
            }

            if (i >= k) {
                long oldKey = nums[i - k];
                map.put(oldKey, map.get(oldKey) - 1);
                if (map.get(oldKey) == 0) {
                    map.remove(oldKey);
                }
            }

            map.put((long) nums[i], map.getOrDefault((long) nums[i], 0L) + 1L);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-3, 3};
        System.out.println(new Solution().containsNearbyAlmostDuplicate(nums, 2, 4));
    }
}
