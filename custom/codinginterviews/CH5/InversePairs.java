package custom.codinginterviews.CH5;

/**
 * @author: deadend
 * @date: 7:44 PM 2/6/17
 * @version: 1.0
 * @description:
 */


public class InversePairs {
    private int merge(int[] nums, int s, int m, int e) {
        final int n = e - s + 1;
        int[] tmp = new int[n];
        int total = 0;
        for (int ix = n - 1, i = m, j = e; ix >= 0; ix--) {
            long a = i >= s ? nums[i] : Integer.MIN_VALUE + 1L;
            long b = j >= m + 1 ? nums[j] : Integer.MIN_VALUE + 1L;
            if (a > b) {
                tmp[ix] = nums[i--];
                total += j - m;
            } else {
                tmp[ix] = nums[j--];
            }
        }

        for (int i = s, ix = 0; i <= e; i++) {
            nums[i] = tmp[ix++];
        }
        return total;
    }

    private int countInversePairs(int[] nums, int s, int e) {
        if (s == e) {
            return 0;
        }

        int total = 0;
        int m = s + (e - s) / 2;
        total += countInversePairs(nums, s, m) + countInversePairs(nums, m + 1, e);
        total += merge(nums, s, m, e);
        return total;
    }

    public int countInversePairs(int[] nums) {
        return countInversePairs(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {7,6,5};
        System.out.println(new InversePairs().countInversePairs(nums));
    }
}
