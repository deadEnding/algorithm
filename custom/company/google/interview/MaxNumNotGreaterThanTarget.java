package custom.company.google.interview;

/**
 * 有序数组中求不大于 target 的最大值
 */
public class MaxNumNotGreaterThanTarget {

    public static int find(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = r - (r - l) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m;
            }
        }

        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,6,8};
        System.out.println(find(nums, 3));
    }
}
