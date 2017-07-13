package leetcode.again.L268_MissingNumber;


public class Solution {
    public int missingNumber(int[] nums) {
        final int n = nums.length;
        long sum = (1 + n) * n / 2;
        for (int num : nums) {
            sum -= num;
        }
        return (int) sum;
    }
}
