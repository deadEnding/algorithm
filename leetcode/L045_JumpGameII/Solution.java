package leetcode.L045_JumpGameII;

/**
 * @author: deadend
 * @date: 9:40 AM 11/14/16
 * @version: 1.0
 * @description:
 */


public class Solution {

    // 广度优先遍历
    public int jump(int[] nums) {
        int step = 0;
        if (nums.length <= 1) {
            return 0;
        }

        for (int l = 0, r = 0, newr = 0; l <= r; l++) {
            newr = Math.max(newr, l + nums[l]);
            if (newr >= nums.length - 1) {
                return step + 1;
            }
            if (l == r) {
                r = newr;
                step++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(new Solution().jump(nums));
    }
}
