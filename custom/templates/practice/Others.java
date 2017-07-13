package custom.templates.practice;

/**
 * @author: yuhui
 * @date: 18/06/2017
 */


public class Others {

    public int binarySearch(int[] nums, int s, int e, int target) {
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        return -1;
    }
}
