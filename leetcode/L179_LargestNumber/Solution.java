package leetcode.L179_LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: deadend
 * @date: P10:36 PM 12/7/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public String largestNumber(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return -s1.compareTo(s2);
            }
        });

        StringBuffer sb = new StringBuffer();
        for (int i : arr) {
            if (!(sb.length() == 0 && i == 0)) {
                sb.append(i);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
