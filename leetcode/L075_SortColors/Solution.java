package leetcode.L075_SortColors;


public class Solution {
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

    public void sortColors(int[] nums) {
        final int n = nums.length;

        for (int l = 0, r = n - 1, i = 0; i <= r;) {
            if (nums[i] == 0) {
                swap(nums, l++, i++);
            } else if (nums[i] == 2) {
                swap(nums, r--, i);
            } else {
                i++;
            }
        }
    }
}


class OldSolution {

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public void sortColors(int[] nums) {
        int i = 0, k = nums.length - 1;
        for (int j = 0; j <= k;) {
            if (nums[j] == 2) {
                swap(nums, j, k--);
            } else if (nums[j] == 0) {
                swap(nums, i++, j++);
            } else {
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,0};
        new Solution().sortColors(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}
