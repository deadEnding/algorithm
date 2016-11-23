package leetcode.L229_MajorityElementII;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 9:16 AM 11/23/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0, count1 = 0;
        int candidate2 = 0, count2 = 0;

        for (int n : nums) {
            if (n == candidate1) {
                count1++;
            } else if (n == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = n;
                count1++;
            } else if (count2 == 0) {
                candidate2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;
        for (int n : nums) {
            if (n == candidate1) {
                count1++;
            } else if (n == candidate2) {
                count2++;
            }
        }

        List<Integer> result = new LinkedList<>();
        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            result.add(candidate2);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,2,1,1,3};
        System.out.println(new Solution().majorityElement(nums));
    }
}
