package custom.templates.finalpractice;

/**
 * Created by deadend on 25/10/2017.
 */
public class BIT {

    private int[] sums;

    public BIT(int[] nums) {
        final int n = nums.length;
        sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            add(i, nums[i]);
        }
    }

    private int lowbit(int x) {
        return x & -x;
    }

    public void add(int ix, int delta) {
        ix++;
        while (ix < sums.length) {
            sums[ix] += delta;
            ix += lowbit(ix);
        }
    }

    public int sum(int ix) {
        ix++;
        int s = 0;
        while (ix > 0) {
            s += sums[ix];
            ix -= lowbit(ix);
        }
        return s;
    }
}
