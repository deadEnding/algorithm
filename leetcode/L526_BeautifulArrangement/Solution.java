package leetcode.L526_BeautifulArrangement;

/**
 * @author: deadend
 * @date: 4:54 PM 2/20/17
 * @version: 1.0
 * @description:
 */


public class Solution {

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

    private int countArrangement(int ix, int[] nums) {
        if (ix == nums.length) {
            return 1;
        }

        int count = 0;
        for (int i = ix; i < nums.length; i++) {
            if (nums[i] % ix == 0 || ix % nums[i] == 0) {
                swap(nums, ix, i);
                count += countArrangement(ix + 1, nums);
                swap(nums, ix, i);
            }
        }
        return count;
    }

    public int countArrangement(int N) {
        int[] nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = i;
        }
        return countArrangement(1, nums);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countArrangement(12));
    }
}
