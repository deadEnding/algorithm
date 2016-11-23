package leetcode.L414_ThirdMaximumNumber;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author: deadend
 * @date: 3:25 PM 11/23/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> heap = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? -1 : (o1 < o2 ? 1 : 0);
            }
        });

        for (int n : nums) {
            heap.add(n);
        }

        if (heap.size() >= 3) {
            heap.pollFirst();
            heap.pollFirst();
        }
        return heap.pollFirst();
    }

    public static void main(String[] args) {
        int[] nums = {1,1,-2147483648,2};
        System.out.println(new Solution().thirdMax(nums));
    }
}

