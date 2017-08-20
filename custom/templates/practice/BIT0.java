package custom.templates.practice;

/**
 * Created by yuhui.zzc on 13/08/2017.
 */
public class BIT0 {

    private int[] sums;

    public BIT0(int[] nums) {
        final int n = nums.length;
        if (n == 0) {
            return;
        }

        sums = new int[n + 1];
    }

    private int lowBit(int x) {
        return x & -x;
    }

    public void add(int ix, int delta) {
        ix++;
        while (ix < sums.length) {
            sums[ix] += delta;
            ix += lowBit(ix);
        }
    }

    public void sum(int ix) {
        ix++;
        int sum = 0;
        while (ix > 0) {
            sum += sums[ix];
            ix -= lowBit(ix);
        }
    }
}
