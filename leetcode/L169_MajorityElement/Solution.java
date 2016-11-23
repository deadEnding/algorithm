package leetcode.L169_MajorityElement;

/**
 * @author: deadend
 * @date: 11:28 AM 11/22/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int majorityElement(int[] nums) {
        int cancidate = 0;
        for (int i = 0, count = 0; i < nums.length; i++) {
            if (count == 0) {
                cancidate = nums[i];
                count++;
            } else {
                count += nums[i] == cancidate ? 1 : -1;
            }
        }
        return cancidate;

    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(new BitSolution().majorityElement(nums));
    }
}


class BitSolution {
    public int majorityElement(int[] nums) {
        final int size = 32;
        int majority = 0;

        for (int i = 0; i < size; i++) {
            int bitCounter = 0;
            for (int n : nums) {
                bitCounter += (1 << i & n) != 0 ? 1 : 0;
            }

            if (bitCounter > nums.length / 2) {
                majority += 1 << i;
            }
        }
        return majority;
    }
}
