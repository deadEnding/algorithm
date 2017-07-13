package custom.company.alibaba.internship;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 6:55 PM 3/3/17
 * @version: 1.0
 * @description: 正整数数组判断是否有三个位置可将数组分成4段，各段和相等（三个位置不计入任何一段）
 */

public class FourPartitionSolution {

    public boolean resolve(int[] nums) {
        if (nums == null || nums.length < 1)
            return false;

        if (nums.length == 3)
            return true;

        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(sums[0], 0);
        for (int i = 1; i < sums.length; ++i) {
            sums[i] = sums[i - 1] + nums[i];
            map.put(sums[i], i);
        }

        for (int i = 0; i < sums.length - 2; ++i) {
            int next = i;  // next + 1为分割点
            int count = 3;
            while (count-- > 0 && next + 1 < sums.length && (next = map.getOrDefault(sums[i] + sums[next + 1], -1)) > 0)
                if (count == 0 && next == nums.length - 1)
                    return true;

        }
        return false;
    }
}


class BasicSolution {

    static boolean resolve(int[] nums) {
        final int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = (i == 0 ? 0 : left[i - 1]) + nums[i];
            int j = n - 1 - i;
            right[j] = (j == n - 1 ? 0 : right[j + 1]) + nums[j];
        }

        int l = 1, r = n - 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = l + 2; i <= r - 2; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        while (l + 4 <= r) {
            if (left[l - 1] < right[r + 1]) {
                map.put(nums[l + 2], map.get(nums[l + 2]) - 1);
                l++;
            } else if (left[l - 1] > right[r + 1]) {
                map.put(nums[r - 2], map.get(nums[r - 2]) - 1);
                r--;
            } else {
                int part = left[l - 1];
                int range = left[r - 1] - left[l];
                if (map.getOrDefault(range - part * 2, 0) > 0) {
                    return true;
                }
                map.put(nums[l + 2], map.get(nums[l + 2]) - 1);
                map.put(nums[r - 2], map.get(nums[r - 2]) - 1);
                l++;
                r--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(new FourPartitionSolution().resolve(nums));
    }
}
