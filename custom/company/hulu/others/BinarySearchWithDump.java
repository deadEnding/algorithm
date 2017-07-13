package custom.company.hulu.others;

/**
 * 包含重复元素的二分查找，重复元素返回起始下标
 */

public class BinarySearchWithDump {

    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                r = m;
            }
        }

        return nums[l] == target ? l : -1;
    }
}
