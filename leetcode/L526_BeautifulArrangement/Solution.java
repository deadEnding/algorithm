package leetcode.L526_BeautifulArrangement;

/**
 * @author: deadend
 * @date: 11:06 AM 29/03/2017
 */


public class Solution {
    private int count = 0;

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void backtracking(int ix, int[] nums) {
        if (ix == nums.length) {
            count++;
        }

        for (int i = ix; i < nums.length; i++) {
            if (nums[i] % (ix + 1) == 0 || (ix + 1) % nums[i] == 0) {
                swap(nums, ix, i);
                backtracking(ix + 1, nums);
                swap(nums, ix, i);
            }
        }
    }

    public int countArrangement(int N) {
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
        }
        backtracking(0, nums);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countArrangement(2));
    }
}

