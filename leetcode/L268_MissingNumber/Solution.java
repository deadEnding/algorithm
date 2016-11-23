package leetcode.L268_MissingNumber;

/**
 * @author: deadend
 * @date: 9:56 AM 11/23/16
 * @version: 1.0
 * @description:
 */


public class Solution {
    public int missingNumber(int[] nums) {
        int max = 0, sum = 0;
        for (int n : nums) {
            max = Math.max(max, n);
            sum += n;
        }

        int result = max * (max + 1) / 2 - sum;
        return result == 0 ? (nums.length == max ? 0 : max + 1) : result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4, 0};
        System.out.println(new Solution().missingNumber(nums));
    }
}

class SumSolution {
    public int missingNumber(int[] nums) {
        int sum = nums.length * (nums.length + 1) / 2;
        for (int n : nums) {
            sum -= n;
        }
        return sum;
    }
}
