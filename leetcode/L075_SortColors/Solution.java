package leetcode.L075_SortColors;

/**
 * @author: deadend
 * @date: 8:50 AM 11/18/16
 * @version: 1.0
 * @description:
 */

public class Solution {
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void sortColors(int[] nums) {
        int p = 0;
        int q = nums.length - 1;

        for (int i = 0; i < q + 1;) {
            if (nums[i] == 0) {
                swap(nums, i++, p++);
            } else if (nums[i] == 2) {
                swap(nums, i, q--);
            } else {
                i++;
            }
        }
    }
}

class Solution2 {
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void sortColors(int[] nums) {
        for (int ix = 0, i = 0; ix < 2; ix++) {
            int j = nums.length - 1;
            while (i < j) {
                while (i < j && nums[i] == ix) {
                    i++;
                }

                while (i < j && nums[j] != ix) {
                    j--;
                }

                if (i < j) {
                    swap(nums, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,2,0,0};
        new Solution().sortColors(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
