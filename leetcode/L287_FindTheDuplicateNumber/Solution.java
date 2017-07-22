package leetcode.L287_FindTheDuplicateNumber;

/**
 * @author: deadend
 * @date: 8:12 PM 2/28/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);

        fast = 0;
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(new Solution().findDuplicate(nums));
    }
}

class BinarySearchSolution {
    private int count(int[] nums, int target) {
        int cnt = 0;
        for (int num : nums) {
            if (num <= target) {
                cnt++;
            }
        }
        return cnt;
    }

    public int findDuplicate(int[] nums) {
        final int n = nums.length;
        int l = 1;
        int r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            int cnt = count(nums, m);
            if (cnt > m) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
