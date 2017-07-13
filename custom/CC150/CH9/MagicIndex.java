package custom.CC150.CH9;

/**
 * @author: deadend
 * @date: 9:17 PM 12/29/16
 * @version: 1.0
 * @description:
 */


public class MagicIndex {

    private int search(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }

        int midIndex = left + (right - left) / 2;
        int midValue = nums[midIndex];
        if (midIndex == midValue) {
            return midIndex;
        }

        int leftIndex;
        if ((leftIndex = search(nums, left, Math.min(midIndex - 1, midValue))) != -1) {
            return leftIndex;
        }
        return search(nums, Math.max(midIndex + 1, midValue), right);
    }

    public int search(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
}
