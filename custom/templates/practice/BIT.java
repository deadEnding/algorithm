package custom.templates.practice;

/**
 * @author: deadend
 * @date: 4:38 PM 3/18/17
 * @version: 1.0
 * @description:
 */


public class BIT {

    private int[] sums;

    public BIT(int[] nums) {
        final int n = nums.length;
        if (n == 0)
            return;

        sums = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            add(i + 1, nums[i]);
        }
    }

    private int lowbit(int x) {
        return x & -x;
    }

    public void add(int ix, int diff) {
        while (ix < sums.length) {
            sums[ix] += diff;
            ix += lowbit(ix);
        }
    }

    public int sum(int ix) {
        int s = 0;
        while (ix > 0) {
            s += sums[ix];
            ix -= lowbit(ix);
        }
        return s;
    }
}
