package custom.company.tencent.internship.T20170402.Q3;

/**
 * @author: deadend
 * @date: 8:11 PM 02/04/2017
 */


public class Main {

    public static int binarySearchLeft(int[] nums, int target) {
        final int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                r = m;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static int binarySearchRight(int[] nums, int target) {
        final int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int m = r - (r - l) / 2;
            if (nums[m] == target) {
                l = m;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static int search(int[] nums, int target) {
        int l = binarySearchLeft(nums, target);
        int r = binarySearchRight(nums, target);
        if (nums[l] == target && nums[r] == target) {
            return r - l + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,1, 2,2,2,3};
        System.out.println(Main.search(nums, 1));
        System.out.println(Main.search(nums, 2));
        System.out.println(Main.search(nums, 3));
        System.out.println(Main.search(nums, 4));
    }
}
