package leetcode.L229_MajorityElementII;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 6:46 PM 2/28/17
 * @version: 1.0
 * @description:
 */


public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int p1 = 0, p2 = 0;
        int c1 = 0, c2 = 0;
        for (int num : nums) {
            if (c1 > 0 && p1 == num) {
                c1++;
            } else if (c2 > 0 && p2 == num) {
                c2++;
            } else if (c1 == 0) {
                p1 = num;
                c1++;
            } else if (c2 == 0) {
                p2 = num;
                c2++;
            } else {
                c1--;
                c2--;
            }
        }

        c1 = c2 = 0;
        for (int num : nums) {
            if (p1 == num) {
                c1++;
            } else if (p2 == num) {
                c2++;
            }
        }

        List<Integer> result = new LinkedList<>();
        if (c1 > nums.length / 3) {
            result.add(p1);
        }
        if (c2 > nums.length / 3) {
            result.add(p2);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,2,1,1,3};
        System.out.println(new Solution().majorityElement(nums));
    }
}
