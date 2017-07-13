package custom.templates;

/**
 * @author: deadend
 * @date: P10:26 AM 3/14/17
 * @version: 1.0
 * @description:
 */


public class BIT {

    private int[] sums;

    public BIT(int[] nums) {
        sums = new int[nums.length + 1];   // sums[0]未使用
        for (int i = 0; i < nums.length; i++) {
            add(i + 1, nums[i]);
        }
    }

    /**
     * 最低位的1对应的值
     * @param x
     * @return
     */
    private int lowbit(int x) {
        return x & -x;
    }

    /**
     * 将nums[ix - 1]元素的值增加diff（朝右上方向）
     * @param ix
     * @param diff
     */
    public void add(int ix, int diff) {
        while (ix < sums.length) {
            sums[ix] += diff;
            ix += lowbit(ix);
        }
    }

    /**
     * 返回nums[0:ix-1]整数和（朝左上方向）
     * @param ix
     * @return
     */
    public int sum(int ix) {
        int s = 0;
        while (ix > 0) {
            s += sums[ix];
            ix -= lowbit(ix);
        }
        return s;
    }
}
