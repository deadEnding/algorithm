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
    private static Integer[] toIntegerArray(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        return arr;
    }

    public String largestNumber(int[] nums) {
        final int n = nums.length;
        Integer[] arr = toIntegerArray(nums);
        Arrays.sort(arr, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                String s1 = String.valueOf(i1);
                String s2 = String.valueOf(i2);
                return (s2 + s1).compareTo(s1 + s2);
            }
        });

        StringBuilder builder = new StringBuilder();
        for (Integer i : arr) {
            if (builder.length() == 0 && i == 0) {
                return "0";
            }
            builder.append(i);
        }
        return builder.toString();
    }
}

class OldSolution {
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
