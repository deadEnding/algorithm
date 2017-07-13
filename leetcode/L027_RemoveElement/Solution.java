package leetcode.L027_RemoveElement;

/**
 * @author: deadend
 * @date: P10:18 AM 11/P10/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = 0;
        for (int i = 0, j = nums.length; i < j; i++) {
            if (nums[i] == val) {
                while (i < j && nums[--j] == val) {}  // 查找可用的替换对象
                if (i < j) {   // 找到
                    nums[i] = nums[j];
                } else {       // 未找到
                    break;
                }
            }
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        System.out.println(new Solution().removeElement(nums, 3));
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
