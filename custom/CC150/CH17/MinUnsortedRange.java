package custom.CC150.CH17;

/**
 * @author: deadend
 * @date: 2:01 PM 1/4/17
 * @version: 1.0
 * @description: 给定整数序列，求最小排序子区间[start, end]，使得对该子区间排序后能够保证整个序列有序
 */

class Range {
    int start, end;
    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MinUnsortedRange {

    /**
     * 求左侧非降序段结尾下标
     * @param nums 数组
     * @return 左侧非降序段结尾下标
     */
    private int findEndOfLeft(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return i - 1;
            }
        }
        return nums.length - 1;
    }

    /**
     * 求右侧非降序段起始下标
     * @param nums 数组
     * @return 右侧非降序段起始下标
     */
    private int findStartOfRight(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                return i + 1;
            }
        }
        return 0;
    }

    /**
     * 向左收缩左段的结尾下标
     * @param nums 数组
     * @param min  中间段最小值
     * @param end 左段的结尾下标
     * @return 收缩后左段的结尾下标
     */
    private int shrinkLeft(int[] nums, int min, int end) {
        for (int i = end; i >= 0; i--) {
            if (nums[i] <= min) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 向右收缩右段的起始下标
     * @param nums 数组
     * @param max  中间段最小值
     * @param start 右段的起始下标
     * @return 收缩后右段的起始下标
     */
    private int shrinkRight(int[] nums, int max, int start) {
        for (int i = start; i < nums.length; i++) {
            if (nums[i] >= max) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 求最小排序区间
     * @param nums 数组
     * @return 最小排序区间
     */
    public Range getMinUnsortedRange(int[] nums) {
        int leftEnd = findEndOfLeft(nums);
        if (leftEnd == nums.length - 1) {   // 已有序
            return null;
        }

        int rightStart = findStartOfRight(nums);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = leftEnd; i <= rightStart; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int midStart = shrinkLeft(nums, min, leftEnd) + 1;
        int midEnd = shrinkRight(nums, max, rightStart) - 1;
        return new Range(midStart, midEnd);
    }
}
