package custom.company.google.interview;

/**
 * 除了一个数出现一次外，所有数都出现两次，所有出现两次的数都挨着，比如3，3，2，2，4，5，5,找出那个出现一次的数。
 */
public class SingleNumber {

    public int find(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (m % 2 == 0) {
                if (nums[m] == nums[m + 1]) {
                    l = m + 2;
                } else {
                    r = m - 1;
                }
            } else {
                if (nums[m] == nums[m - 1]) {
                    l = m + 1;
                } else {
                    r = m - 2;
                }
            }
        }

        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1};
        System.out.println(new SingleNumber().find(nums));
    }
}
