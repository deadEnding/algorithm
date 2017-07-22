package leetcode.again.L540_SingleElementInASortedArray;


public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length / 2;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[2 * m] != nums[2 * m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return nums[2 * l];
    }
}

class BasicSolution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (m - 1 >= l && nums[m - 1] == nums[m]) {
                if ((m - 1) % 2 == 0) {
                    l = m + 1;
                } else {
                    r = m - 2;
                }
            } else if (m + 1 <= r && nums[m] == nums[m + 1]) {
                if (m % 2 == 0) {
                    l = m + 2;
                } else {
                    r = m - 1;
                }
            } else {
                return nums[m];
            }
        }

        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {3,3,7,7,10,11,11};
        System.out.println(new Solution().singleNonDuplicate(nums));
    }
}
